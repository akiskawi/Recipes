/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.controllers;

import com.group.project.dto.ProfileViewDTO;
import com.group.project.dto.RecipeDTO;
import com.group.project.models.User;
import com.group.project.services.BoughtServiceInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mhtso
 */
@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/bought")
public class BoughtController {

    @Autowired
    BoughtServiceInterface boughtService;

    @GetMapping("/{id}")
    public List<RecipeDTO> showAllBoughtRecipesByLoggedInUserId(@PathVariable(value = "id") User user) {
//        List<RecipeDTO> boughtRecipesByUserXDataOnly = new ArrayList();
        return boughtService.getAllBoughtRecipesByLoggedInUserDataOnly(user);
//        boughtService.getAllBoughtRecipesByLoggedInUser(user).forEach(recipe -> boughtRecipesByUserXDataOnly.add(recipe));
//        return boughtRecipesByUserXDataOnly;

    }

}
