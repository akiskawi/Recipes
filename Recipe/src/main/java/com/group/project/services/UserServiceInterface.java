/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.project.services;

import com.group.project.models.User;
import java.util.List;

/**
 *
 * @author Andreas
 */
public interface UserServiceInterface {
    
    public void createUser(User u);
    
    public List<User> getAllUsers();
    
    public User getUserById(Integer id);
    
    public void updateUser(User u);
    
    public void deleteUser(Integer id);
    
}
