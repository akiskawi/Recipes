/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.services;

import com.group.project.models.Recipe;
import com.group.project.models.User;
import com.group.project.repositories.RecipeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeServiceInterface {

    @Autowired
    RecipeRepo recipeRepo;

    @Override
    public Recipe createRecipe(Recipe r) {
        recipeRepo.save(r);
        return recipeRepo.findById(r.getId()).get();
    }

    @Override
    public Recipe getRecipeById(Integer id) {
        return recipeRepo.findById(id).get();
    }

    @Override
    public Recipe updateRecipe(Integer id, Recipe r) {
        Recipe updateRecipe = getRecipeById(id);
        updateRecipe.setName(r.getName());
        updateRecipe.setInstructions(r.getInstructions());
        updateRecipe.setUtensils(r.getUtensils());
        updateRecipe.setDescription(r.getDescription());
        updateRecipe.setPhoto(r.getPhoto());
        updateRecipe.setVideo(r.getVideo());
        updateRecipe.setType(r.getType());
        return recipeRepo.save(updateRecipe);
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipeRepo.deleteById(id);
    }

    @Override
    public List<Recipe> showAllRecipe() {
        return recipeRepo.findAll();
    }

    @Override
    public List<Recipe> showAllRecipeFromUser(User u) {
        return recipeRepo.findByOwnerId(u);
    }

    
}
