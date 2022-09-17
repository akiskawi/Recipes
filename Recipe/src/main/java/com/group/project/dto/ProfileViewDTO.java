/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.dto;

import com.group.project.services.BoughtServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mhtso
 */
@Component
public class ProfileViewDTO {

    @Autowired
    private BoughtServiceInterface boughtService;

    // BOUGHT RECIPE STUFF
    private String boughtRecipeName;
    private String boughtRecipeDescription;
    private String boughtRecipePhoto;
    private String boughtRecipeType;

    // SAVED RECIPE STUFF
    private String savedRecipeName;
    private String savedRecipeDescription;
    private String savedRecipePhoto;
    private String savedRecipeType;

    // USER STUFF

    public BoughtServiceInterface getBoughtService() {
        return boughtService;
    }

    public void setBoughtService(BoughtServiceInterface boughtService) {
        this.boughtService = boughtService;
    }

    public String getBoughtRecipeName() {
        return boughtRecipeName;
    }

    public void setBoughtRecipeName(String boughtRecipeName) {
        this.boughtRecipeName = boughtRecipeName;
    }

    public String getBoughtRecipeDescription() {
        return boughtRecipeDescription;
    }

    public void setBoughtRecipeDescription(String boughtRecipeDescription) {
        this.boughtRecipeDescription = boughtRecipeDescription;
    }

    public String getBoughtRecipePhoto() {
        return boughtRecipePhoto;
    }

    public void setBoughtRecipePhoto(String boughtRecipePhoto) {
        this.boughtRecipePhoto = boughtRecipePhoto;
    }

    public String getBoughtRecipeType() {
        return boughtRecipeType;
    }

    public void setBoughtRecipeType(String boughtRecipeType) {
        this.boughtRecipeType = boughtRecipeType;
    }

    public String getSavedRecipeName() {
        return savedRecipeName;
    }

    public void setSavedRecipeName(String savedRecipeName) {
        this.savedRecipeName = savedRecipeName;
    }

    public String getSavedRecipeDescription() {
        return savedRecipeDescription;
    }

    public void setSavedRecipeDescription(String savedRecipeDescription) {
        this.savedRecipeDescription = savedRecipeDescription;
    }

    public String getSavedRecipePhoto() {
        return savedRecipePhoto;
    }

    public void setSavedRecipePhoto(String savedRecipePhoto) {
        this.savedRecipePhoto = savedRecipePhoto;
    }

    public String getSavedRecipeType() {
        return savedRecipeType;
    }

    public void setSavedRecipeType(String savedRecipeType) {
        this.savedRecipeType = savedRecipeType;
    }
    
    
}
