package com.store.operations;

import com.store.exception.ApplicantNotQualifiedException;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Applicant;
import com.store.model.Company;
import com.store.model.Staff;

public interface HireApplicant {
    void hire(Applicant applicant, Staff staff, Company company) throws ApplicantNotQualifiedException, StaffNotAuthorizedException;
}
