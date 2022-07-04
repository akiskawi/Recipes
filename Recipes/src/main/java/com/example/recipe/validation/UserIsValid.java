/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.recipe.validation;

import java.util.Base64;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

/**
 *
 * @author akisk
 */
public class UserIsValid {

    static Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(8, 32, 1, 64 * 1024, 1);

    public static String hashPassword(String userPassword) {
        String encodedString = Base64.getEncoder().encodeToString(userPassword.getBytes());
//        return (encoder.encode(userPassword));
        return (encodedString);
    }

    public static boolean validPassword(String userPassword, String dbPassword) {
        return userPassword.equals(decodePassword(dbPassword));
    }

    private static String decodePassword(String dbPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(dbPassword);
        String decodedPassword = new String(decodedBytes);
        return decodedPassword;
    }

    public static boolean validName(String userName, String dbName) {
        return userName.equals(dbName);

    }
}
