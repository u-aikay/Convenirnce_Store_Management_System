package com.store.operations;

import com.store.model.Applicant;
import com.store.model.Company;
import com.store.exception.ApplicantNotQualifiedException;

public interface Application {
    boolean apply(Applicant applicant, Company company) throws ApplicantNotQualifiedException;
}
