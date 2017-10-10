package org.tapost.ws.sut;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Database {

    final Map<String, Account> accounts = new HashMap<>();
    final Map<Integer, Item> items = new HashMap<>();

    {
        accounts.put("admin",
                new Account(
                        "admin",
                        "admin",
                        "John",
                        "Doe",
                        "ADMIN",
                        new BigDecimal(1000.0))
        );
        accounts.put("user1",
                new Account(
                        "user1",
                        "pwd",
                        "Jane",
                        "Smith",
                        "ADMIN",
                        new BigDecimal(0.0))
        );
        accounts.put("user2",
                new Account(
                        "user2",
                        "pwd",
                        "Jack",
                        "Black",
                        "ADMIN",
                        new BigDecimal(0.0))
        );

        items.put(1, new Item(1, "Ice Cream", "Tasty Ice Cream", new BigDecimal(10.0)));
    }

}
