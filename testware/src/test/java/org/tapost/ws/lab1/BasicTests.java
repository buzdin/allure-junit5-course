package org.tapost.ws.lab1;

import org.junit.jupiter.api.Test;
import org.tapost.ws.sut.Account;
import org.tapost.ws.sut.InternetShop;
import org.tapost.ws.sut.Item;
import org.tapost.ws.sut.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public class BasicTests {

    @Test
    public void test() {
        System.out.println("I am a test case");

        List<Item> items = InternetShop.listItems();
        System.out.println(items);

        Account account = InternetShop.login("admin", "admin");
        System.out.println(account);

        InternetShop.topUpBalance(new BigDecimal(1.0));

        System.out.println(InternetShop.balance());

        List<Item> found = InternetShop.searchItems("Ice");
        InternetShop.addToCart(found.iterator().next().getId(), 10);
        ShoppingCart shoppingCart = InternetShop.viewShoppingCart();
        System.out.println(shoppingCart);

        String status = InternetShop.checkout("home address");
        System.out.println(status);

        System.out.println(account);

        System.out.println(InternetShop.balance());

        InternetShop.logout();
    }

}
