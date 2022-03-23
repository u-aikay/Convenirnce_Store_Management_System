package com.store.operations;

import com.store.exception.OutOfStockException;
import com.store.model.Company;
import com.store.model.Customer;
import com.store.model.Product;

import java.util.Map;

public interface CustomerOperations {
    void addProductToCart(Customer customer, String product, int quantity, Company company) throws OutOfStockException;


    String fundWallet(Customer customer, double amount);
}
