/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.controllers;

import com.group.project.models.Recipe;
import com.group.project.services.RecipeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author akisk
 */
@Controller
public class RecipeController {

    @Autowired
    RecipeServiceInterface recipeServiceInterface;

    /*
    Get Form to Create a Recipe
     */
    @GetMapping("/createrecipe")
    public String createRecipe() {
        return "create";
    }

    /*
    Post Form to Create a Recipe
     */
    @PostMapping("/createrecipe")
    public String newRecipe(Model model, @RequestParam Recipe r) {
        recipeServiceInterface.createRecipe(r);
        return "productform";
    }

    /*
    Read a Recipe From an ID
     */
    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipeServiceInterface.showRecipe(id));
        return "recipeshow";
    }

    /*
    Get Form Update a Recipe From an ID
     */
    @GetMapping("/updaterecipe/{id}")
    public String updateRecipe(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipeServiceInterface.showRecipe(id));
        return "updateRecipeForm";
    }
    /*
    Do Update a Recipe From an ID
     */
    @PostMapping("/updaterecipe/{id}")
    public String doUpdateRecipe(@PathVariable Integer id, Model model,@RequestParam Recipe r) {
        model.addAttribute("recipe", recipeServiceInterface.showRecipe(id));
        Recipe updatedRecipe = recipeServiceInterface.updateRecipe(r);
        model.addAttribute("recipe", updatedRecipe);
        return "recipeshow";
    }
    /*
    Delete a Recipe From an ID
    */
    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Integer id){
        return "showallrecipes";
    }
    
    /*
    Show all Recipes
    */
    @GetMapping("/recipes")
    public String showAllRecipes(){
        return "showAllRecipes";
    }
}
