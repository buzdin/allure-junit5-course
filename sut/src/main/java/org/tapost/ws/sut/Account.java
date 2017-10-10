package org.tapost.ws.sut;

import java.math.BigDecimal;

public class Account {

    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    BigDecimal balance;

    public Account(String id, String password, String firstName, String lastName, String role, BigDecimal balance) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                '}';
    }
}
