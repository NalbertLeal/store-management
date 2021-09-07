package com.nalbertgml.monolith.models;

import org.springframework.data.annotation.Id;

public class Manager {
    @Id
    private Long id;
    private String fullname;
    private String email;
    private String password;
    private Double salary;

    public Manager() {
    }

    public Manager(String fullname, String email, String password, Double salary) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public Manager(Long id, String fullname, String email, String password, Double salary) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.salary = salary;
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
}
