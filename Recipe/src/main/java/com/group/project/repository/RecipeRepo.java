/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.repository;

import com.group.project.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author akisk
 */

public interface RecipeRepo extends JpaRepository<Recipe, Integer>  {
    
}
