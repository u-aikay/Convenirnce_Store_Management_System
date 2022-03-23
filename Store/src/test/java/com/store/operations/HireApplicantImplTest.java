package com.store.operations;

import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exception.ApplicantNotQualifiedException;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Applicant;
import com.store.model.Company;
import com.store.model.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HireApplicantImplTest {
    Applicant applicant1;
    Applicant applicant2;
    Staff staff1;
    Staff staff2;
    Company company;
    HireApplicantImpl hireApplicant;

    @Before
    public void setUp() throws Exception {
        applicant1 = new Applicant("Isioma","Hendrick","isioma@gmail.com","09082573567", Qualification.BSC, Role.CASHIER);
        applicant2 = new Applicant("Jerry","Watford","jwat@gmail.com","09083923739", Qualification.MSC, Role.CASHIER);
        company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
        hireApplicant = new HireApplicantImpl();
        staff1 = new Staff("Francis", "Mark", "frmac@gail.com", "090737478", Role.MANAGER);
        staff2 = new Staff("Francis", "Mark", "frmac@gail.com", "090737478", Role.CASHIER);
    }

    @Test
    public void shouldThrowApplicantNotQualifiedExceptionWhenHiring() throws ApplicantNotQualifiedException {

        assertThrows(ApplicantNotQualifiedException.class, ()->{
            hireApplicant.hire(applicant2,staff1,company);
        });
    }

    @Test
    public void shouldThrowStaffNotAuthorizedExceptionWhenAnyOtherStaffNotManagerTriesToHire() throws StaffNotAuthorizedException {
        assertThrows(StaffNotAuthorizedException.class, ()->{
            hireApplicant.hire(applicant1, staff2, company);
        });
    }

    @Test
    public void checkIfWasAddedToStaffList() throws ApplicantNotQualifiedException, StaffNotAuthorizedException {
        int beforeAddingNewApplicantToStaffList = company.getStaff().size();
        hireApplicant.hire(applicant1,staff1,company);
        int afterAddingNewAddingNewApplicantToStaffList = company.getStaff().size();
        assertTrue(beforeAddingNewApplicantToStaffList < afterAddingNewAddingNewApplicantToStaffList);
    }
}
