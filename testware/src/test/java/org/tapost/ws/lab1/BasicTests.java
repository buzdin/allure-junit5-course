package org.tapost.ws.lab1;

import org.junit.jupiter.api.Test;
import org.tapost.ws.sut.Account;
import org.tapost.ws.sut.InternetShop;
import org.tapost.ws.sut.Item;
import org.tapost.ws.sut.ShoppingCart;

import java.util.List;

public class BasicTests {

    @Test
    public void test() {
        System.out.println("I am a test case");

        List<Item> items = InternetShop.listItems();
        System.out.println(items);

        Account account = InternetShop.login("admin", "admin");
        System.out.println(account);

        InternetShop.addToCart(1, 10);
        ShoppingCart shoppingCart = InternetShop.viewShoppingCart();
        System.out.println(shoppingCart);

        String status = InternetShop.checkout("home address");
        System.out.println(status);

        System.out.println(account);

        InternetShop.logout();
    }

}
