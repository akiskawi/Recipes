package com.group.project.controllers;

import com.group.project.services.SavedRecipesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/savedRecipes")
public class SavedRecipesController {

    @Autowired
    SavedRecipesInterface savedRecipesInterface;

    /*
    Creates a SavedRecipes obj and sets paidFor value 'true'.
     */
    @PostMapping("/buy/{userID}/{recipeID}")
    void buyRecipe(@PathVariable Integer userID,@PathVariable Integer recipeID){
        savedRecipesInterface.buyRecipe(userID, recipeID);
    }

    /*
    Creates a SavedRecipes obj and sets paidFor value 'false'.
     */
    @PostMapping("/save/{userID}/{recipeID}")
    void saveRecipe(@PathVariable Integer userID,@PathVariable Integer recipeID){
        savedRecipesInterface.saveRecipe(userID, recipeID);
    }

    /*
    Finds a SavedRecipes obj and sets paidFor value 'true'.
     */
    @PostMapping("/update/{userID}/{recipeID}")
    void setPaidForTrue(@PathVariable Integer userID, @PathVariable Integer recipeID){
        savedRecipesInterface.setPaidForTrue(userID,recipeID);
    }

    /*
    Checks, if a SavedRecipes obj exists.
     */
    @GetMapping("/check/{userID}/{recipeID}")
    boolean exists(@PathVariable Integer userID, @PathVariable Integer recipeID){
        return savedRecipesInterface.exists(userID, recipeID);
    }
}
