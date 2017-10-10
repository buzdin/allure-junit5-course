package org.tapost.ws.sut;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class InternetShop {

    private static final Database db = new Database();
    private static Account session;
    private static ShoppingCart shoppingCart;

    public static Account login(String username, String password) {
        Account account = db.accounts.get(username);
        if (account.getPassword().equals(password)) {
            session = account;
            shoppingCart = new ShoppingCart();
            return account;
        }
        return null;
    }

    public static void logout() {
        session = null;
        shoppingCart = null;
    }

    /**
     * @return
     */
    public static List<Item> listItems() {
        return Lists.newArrayList(db.items.values());
    }

    /**
     * @return
     */
    public static Item viewItem(Long id) {
        return db.items.get(id);
    }

    /**
     * @return
     */
    public static List<Item> findItems(String searchString) {
        Preconditions.checkNotNull(searchString);

        return db.items.values().stream()
                .filter(i -> i.getDescription().matches(searchString))
                .collect(Collectors.toList());
    }

    /**
     * @return
     */
    public static void addToCart(Integer id, Integer quantity) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);
        Preconditions.checkArgument(quantity >= 1);
        Preconditions.checkArgument(quantity < 100);

        Item item = db.items.get(id);
        Preconditions.checkNotNull(item);

        shoppingCart.items.add(new ItemPosition(item, quantity));
        shoppingCart.total = shoppingCart.total.add(item.getPrice().multiply(new BigDecimal(quantity)));
    }

    /**
     * @return
     */
    public static ShoppingCart viewShoppingCart() {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);

        return shoppingCart;
    }

    /**
     * @return
     */
    public static String checkout(String shippingAddress) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);
        Preconditions.checkNotNull(shippingAddress);
        Preconditions.checkArgument(shoppingCart.total.compareTo(BigDecimal.ZERO) > 0);
        Preconditions.checkArgument(shoppingCart.items.size() > 0);
        Preconditions.checkArgument(shoppingCart.total.compareTo(session.balance) <= 0);

        session.balance = session.balance.subtract(shoppingCart.total);
        return "OK";
    }

    /**
     * @return
     */
    public static BigDecimal balance() {
        Preconditions.checkNotNull(session);

        return session.getBalance();
    }

    /**
     * @return
     */
    public static void topUpBalance(BigDecimal amount) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);
        Preconditions.checkNotNull(amount);
        Preconditions.checkArgument(amount.compareTo(BigDecimal.ZERO) > 0);

        session.balance = session.balance.add(amount);
    }

}
