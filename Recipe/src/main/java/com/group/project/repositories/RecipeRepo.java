/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.repositories;

import com.group.project.models.Recipe;
import com.group.project.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author akisk
 */

public interface RecipeRepo extends JpaRepository<Recipe, Integer>  {
    
    List<Recipe> findAllByOwnerId(User User);
    List<Recipe> findAllByPaid(boolean b);
    List<Recipe> findAllByNameContainsIgnoreCase(String string);
}
