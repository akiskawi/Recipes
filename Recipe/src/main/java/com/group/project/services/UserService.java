/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.services;

import com.group.project.models.User;
import com.group.project.repositories.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andreas
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public void createUser(User u) {
        userRepo.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void updateUser(User u) {
        User t = userRepo.findById(u.getId()).get();
        if (t!=null) {
            t.setName(u.getName());
            t.setPassword(u.getPassword());
            t.setEmail(u.getEmail());
            t.setRole(u.getRole());
            userRepo.save(t);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        User t = userRepo.findById(id).get();
        if (t!=null) {
            userRepo.delete(t);
        }
    }
    
}
