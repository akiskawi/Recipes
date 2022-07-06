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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "paid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paid.findAll", query = "SELECT p FROM Paid p"),
    @NamedQuery(name = "Paid.findByRecipeId", query = "SELECT p FROM Paid p WHERE p.recipeId = :recipeId")})
public class Paid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "pictures")
    private byte[] pictures;
    @Lob
    @Column(name = "videos")
    private byte[] videos;
    @Id
    @Basic(optional = false)
    @Column(name = "recipe_id")
    private Integer recipeId;
    @Lob
    @Column(name = "tipsandtricks")
    private String tipsandtricks;
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Recipe recipe;

    public Paid() {
    }

    public Paid(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public byte[] getPictures() {
        return pictures;
    }

    public void setPictures(byte[] pictures) {
        this.pictures = pictures;
    }

    public byte[] getVideos() {
        return videos;
    }

    public void setVideos(byte[] videos) {
        this.videos = videos;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTipsandtricks() {
        return tipsandtricks;
    }

    public void setTipsandtricks(String tipsandtricks) {
        this.tipsandtricks = tipsandtricks;
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
        if (!(object instanceof Paid)) {
            return false;
        }
        Paid other = (Paid) object;
        if ((this.recipeId == null && other.recipeId != null) || (this.recipeId != null && !this.recipeId.equals(other.recipeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Paid[ recipeId=" + recipeId + " ]";
    }
    
}
