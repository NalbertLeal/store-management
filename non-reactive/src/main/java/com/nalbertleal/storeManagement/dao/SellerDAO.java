package com.nalbertleal.storeManagement.dao;

import com.nalbertleal.storeManagement.model.Seller;

public class SellerDAO {
    public String fullname;
    public String email;
    public String password;
    public Double salary;
    public String managerEmail;
    public boolean success;

    public SellerDAO(boolean success) {
        this.success = success;
    }

    public SellerDAO(String fullname, String email, String password, Double salary, String managerEmail) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.managerEmail = managerEmail;
        this.success = true;
    }

    public static SellerDAO fromSeller(Seller seller) {
        return new SellerDAO(
            seller.getFullname(),
            seller.getEmail(),
            seller.getPassword(),
            seller.getSalary(),
            seller.getManagerEmail()
        );
    }

    public Seller toSeller() {
        return new Seller(
            fullname,
            email,
            password,
            salary,
            managerEmail
        );
    }
}
