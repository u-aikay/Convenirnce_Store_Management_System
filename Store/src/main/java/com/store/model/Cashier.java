package com.store.model;

import com.store.enums.Role;
import com.store.operations.CashierOperationImpl;
import org.w3c.dom.Node;

public class Cashier extends Staff{

    private Node front;
    private Node rear;
    private int currentSize;

    private class Node{
        int data;
        Node next;
    }
    public Cashier(String firstName, String lastName, String email, String phoneNumber, Role role) {
        super(firstName, lastName, email, phoneNumber, role);
        this.front = null;
        this.rear = null;
        this.currentSize = 0;
    }

    public void deductBalance(double amount){
        double walletBalance = amount;
    }
}

