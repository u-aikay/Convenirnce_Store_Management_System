package com.store.operations;

import com.store.enums.Role;
import com.store.exception.InsufficientFundException;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.*;
import java.util.Map;
import java.util.concurrent.Callable;

public class CashierOperationImpl implements CashierOperation{
    private double payment;
    private double amount = 0;


    @Override
    public Callable<String> sellToCustomer(Company company, Staff staff, Customer customer) throws InsufficientFundException, StaffNotAuthorizedException {
            Map<Product, Integer> cart = customer.getCart();
            double totalProductPrice = 0.00;
            double customerWallet = customer.getWallet().getBalance();
            double totalAmount = 0.00;
            if(!staff.getRole().equals(Role.CASHIER)){
                throw new StaffNotAuthorizedException("This operation is solely for the cashier");
            }else {
                try {
                    for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                        double productPrice = entry.getKey().getProductPrice();
                        int productQuantity = entry.getValue();
                        totalAmount = productPrice * productQuantity;
                        totalProductPrice += totalAmount;
                    }
                    amount = totalProductPrice;
                    if (totalProductPrice > customerWallet) {
                        throw new InsufficientFundException("Insufficient funds");
                    } else {
                        customerWallet -= totalProductPrice;
                        customer.getWallet().setBalance(customerWallet);
                    }
                } catch (InsufficientFundException e) {
                    System.out.println(e.getMessage());
                }
            }


            removeProductSold(customer.getCart(), company.getProductList());
            return printReceipt(company, staff, customer, amount, customerWallet);
    }

    private void removeProductSold(Map<Product, Integer> customerProduct, Product[] products){
        for(Map.Entry<Product, Integer>productBoughtByCustomer : customerProduct.entrySet()){
            String itemName = productBoughtByCustomer.getKey().getProductName();
            int itemUnit = productBoughtByCustomer.getValue();

            for(Product productInStore : products){
                if(productInStore.getProductName().equals(itemName)){
                    productInStore.setProductQuantity(productInStore.getProductQuantity()-itemUnit);
                }
            }
        }
    }


    private Callable<String> printReceipt(Company company, Staff staff, Customer customer, double expectedAmount, double payment) {
        Map<Product, Integer> cart = customer.getCart();

        String receipt = "***U-Mac Ventures sales receipt *** \n" +
                "Transaction Details\n" +
                "\n";
        for (Map.Entry<Product, Integer> each : cart.entrySet()) {
            receipt += "Product Name: " + each.getKey().getProductName() + "\n" +
                    "Price       : " + each.getKey().getProductPrice() + "\n" +
                    "Category    : " + each.getKey().getProductCategory() + "\n" +
                    "Units       : " + each.getValue() + "\n" +
                    "Cost        : " + (each.getKey().getProductPrice() * (double) each.getValue()) + "\n" +
                    "\n";
        }


        receipt += "Total Price: " + expectedAmount+ "\n" +
                "Amount paid: " + expectedAmount + "\n" +
                "---Thank you for shopping with us!--- \n \n";

        String finalReceipt = receipt;
        return ()-> Thread.currentThread().getName() + ": \n" + finalReceipt;
    }
}