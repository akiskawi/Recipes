/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.project.services;

import com.group.project.models.Recipe;
import com.group.project.models.User;
import java.util.List;

/**
 *
 * @author akisk
 */
public interface RecipeServiceInterface {

    void createRecipe(Recipe r);

    Recipe showRecipe(Integer id);

    Recipe updateRecipe(Integer id, Recipe r);

    void deleteRecipe(Integer id);

    List<Recipe> showAllRecipe();
    
    List<Recipe> showAllRecipeFromUser(User u);
}
