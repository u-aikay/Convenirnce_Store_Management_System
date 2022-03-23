package com.store.operations;

import com.store.enums.Role;
import com.store.exception.OutOfStockException;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Company;
import com.store.model.Product;
import com.store.model.Staff;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AdminOperationImplTest {
    Company company;
    Staff manager;
    Staff cashier;

    @Before
    public void setUp() throws StaffNotAuthorizedException, IOException {
        manager = new Staff("Dante", "Idris","dantis@gmail.com","0907367467", Role.MANAGER);
        cashier = new Staff("Bola", "Felix","bolix@gmail.com","080682y82w",Role.CASHIER);
        company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
    }

    @Test
    public void shouldThrowStaffNotAuthorisedExceptionWhenDifferentStaffThanManagerRestock(){
        AdminOperationImpl adminOperation = new AdminOperationImpl();
        assertThrows(StaffNotAuthorizedException.class, ()->adminOperation.restock(cashier,company));
    }

    @Test
    public void shouldPassIfProductAddedToCartIncreasesAfterRestockIsCalled() throws StaffNotAuthorizedException, IOException {
        int beforeAddingProductToProductList = company.getProductList().length;
        AdminOperationImpl adminOperation = new AdminOperationImpl();
        adminOperation.restock(manager,company);
        int afterAddingProductToProductList = company.getProductList().length;
        assertTrue(beforeAddingProductToProductList < afterAddingProductToProductList);
        assertEquals(12, afterAddingProductToProductList);
    }
}