/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.project.repositories;

import com.group.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andreas
 */
public interface UserRepo extends JpaRepository<User, Integer> {
    
}
