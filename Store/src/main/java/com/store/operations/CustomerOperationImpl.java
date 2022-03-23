package com.store.operations;


import com.store.exception.OutOfStockException;
import com.store.model.Company;
import com.store.model.Customer;
import com.store.model.Product;

import java.util.Map;

public class CustomerOperationImpl implements CustomerOperations {

    @Override
    public void addProductToCart(Customer customer, String product, int quantity, Company company) {
        Product[] productList = company.getProductList();
        Map<Product, Integer> cartItems = customer.getCart();
        try {
            for (Product product1 : productList) {
                if (product1.getProductName().equalsIgnoreCase(product) && (product1.getProductQuantity() < quantity ||
                        product1.getProductQuantity() == 0)) {
                    throw new OutOfStockException("Out Of Stock");
                } else if (product1.getProductName().equalsIgnoreCase(product) && product1.getProductQuantity() >= quantity) {
                    cartItems.merge(product1, quantity, Integer::sum);
                }
            }
            System.out.println(customer.getCart());
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String fundWallet(Customer customer, double amount) {
        double newBalance = amount;
        customer.getWallet().setBalance(newBalance);
        return "Successfully added " + amount + " to wallet. Your new balance is " + customer.getWallet().getBalance();
    }
}
