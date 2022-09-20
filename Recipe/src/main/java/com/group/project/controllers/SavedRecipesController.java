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


    @PostMapping("/save/{userID}/{recipeID}")
    void saveRecipe(@PathVariable Integer userID,@PathVariable Integer recipeID){
        savedRecipesInterface.saveRecipe(userID,recipeID);
    }
}
