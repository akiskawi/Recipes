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
 * @author georg
 */
@Embeddable
public class FriendListPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "fruend_id")
    private int fruendId;

    public FriendListPK() {
    }

    public FriendListPK(int userId, int fruendId) {
        this.userId = userId;
        this.fruendId = fruendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFruendId() {
        return fruendId;
    }

    public void setFruendId(int fruendId) {
        this.fruendId = fruendId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) fruendId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendListPK)) {
            return false;
        }
        FriendListPK other = (FriendListPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.fruendId != other.fruendId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.FriendListPK[ userId=" + userId + ", fruendId=" + fruendId + " ]";
    }
    
}
