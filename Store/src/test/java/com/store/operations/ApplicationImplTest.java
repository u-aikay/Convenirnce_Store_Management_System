package com.store.operations;

import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exception.ApplicantNotQualifiedException;
import com.store.model.Applicant;
import com.store.model.Company;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ApplicationImplTest {
    Company company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
    Applicant applicant1 = new Applicant("Umar", "Ese", "ese@gmail.co", "07074658687", Qualification.BSC, Role.CASHIER); ;
    Applicant applicant2 = new Applicant("Umaru", "Tom", "Umaru@gmail.co", "07072659087", Qualification.MSC, Role.CASHIER);;
    ApplicationImpl applicationImpl = new ApplicationImpl();

    public ApplicationImplTest() throws IOException {
    }


    @Before
    public void setUp() throws ApplicantNotQualifiedException {
    }

    @Test
    public void apply() throws ApplicantNotQualifiedException {
        int beforeAdding = company.getApplicants().size();
        applicationImpl.apply(applicant1, company);
        int afterAdding = company.getApplicants().size();
        assertTrue(beforeAdding < afterAdding);
    }

    @Test
    public void checkApplicantException() throws ApplicantNotQualifiedException {
        assertThrows(ApplicantNotQualifiedException.class, () ->  applicationImpl.apply(applicant2, company));
    }
}