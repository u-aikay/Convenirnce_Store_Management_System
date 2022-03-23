package com.store.model;

import com.store.enums.Qualification;
import com.store.enums.Role;

public class Applicant extends Person{
    private Qualification qualification;
    private Role positionApplied;


    public Applicant(String firstName, String lastName, String email, String phoneNumber, Qualification qualification, Role positionApplied) {
        super(firstName, lastName, email, phoneNumber);
        this.qualification = qualification;
        this.positionApplied = positionApplied;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Role getPositionApplied() {
        return positionApplied;
    }

    public void setPositionApplied(Role positionApplied) {
        this.positionApplied = positionApplied;
    }

    @Override
    public String toString() {
        return "Applicant: {" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", address='" + getEmail()+ '\'' +
                ", phoneNumber='" + getPhoneNumber() +'\''+
                ", qualification=" + qualification +
                ", positionApplied=" + positionApplied +
                '}';
    }


}
