package com.example.Employees.Model.entity;

public class Employees {
    private int ID;
    private String fullName;
    private String email;
    private String department;

    public Employees() {
    }

    public Employees(int ID, String fullName, String email, String department) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
