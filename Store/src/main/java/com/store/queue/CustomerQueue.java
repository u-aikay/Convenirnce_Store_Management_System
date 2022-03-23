package com.store.queue;

import com.store.model.Customer;

public interface CustomerQueue {
    boolean isEmpty();

    //To remove from the beginning of a list.
    void removeFromQueue();

    //To add data at the end of the list.
    void addToQueue(Customer customer);


    //To check for the top of the queue.
    Customer peek();

    // To check for the size of the queue
    int size();
}
