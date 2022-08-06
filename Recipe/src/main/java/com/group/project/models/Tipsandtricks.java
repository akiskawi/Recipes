/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "tipsandtricks")
@NamedQueries({
    @NamedQuery(name = "Tipsandtricks.findAll", query = "SELECT t FROM Tipsandtricks t"),
    @NamedQuery(name = "Tipsandtricks.findByRecipeId", query = "SELECT t FROM Tipsandtricks t WHERE t.recipeId = :recipeId")})
public class Tipsandtricks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "tip")
    private String tip;
    @Id
    @Basic(optional = false)
    @Column(name = "recipe_id")
    private Integer recipeId;
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Recipe recipe;

    public Tipsandtricks() {
    }

    public Tipsandtricks(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
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
        hash += (recipeId != null ? recipeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipsandtricks)) {
            return false;
        }
        Tipsandtricks other = (Tipsandtricks) object;
        if ((this.recipeId == null && other.recipeId != null) || (this.recipeId != null && !this.recipeId.equals(other.recipeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Tipsandtricks[ recipeId=" + recipeId + " ]";
    }
    
}
