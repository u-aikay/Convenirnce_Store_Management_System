package com.store.model;

//import com.store.queue.CustomerQueue;
//import com.store.queue.CustomerQueueImpl;

import java.io.IOException;
import java.util.*;

public class Company {
    private String name;
    private String address;
    private int warehouseCapacity;
//    private CustomerQueue customerPriorityQueue;

    public String receipt;
    private Product[] productList;
    private final List<Applicant> applicants;
    private final List<Staff> staff;
    private double companyAccount;

    public Company(String name, String address) throws IOException {
        this.name = name;
        this.address = address;
        this.productList = new Product[0];
        this.receipt = receipt;
        this.applicants = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.warehouseCapacity = warehouseCapacity;
        stock = new HashMap<Product, Integer>();
//        this.customerPriorityQueue = new CustomerQueueImpl();
    }

    public double getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(double companyAccount) {
        this.companyAccount = companyAccount;
    }

    private Map<Product, Integer> stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Product[] getProductList() {
        return productList;}

//    public CustomerQueue getCustomerPriorityQueue() {
//        return customerPriorityQueue;
//    }
//
//    public void setCustomerPriorityQueue(CustomerQueue customerPriorityQueue) {
//        this.customerPriorityQueue = customerPriorityQueue;
//    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public int getWarehouseCapacity() {
        return warehouseCapacity = 1000;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStock(Product p, Integer quantity) {
        this.stock.put(p, quantity);
    }
    public Map<Product, Integer> getStock() {
        return stock;
    }

}
