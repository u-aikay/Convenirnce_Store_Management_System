package com.store.operations;

import com.store.exception.StaffNotAuthorizedException;
import com.store.model.Staff;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exception.ApplicantNotQualifiedException;
import com.store.model.Applicant;
import com.store.model.Company;

public class HireApplicantImpl implements HireApplicant {

    @Override
    public void hire(Applicant applicant, Staff staff, Company company) throws ApplicantNotQualifiedException, StaffNotAuthorizedException {
        if(staff.getRole().equals(Role.MANAGER)){
            if (applicant.getQualification().equals(Qualification.BSC) || applicant.getQualification().equals(Qualification.HND)){
                addApplicantToStaffList(company, applicant);
            }else{
                throw new ApplicantNotQualifiedException ("Sorry, you are not qualified");
            }
        }else{
            throw new StaffNotAuthorizedException("Unauthorised operation, Please contact the manager");
        }
    }

    private void addApplicantToStaffList(Company company, Applicant applicant){
        Staff newStaff = new Staff(applicant.getFirstName(),applicant.getLastName(), applicant.getEmail(),applicant.getPhoneNumber(), applicant.getPositionApplied());


        company.getStaff().add(newStaff);
        company.getApplicants().remove(applicant);
    }
}
