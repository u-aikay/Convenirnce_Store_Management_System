package com.store.operations;

import com.store.enums.Role;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Company;
import com.store.model.Customer;
import com.store.model.Staff;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CashierOperationImplTest {
    Customer customer  = new Customer("Ikey","Arthur","Arthur@gmail.com","08098976980",Role.CUSTOMER);
    Company company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
    Staff manager;
    Staff cashier;

    public CashierOperationImplTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {
        manager = new Staff("Dante", "Idris","dantis@gmail.com","0907367467", Role.MANAGER);
        cashier = new Staff("Bola", "Felix","bolix@gmail.com","080682y82w",Role.CASHIER);
    }

    @Test
    public void shouldThrowExceptionWhenAStaffNotTheCashierTriesToSell() {
        CashierOperation cashierOperation = new CashierOperationImpl();
        assertThrows(StaffNotAuthorizedException.class, ()->cashierOperation.sellToCustomer(company,manager, customer));
    }
}
