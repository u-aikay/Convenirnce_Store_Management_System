package com.store.model;

import com.store.enums.Role;

public class Staff extends Person {
    private Role role;
    private String staffId;


    public Staff(String firstName, String lastName, String email, String phoneNumber, Role role) {
        super(firstName, lastName, email, phoneNumber);
        this.role = role;
        this.staffId = "Staff/234/003";
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }





    @Override
    public String toString() {
        return "Staff: {" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", address='" + getEmail()+ '\'' +
                ", phoneNumber='" + getPhoneNumber() +
                ", role=" + role +
                ", staffId='" + staffId + '\'' +
                '}';
    }
}
