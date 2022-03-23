package com.store.queue;

import com.store.enums.Role;
import com.store.model.Company;
import com.store.model.Customer;
import com.store.model.Staff;
import com.store.operations.CashierOperation;
import com.store.operations.CashierOperationImpl;
import com.store.operations.CustomerOperationImpl;
import com.store.operations.CustomerOperations;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerQueueImplTest {
    Company company;
    CustomerQueue customerQueue;
    Customer customer1;
    Customer customer2;
    Customer customer3;
    Staff cashier;
    CustomerOperations customerOperation;

    @Before
    public void setUp() throws Exception {
        company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
        customerQueue = new CustomerQueueImpl();
        customer1 = new Customer("Smog","Shola", "ssmog@gmail.com", "893083o3ieo", 1500000, Role.CUSTOMER);
        customer2 = new Customer("Derick","Hole", "dsmog@gmail.com", "893083o3ieo", 1500000, Role.CUSTOMER);
        customer3 = new Customer("Derick","Hole", "dsmog@gmail.com", "893083o3ieo", 1500000, Role.CUSTOMER);
        cashier = new Staff("Francis", "Mark", "frmac@gail.com", "090737478", Role.CASHIER);
        customerOperation = new CustomerOperationImpl();
    }

    @Test
    public void shouldPassIfQueueSizeChangesAfterCustomerWasAddedToQueue() {
        int beforeAddingToTheQueue = customerQueue.size();
        customerQueue.addToQueue(customer1);
        int afterAddingCustomerToQueue = customerQueue.size();
        assertFalse(afterAddingCustomerToQueue == beforeAddingToTheQueue);

    }

    @Test
    public void ShouldConfirmThatTheFrontCustomerWasRemovedFromTheQueue() {

        customerQueue.addToQueue(customer1);
        int beforeRemovingFromQueue = customerQueue.size();
        customerQueue.removeFromQueue();
        int afterRemovingFromQueue = customerQueue.size();
        assertTrue(beforeRemovingFromQueue > afterRemovingFromQueue);
    }

//    @Test
//    public void peek() {
////        customerQueue.addToQueue(customer1);
////        customerQueue.addToQueue(customer2);
////        customerQueue.addToQueue(customer3);
////        assertTrue(customerQueue.peek() == customer1);
//    }
}