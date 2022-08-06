/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "user_has_user")
@NamedQueries({
    @NamedQuery(name = "UserHasUser.findAll", query = "SELECT u FROM UserHasUser u"),
    @NamedQuery(name = "UserHasUser.findByUserId", query = "SELECT u FROM UserHasUser u WHERE u.userHasUserPK.userId = :userId"),
    @NamedQuery(name = "UserHasUser.findByUserId1", query = "SELECT u FROM UserHasUser u WHERE u.userHasUserPK.userId1 = :userId1")})
public class UserHasUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasUserPK userHasUserPK;

    public UserHasUser() {
    }

    public UserHasUser(UserHasUserPK userHasUserPK) {
        this.userHasUserPK = userHasUserPK;
    }

    public UserHasUser(int userId, int userId1) {
        this.userHasUserPK = new UserHasUserPK(userId, userId1);
    }

    public UserHasUserPK getUserHasUserPK() {
        return userHasUserPK;
    }

    public void setUserHasUserPK(UserHasUserPK userHasUserPK) {
        this.userHasUserPK = userHasUserPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasUserPK != null ? userHasUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasUser)) {
            return false;
        }
        UserHasUser other = (UserHasUser) object;
        if ((this.userHasUserPK == null && other.userHasUserPK != null) || (this.userHasUserPK != null && !this.userHasUserPK.equals(other.userHasUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.UserHasUser[ userHasUserPK=" + userHasUserPK + " ]";
    }
    
}
