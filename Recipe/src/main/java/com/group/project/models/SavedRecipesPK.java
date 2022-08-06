/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author akisk
 */
@Embeddable
public class SavedRecipesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "recipe_id")
    private int recipeId;

    public SavedRecipesPK() {
    }

    public SavedRecipesPK(int userId, int recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) recipeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SavedRecipesPK)) {
            return false;
        }
        SavedRecipesPK other = (SavedRecipesPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.recipeId != other.recipeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.SavedRecipesPK[ userId=" + userId + ", recipeId=" + recipeId + " ]";
    }
    
}
