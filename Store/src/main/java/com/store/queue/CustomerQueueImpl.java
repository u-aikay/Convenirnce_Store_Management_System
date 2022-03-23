package com.store.queue;

import com.store.model.Customer;
import lombok.ToString;

@ToString
public class CustomerQueueImpl implements CustomerQueue{
    private Node front;
    private int currentSize;

    @ToString
    private static class Node{
        Customer customer;
        Node next;
    }

    @Override
    public boolean isEmpty(){
        return currentSize == 0;
    }

    //To remove from the beginning of a list.
    @Override
    public void removeFromQueue(){
        Customer customer = front.customer;
        front = front.next;
        currentSize--;
    }

    private boolean shouldComeInFront(Node a, Node b){
        var customer1product = a.customer.getCart().entrySet().iterator().next();
        var customer2product = b.customer.getCart().entrySet().iterator().next();
        return customer1product.getKey().equals(customer2product.getKey()) &&
                customer1product.getValue() > customer2product.getValue();
    }



    //To add data at the end of the list.
    @Override
    public void addToQueue(Customer customer){
        Node newNode = new Node();
        newNode.customer = customer;

        Node previous = null;
        Node current = front;
        if (isEmpty()) {front = newNode;}
        else if (currentSize == 1){
            if (shouldComeInFront(front, newNode)){
                newNode.next = front;
                front = newNode;
            } else {
                newNode.next = null;
                front.next = newNode;
            }
        } else {
            for (int i = 0; i < currentSize; i++){
                if (shouldComeInFront(current, newNode)){
                    if (i == 0){
                        newNode.next = front;
                        front = newNode;
                    } else {
                        newNode.next = current;
                        previous.next = newNode;
                    }
                    break;
                } else if (current.next == null){
                    current.next = newNode;
                    newNode.next = null;
                }

                previous = current;
                current = current.next;
            }
        }
        currentSize++;
    }

    //To check for the top of the queue.
    @Override
    public Customer peek(){
        if(isEmpty()) return null;
        return front.customer;
    }

    // To check for the size of the queue
    @Override
    public int size(){
        return currentSize;
    }

    public boolean hasNext() {
        return currentSize > 0;
    }
}
