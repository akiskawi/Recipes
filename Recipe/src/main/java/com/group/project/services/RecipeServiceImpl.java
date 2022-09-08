/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.services;

import com.group.project.models.Recipe;
import com.group.project.repository.RecipeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeServiceInterface {

    @Autowired
    RecipeRepo recipeRepo;
    
    @Override
    public void createRecipe(Recipe r) {
        recipeRepo.save(r);
    }

    @Override
    public Recipe showRecipe(Integer id) {
        return recipeRepo.findById(id).get();
    }

    @Override
    public Recipe updateRecipe(Recipe r) {
        return recipeRepo.save(r);
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipeRepo.deleteById(id);
    }

    @Override
    public List<Recipe> showAllRecipe() {
        return recipeRepo.findAll();
    }
    
}
