package com.store.operations;

import com.store.exception.ApplicantNotQualifiedException;
import com.store.model.Applicant;
import com.store.model.Company;
import com.store.enums.Qualification;

public class ApplicationImpl implements Application {

    @Override
    public boolean apply(Applicant applicant, Company company) throws ApplicantNotQualifiedException {

        if(!(applicant.getQualification().equals(Qualification.BSC) || applicant.getQualification().equals(Qualification.HND))) {
            throw new ApplicantNotQualifiedException("Sorry, this position is only for Bsc and HND holders.");
        } else {
            company.getApplicants().add(applicant);
            System.out.println("Hello " + applicant.getFirstName() + ", You have successfully applied for the role of a CASHIER at U-Mac ventures. \nWe'll get back to you shortly" );
        }
        return false;
    }
}
