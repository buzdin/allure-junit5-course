package org.tapost.ws.sut;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class InternetShop {

    private static final Logger log = LoggerFactory.getLogger("SHOP");

    private static final Database db = new Database();
    private static Account session;
    private static ShoppingCart shoppingCart;

    /**
     * Performs login to internet shop
     *
     * @param username user id
     * @param password password
     * @return account of a user or null if authentication failed
     */
    public static Account login(String username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);

        log.info("logging in user : {}", username);

        Account account = db.accounts.get(username);
        if (account.getPassword().equals(password)) {
            session = account;
            shoppingCart = new ShoppingCart();
            return account;
        }
        return null;
    }

    /**
     * Logs out user, who is logged-in currently
     */
    public static void logout() {
        log.info("logging out user");
        session = null;
        shoppingCart = null;
    }

    /**
     * Lists all items for sale
     *
     * @return list of items available for sale
     */
    public static List<Item> listItems() {
        log.info("listing all items");
        return Lists.newArrayList(db.items.values());
    }

    /**
     * Returns item by unique id
     *
     * @return immutable item details
     */
    public static Item viewItem(Integer id) {
        Preconditions.checkNotNull(id);

        log.info("looking for item by id : {}", id);
        Item item = db.items.get(id);
        Preconditions.checkNotNull(item, "Item does not exist : " + id);

        return clone(item);
    }

    private static Item clone(Item item) {
        return new Item(item.getId(), item.getName(), item.getDescription(), item.getPrice());
    }

    /**
     * Retrieves items, which description is matching by string
     *
     * @return list of immutable items or empty list
     */
    public static List<Item> searchItems(String searchString) {
        Preconditions.checkNotNull(searchString);
        log.info("Performing item search : {}", searchString);

        return db.items.values().stream()
                .filter(i -> i.getDescription().contains(searchString))
                .map(InternetShop::clone)
                .collect(Collectors.toList());
    }

    /**
     * Add item to shopping cart
     *
     * @param id item identifier
     * @param quantity how many items to add
     */
    public static void addToCart(Integer id, Integer quantity) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);
        Preconditions.checkNotNull(id);
        Preconditions.checkArgument(quantity >= 1);
        Preconditions.checkArgument(quantity < 100);

        Item item = db.items.get(id);
        Preconditions.checkNotNull(item, "Item does not exist : " + id);

        log.info("Adding item to cart: {}", item.getName());

        shoppingCart.items.add(new ItemPosition(item, quantity));
        shoppingCart.total = shoppingCart.total.add(item.getPrice().multiply(new BigDecimal(quantity)));
    }

    /**
     * View shopping cart contents
     *
     * @return shopping cart object
     */
    public static ShoppingCart viewShoppingCart() {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);

        log.info("Viewing shopping cart with total : {}", shoppingCart.getTotal());

        return shoppingCart;
    }

    /**
     * Checkout current items in the shopping cart
     *
     * @param shippingAddress where to ship
     * @return status 'OK' if everything went fine
     */
    public static String checkout(String shippingAddress) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);
        Preconditions.checkNotNull(shippingAddress);
        Preconditions.checkArgument(shoppingCart.total.compareTo(BigDecimal.ZERO) > 0);
        Preconditions.checkArgument(shoppingCart.items.size() > 0);
        Preconditions.checkArgument(shoppingCart.total.compareTo(session.balance) <= 0);

        log.info("Performing checkout with total price : {}", shoppingCart.total);

        session.balance = session.balance.subtract(shoppingCart.total);
        return "OK";
    }

    /**
     * Check current user balance
     *
     * @return balance
     */
    public static BigDecimal balance() {
        Preconditions.checkNotNull(session);

        log.info("Checking balance : {}", session.balance);

        return session.balance;
    }

    /**
     * Top up client account with additional funds
     *
     * @param amount money to add
     */
    public static void topUpBalance(BigDecimal amount) {
        Preconditions.checkNotNull(session);
        Preconditions.checkNotNull(shoppingCart);
        Preconditions.checkNotNull(amount);
        Preconditions.checkArgument(amount.compareTo(BigDecimal.ZERO) > 0);

        session.balance = session.balance.add(amount);

        log.info("Balance after top up : {}", session.balance);
    }

}
