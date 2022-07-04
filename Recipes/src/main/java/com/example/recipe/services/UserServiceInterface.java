/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.recipe.services;

import com.example.recipe.models.User;

/**
 *
 * @author akisk
 */
public interface UserServiceInterface {

    void doRegister(User u);

    User getUserByName(String name);

    boolean isUserPassword(String password);

}
