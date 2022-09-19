/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.project.repositories;

import com.group.project.dto.UserDTO;
import com.group.project.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Andreas
 */
public interface UserRepo extends JpaRepository<User, Integer> {
    
    @Query("SELECT u FROM User u")
    List<UserDTO> findAllUsers();
    
    List<UserDTO> findByNameContainingIgnoreCase(String name);
    
}
