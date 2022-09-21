package com.group.project.services;

import com.group.project.models.Recipe;
import com.group.project.models.SavedRecipes;
import com.group.project.models.User;
import com.group.project.repositories.SavedRecipesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        sR.setPaidFor(false);
        savedRecipesRepo.save(sR);
    }

    @Override
    public void saveRecipe(SavedRecipes savedRecipes) {
        savedRecipesRepo.save(savedRecipes);
    }

    @Override
    public void setPaidForTrue(Integer userID, Integer recipeID){
        User user = userService.getUserById(userID);
        Recipe recipe = recipeService.getRecipeById(recipeID);
        SavedRecipes sR = savedRecipesRepo.findByUserIdAndRecipeId(user,recipe);
        sR.setPaidFor(true);
        savedRecipesRepo.save(sR);
    }

    @Override
    public boolean exists(Integer userID, Integer recipeID){
        User user = userService.getUserById(userID);
        Recipe recipe = recipeService.getRecipeById(recipeID);
        return (savedRecipesRepo.findByUserIdAndRecipeId(user, recipe) != null);
    }

    @Override
    public void buyRecipe(Integer userID, Integer recipeID){
        SavedRecipes sR = new SavedRecipes();
        sR.setPaidFor(true);
        sR.setRecipeId(recipeService.getRecipeById(recipeID));
        sR.setUserId(userService.getUserById(userID));
        savedRecipesRepo.save(sR);
    }

}
