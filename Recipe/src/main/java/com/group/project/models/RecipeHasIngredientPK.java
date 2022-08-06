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
public class RecipeHasIngredientPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "recipe_id")
    private int recipeId;
    @Basic(optional = false)
    @Column(name = "ingredient_id")
    private int ingredientId;
    @Basic(optional = false)
    @Column(name = "measurment_id")
    private int measurmentId;

    public RecipeHasIngredientPK() {
    }

    public RecipeHasIngredientPK(int recipeId, int ingredientId, int measurmentId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.measurmentId = measurmentId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getMeasurmentId() {
        return measurmentId;
    }

    public void setMeasurmentId(int measurmentId) {
        this.measurmentId = measurmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recipeId;
        hash += (int) ingredientId;
        hash += (int) measurmentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeHasIngredientPK)) {
            return false;
        }
        RecipeHasIngredientPK other = (RecipeHasIngredientPK) object;
        if (this.recipeId != other.recipeId) {
            return false;
        }
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        if (this.measurmentId != other.measurmentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.RecipeHasIngredientPK[ recipeId=" + recipeId + ", ingredientId=" + ingredientId + ", measurmentId=" + measurmentId + " ]";
    }
    
}
