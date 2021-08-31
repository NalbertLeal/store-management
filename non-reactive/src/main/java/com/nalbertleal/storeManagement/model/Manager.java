package com.nalbertleal.storeManagement.model;

import javax.persistence.*;

@Entity
@Table
public class Manager {
    @Id
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "manager_sequence"
    )
    @Column(
            name = "id",
            columnDefinition = "BIGINT",
            updatable = false
    )
    private Long id;
    @Column(
            name = "fullname",
            columnDefinition = "TEXT"
    )
    private String fullname;
    @Column(
            name = "email",
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "password",
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name = "salary",
            columnDefinition = "FLOAT"
    )
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
