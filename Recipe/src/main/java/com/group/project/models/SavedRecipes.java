/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "saved_recipes")
@NamedQueries({
    @NamedQuery(name = "SavedRecipes.findAll", query = "SELECT s FROM SavedRecipes s"),
    @NamedQuery(name = "SavedRecipes.findByUserId", query = "SELECT s FROM SavedRecipes s WHERE s.savedRecipesPK.userId = :userId"),
    @NamedQuery(name = "SavedRecipes.findByRecipeId", query = "SELECT s FROM SavedRecipes s WHERE s.savedRecipesPK.recipeId = :recipeId"),
    @NamedQuery(name = "SavedRecipes.findByBought", query = "SELECT s FROM SavedRecipes s WHERE s.bought = :bought")})
public class SavedRecipes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SavedRecipesPK savedRecipesPK;
    @Column(name = "bought")
    private Boolean bought;
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recipe recipe;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public SavedRecipes() {
    }

    public SavedRecipes(SavedRecipesPK savedRecipesPK) {
        this.savedRecipesPK = savedRecipesPK;
    }

    public SavedRecipes(int userId, int recipeId) {
        this.savedRecipesPK = new SavedRecipesPK(userId, recipeId);
    }

    public SavedRecipesPK getSavedRecipesPK() {
        return savedRecipesPK;
    }

    public void setSavedRecipesPK(SavedRecipesPK savedRecipesPK) {
        this.savedRecipesPK = savedRecipesPK;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (savedRecipesPK != null ? savedRecipesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SavedRecipes)) {
            return false;
        }
        SavedRecipes other = (SavedRecipes) object;
        if ((this.savedRecipesPK == null && other.savedRecipesPK != null) || (this.savedRecipesPK != null && !this.savedRecipesPK.equals(other.savedRecipesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.SavedRecipes[ savedRecipesPK=" + savedRecipesPK + " ]";
    }
    
}
