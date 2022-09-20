package com.group.project.services;

import com.group.project.models.SavedRecipes;
import com.group.project.repositories.SavedRecipesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavedRecipesImpl implements SavedRecipesInterface {

    @Autowired
    SavedRecipesRepo savedRecipesRepo;

    @Autowired
    UserServiceInterface userService;
    RecipeServiceInterface recipeService;

    @Override
    public void saveRecipe(Integer userID, Integer recipeID) {
        SavedRecipes sR = new SavedRecipes();
        sR.setRecipeId(recipeService.getRecipeById(recipeID));
        sR.setUserId(userService.getUserById(recipeID));
        sR.setPaidFor(null);
        savedRecipesRepo.save(sR);
    }
}
