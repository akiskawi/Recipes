/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.controllers;

import com.group.project.models.Recipe;
import com.group.project.services.RecipeServiceInterface;
import com.group.project.services.UserServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author akisk
 */
@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeServiceInterface recipeServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;

    /*
    Get All Recipes
     */
    @GetMapping("/all")
    List<Recipe> getAllRecipes() {
        return recipeServiceInterface.showAllRecipe();
    }

    /*
    Create a Recipe
     */
    @PostMapping("/")
    Recipe createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeServiceInterface.createRecipe(recipe);
        return createdRecipe;
    }

    /*
    Read a Recipe
     */
    @GetMapping("/{id}")
    Recipe getRecipeById(@PathVariable Integer id) {
        return recipeServiceInterface.getRecipeById(id);
    }

    /*
    Update a Recipe
     */
    @PutMapping("/{id}")
    Recipe updateRecipeById(@PathVariable Integer id, @RequestBody Recipe recipe) {
        return recipeServiceInterface.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    void deleteRecipeById(@PathVariable Integer id){
        recipeServiceInterface.deleteRecipe(id);
    }

}
