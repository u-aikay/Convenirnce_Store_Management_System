package com.store.operations;

import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Company;
import com.store.model.Customer;
import com.store.model.Staff;

import java.util.concurrent.Callable;

public interface CashierOperation {


    Callable<String> sellToCustomer(Company company, Staff staff, Customer customer) throws StaffNotAuthorizedException;

}
