package com.store.operations;

import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Company;
import com.store.model.Staff;

import java.io.IOException;

public interface AdminOperation {
    void restock(Staff staff, Company company) throws StaffNotAuthorizedException, IOException;
}
