package com.store.model;

import com.store.enums.Role;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Customer extends Person {
    private Role roles;
    private Map<Product, Integer> cart;
    private final Wallet wallet;

    public Customer(String firstName, String lastName, String email, String phoneNumber, Role roles) {
        super(firstName, lastName, email, phoneNumber);
        this.cart = new HashMap<>();
        this.roles = roles;
        this.wallet = new Wallet();

    }

    public Wallet getWallet() {
        return wallet;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

//    public void setCart(Product product, Integer quantity) {
//        this.cart = cart;
//    }


}
