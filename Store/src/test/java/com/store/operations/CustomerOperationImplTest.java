package com.store.operations;

import com.store.enums.Role;
import com.store.exception.OutOfStockException;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Company;
import com.store.model.Customer;
import com.store.model.Product;
import com.store.model.Staff;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CustomerOperationImplTest {

    Map<Product, Integer> customerCart;
    Customer customer;
    Company company;
    CustomerOperationImpl customerOperationIml;
    int quantity;
    Staff staff;

    @Before
    public void setUp() throws IOException {
        customerCart = new HashMap<>();
        customerOperationIml = new CustomerOperationImpl();
        staff = new Staff("loriem","ipsium","domanti","087927938",Role.MANAGER);
        company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
        customer  = new Customer("Ikey","Arthur","Arthur@gmail.com","08098976980",Role.CUSTOMER);
        quantity = 50;
    }

    @Test
    public void shouldThrowOutOfStockExceptionWhenProductInStockIsLessThanInputedQuantity() throws OutOfStockException, StaffNotAuthorizedException, IOException {
        AdminOperationImpl adminOperation = new AdminOperationImpl();
        adminOperation.restock(staff,company);
        assertThrows(OutOfStockException.class, ()-> customerOperationIml.addProductToCart(customer, "Nike",50,company)
        );
    }

    @Test
    public void countOfProductsAddedToCustomerCart() throws StaffNotAuthorizedException, IOException {
        AdminOperationImpl adminOperation = new AdminOperationImpl();
        adminOperation.restock(staff,company);
        customerOperationIml.addProductToCart(customer,"Nike",5,company);
        customerOperationIml.addProductToCart(customer,"Gucci",5,company);
        int afterAddingProductToCart = customer.getCart().size();
        assertEquals(2, afterAddingProductToCart);
    }


}
