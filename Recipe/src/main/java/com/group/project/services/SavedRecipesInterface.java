package com.group.project.services;

import com.group.project.models.Recipe;
import com.group.project.models.SavedRecipes;

import java.util.List;

public interface SavedRecipesInterface {
    void saveRecipe(Integer userID, Integer RecipeID);
    void saveRecipe(SavedRecipes savedRecipes);
    void setPaidForTrue(Integer userID, Integer recipeID);
    boolean exists(Integer userID, Integer recipeID);
    void buyRecipe(Integer userID, Integer recipeID);
    List<Recipe> getRecipesByUserIdAndPaidForAndName(Integer userID, boolean paidFor, String name);
    List<Recipe> getRecipesByUserIdAndPaidFor(Integer userID, boolean paidFor);
}
