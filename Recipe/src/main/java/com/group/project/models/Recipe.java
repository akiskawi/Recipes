/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "recipe")
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findById", query = "SELECT r FROM Recipe r WHERE r.id = :id"),
    @NamedQuery(name = "Recipe.findByName", query = "SELECT r FROM Recipe r WHERE r.name = :name"),
    @NamedQuery(name = "Recipe.findByPhoto", query = "SELECT r FROM Recipe r WHERE r.photo = :photo"),
    @NamedQuery(name = "Recipe.findByVideo", query = "SELECT r FROM Recipe r WHERE r.video = :video"),
    @NamedQuery(name = "Recipe.findByType", query = "SELECT r FROM Recipe r WHERE r.type = :type")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "instructions")
    private String instructions;
    @Lob
    @Column(name = "utensils")
    private String utensils;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @Column(name = "video")
    private String video;
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<RecipeHasIngredient> recipeHasIngredientSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<SavedRecipes> savedRecipesSet;
    @OneToMany(mappedBy = "recipeId")
    private Set<Bought> boughtSet;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne
    private User ownerId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Videos videos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Photos photos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Tipsandtricks tipsandtricks;

    public Recipe() {
    }

    public Recipe(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getUtensils() {
        return utensils;
    }

    public void setUtensils(String utensils) {
        this.utensils = utensils;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<RecipeHasIngredient> getRecipeHasIngredientSet() {
        return recipeHasIngredientSet;
    }

    public void setRecipeHasIngredientSet(Set<RecipeHasIngredient> recipeHasIngredientSet) {
        this.recipeHasIngredientSet = recipeHasIngredientSet;
    }

    public Set<SavedRecipes> getSavedRecipesSet() {
        return savedRecipesSet;
    }

    public void setSavedRecipesSet(Set<SavedRecipes> savedRecipesSet) {
        this.savedRecipesSet = savedRecipesSet;
    }

    public Set<Bought> getBoughtSet() {
        return boughtSet;
    }

    public void setBoughtSet(Set<Bought> boughtSet) {
        this.boughtSet = boughtSet;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public Tipsandtricks getTipsandtricks() {
        return tipsandtricks;
    }

    public void setTipsandtricks(Tipsandtricks tipsandtricks) {
        this.tipsandtricks = tipsandtricks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Recipe[ id=" + id + " ]";
    }
    
}
