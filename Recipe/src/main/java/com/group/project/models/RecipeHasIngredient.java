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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "recipe_has_ingredient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecipeHasIngredient.findAll", query = "SELECT r FROM RecipeHasIngredient r"),
    @NamedQuery(name = "RecipeHasIngredient.findByRecipeId", query = "SELECT r FROM RecipeHasIngredient r WHERE r.recipeHasIngredientPK.recipeId = :recipeId"),
    @NamedQuery(name = "RecipeHasIngredient.findByIngredientId", query = "SELECT r FROM RecipeHasIngredient r WHERE r.recipeHasIngredientPK.ingredientId = :ingredientId"),
    @NamedQuery(name = "RecipeHasIngredient.findByQuantity", query = "SELECT r FROM RecipeHasIngredient r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "RecipeHasIngredient.findByMeasurmentId", query = "SELECT r FROM RecipeHasIngredient r WHERE r.recipeHasIngredientPK.measurmentId = :measurmentId")})
public class RecipeHasIngredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecipeHasIngredientPK recipeHasIngredientPK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredient ingredient;
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recipe recipe;

    public RecipeHasIngredient() {
    }

    public RecipeHasIngredient(RecipeHasIngredientPK recipeHasIngredientPK) {
        this.recipeHasIngredientPK = recipeHasIngredientPK;
    }

    public RecipeHasIngredient(int recipeId, int ingredientId, int measurmentId) {
        this.recipeHasIngredientPK = new RecipeHasIngredientPK(recipeId, ingredientId, measurmentId);
    }

    public RecipeHasIngredientPK getRecipeHasIngredientPK() {
        return recipeHasIngredientPK;
    }

    public void setRecipeHasIngredientPK(RecipeHasIngredientPK recipeHasIngredientPK) {
        this.recipeHasIngredientPK = recipeHasIngredientPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeHasIngredientPK != null ? recipeHasIngredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeHasIngredient)) {
            return false;
        }
        RecipeHasIngredient other = (RecipeHasIngredient) object;
        if ((this.recipeHasIngredientPK == null && other.recipeHasIngredientPK != null) || (this.recipeHasIngredientPK != null && !this.recipeHasIngredientPK.equals(other.recipeHasIngredientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.RecipeHasIngredient[ recipeHasIngredientPK=" + recipeHasIngredientPK + " ]";
    }
    
}
