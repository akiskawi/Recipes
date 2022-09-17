/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.services;

import com.group.project.dto.RecipeDTO;
import com.group.project.models.Recipe;
import com.group.project.models.User;
import com.group.project.repositories.BoughtRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mhtso
 */
@Service
public class BoughtServiceImpl implements BoughtServiceInterface {

    @Autowired
    BoughtRepo boughtRepo;

    @Override
    public List<RecipeDTO> getAllBoughtRecipesByLoggedInUserDataOnly(User user) {
        int i = 0;
        List<RecipeDTO> boughtRecipesByUserXDataOnly = new ArrayList();
        List<Recipe> boughtRecipesByUserX = new ArrayList();
        boughtRepo.findAllByUserId(user).forEach(bought -> boughtRecipesByUserX.add(bought.getRecipeId()));
        for (Recipe recipe : boughtRecipesByUserX) {
            boughtRecipesByUserXDataOnly.add(new RecipeDTO());
            boughtRecipesByUserXDataOnly.get(i).setName(recipe.getName());
            boughtRecipesByUserXDataOnly.get(i).setInstructions(recipe.getInstructions());
            boughtRecipesByUserXDataOnly.get(i).setInstructions(recipe.getInstructions());
            boughtRecipesByUserXDataOnly.get(i).setUtensils(recipe.getUtensils());
            boughtRecipesByUserXDataOnly.get(i).setDescription(recipe.getDescription());
            boughtRecipesByUserXDataOnly.get(i).setIngredients(recipe.getIngredients());
            boughtRecipesByUserXDataOnly.get(i).setPhoto(recipe.getPhoto());
            boughtRecipesByUserXDataOnly.get(i).setVideo(recipe.getVideo());
            boughtRecipesByUserXDataOnly.get(i).setType(recipe.getType());
            boughtRecipesByUserXDataOnly.get(i).setPaid(recipe.getPaid());
            i++;
        }
        return boughtRecipesByUserXDataOnly;
    }

}
