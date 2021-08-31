package com.nalbertleal.storeManagement.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenService {
    private String secret = "123456";
    private int expiration = 1800000;

    public String generateToken(String email) {
        return Jwts
                .builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
