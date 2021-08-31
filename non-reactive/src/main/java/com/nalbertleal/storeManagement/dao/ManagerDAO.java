package com.nalbertleal.storeManagement.dao;

import com.nalbertleal.storeManagement.model.Manager;

public class ManagerDAO {
    public String fullname;
    public String email;
    public String password;
    public Double salary;
    public boolean success;

    public ManagerDAO(boolean success) {
        this.success = success;
    }

    public ManagerDAO(String fullname, String email, String password, Double salary) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.success = true;
    }

    public static ManagerDAO fromManager(Manager manager) {
        return new ManagerDAO(
            manager.getFullname(),
            manager.getEmail(),
            manager.getPassword(),
            manager.getSalary()
        );
    }

    public Manager toManager() {
        return new Manager(
            fullname,
            email,
            password,
            salary
        );
    }
}
