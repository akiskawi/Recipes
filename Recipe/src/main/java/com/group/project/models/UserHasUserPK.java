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
public class UserHasUserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "user_id1")
    private int userId1;

    public UserHasUserPK() {
    }

    public UserHasUserPK(int userId, int userId1) {
        this.userId = userId;
        this.userId1 = userId1;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) userId1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasUserPK)) {
            return false;
        }
        UserHasUserPK other = (UserHasUserPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.userId1 != other.userId1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.UserHasUserPK[ userId=" + userId + ", userId1=" + userId1 + " ]";
    }
    
}
