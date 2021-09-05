package com.nalbertgml.usersmicroservice.models;

import org.springframework.data.annotation.Id;

public class Seller {
    @Id
    private Long id;
    private String fullname;
    private String email;
    private String password;
    private Double salary;
    private String managerEmail;

    public Seller() {
    }

    public Seller(String fullname, String email, String password, Double salary, String managerEmail) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.managerEmail = managerEmail;
    }

    public Seller(Long id, String fullname, String email, String password, Double salary, String managerEmail) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.managerEmail = managerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }
}