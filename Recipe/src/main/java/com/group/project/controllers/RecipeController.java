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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author akisk
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeServiceInterface recipeServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;

    /*
    Get Form to Create a Recipe
     */
    @GetMapping("/add")
    public String createRecipe() {
        return "create";
    }

    /*
    Post Form to Create a Recipe
     */
    @PostMapping("/add")
    public String newRecipe(Model model, @RequestParam Recipe r) {
        recipeServiceInterface.createRecipe(r);
        return "productform";
    }

    /*
    Read a Recipe From an ID
     */
    @GetMapping("/{id}")
    public String showRecipe(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipeServiceInterface.showRecipe(id));
        return "recipeshow";
    }

    /*
    Get Form Update a Recipe From an ID
     */
    @GetMapping("/update/{id}")
    public String updateRecipe(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipeServiceInterface.showRecipe(id));
        return "updateRecipeForm";
    }

    /*
    Do Update a Recipe From an ID
     */
    @PostMapping("/update/{id}")
    public String doUpdateRecipe(@PathVariable Integer id, Model model, @RequestParam Recipe r) {
        Recipe updatedRecipe = recipeServiceInterface.updateRecipe(id, r);
        model.addAttribute("recipe", updatedRecipe);
        return "recipeshow";
    }

    /*
    Delete a Recipe From an ID
     */
    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Integer id) {
        return "showallrecipes";
    }

    /*
    Show all Recipes
     */
    @GetMapping("/all")
    public String showAllRecipes() {
        return "showAllRecipes";
    }

    /*
    Get User Recipes
     */
    @GetMapping("/user/{id}")
    public String showUserRecipes(@PathVariable Integer id,Model model) {
        List<Recipe> recipelist = recipeServiceInterface.showAllRecipeFromUser(userServiceInterface.getUserById(id));
        model.addAttribute(recipelist);
        return "redirect: /showAllRecipes";//ToDO
    }
}
