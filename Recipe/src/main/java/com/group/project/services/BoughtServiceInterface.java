/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.services;

import com.group.project.dto.RecipeDTO;
import com.group.project.models.User;
import java.util.List;

/**
 *
 * @author mhtso
 */
public interface BoughtServiceInterface {

    public List<RecipeDTO> getAllBoughtRecipesByLoggedInUserDataOnly(User user);

}
