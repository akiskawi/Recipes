/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "RecipeHasIngredient.findByQuantity", query = "SELECT r FROM RecipeHasIngredient r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "RecipeHasIngredient.findByMeasurmentId", query = "SELECT r FROM RecipeHasIngredient r WHERE r.measurmentId = :measurmentId"),
    @NamedQuery(name = "RecipeHasIngredient.findByRecipeHasIngredientId", query = "SELECT r FROM RecipeHasIngredient r WHERE r.recipeHasIngredientId = :recipeHasIngredientId")})
public class RecipeHasIngredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @Column(name = "measurment_id")
    private int measurmentId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recipe_has_ingredient_id")
    private Integer recipeHasIngredientId;
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingredient ingredientId;
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recipe recipeId;

    public RecipeHasIngredient() {
    }

    public RecipeHasIngredient(Integer recipeHasIngredientId) {
        this.recipeHasIngredientId = recipeHasIngredientId;
    }

    public RecipeHasIngredient(Integer recipeHasIngredientId, int measurmentId) {
        this.recipeHasIngredientId = recipeHasIngredientId;
        this.measurmentId = measurmentId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getMeasurmentId() {
        return measurmentId;
    }

    public void setMeasurmentId(int measurmentId) {
        this.measurmentId = measurmentId;
    }

    public Integer getRecipeHasIngredientId() {
        return recipeHasIngredientId;
    }

    public void setRecipeHasIngredientId(Integer recipeHasIngredientId) {
        this.recipeHasIngredientId = recipeHasIngredientId;
    }

    public Ingredient getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Ingredient ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Recipe getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Recipe recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeHasIngredientId != null ? recipeHasIngredientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeHasIngredient)) {
            return false;
        }
        RecipeHasIngredient other = (RecipeHasIngredient) object;
        if ((this.recipeHasIngredientId == null && other.recipeHasIngredientId != null) || (this.recipeHasIngredientId != null && !this.recipeHasIngredientId.equals(other.recipeHasIngredientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.RecipeHasIngredient[ recipeHasIngredientId=" + recipeHasIngredientId + " ]";
    }
    
}
