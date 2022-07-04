/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.recipe.services;

import com.example.recipe.models.User;
import com.example.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userrepo;

    @Override
    public void doRegister(User u) {
        userrepo.save(u);
    }

    @Override
    public User getUserByName(String name) {
        return userrepo.findByName(name);
    }

    @Override
    public boolean isUserPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
