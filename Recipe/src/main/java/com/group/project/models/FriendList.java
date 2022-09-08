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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author georg
 */
@Entity
@Table(name = "friend_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FriendList.findAll", query = "SELECT f FROM FriendList f"),
    @NamedQuery(name = "FriendList.findByUserId", query = "SELECT f FROM FriendList f WHERE f.friendListPK.userId = :userId"),
    @NamedQuery(name = "FriendList.findByFruendId", query = "SELECT f FROM FriendList f WHERE f.friendListPK.fruendId = :fruendId")})
public class FriendList implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendListPK friendListPK;

    public FriendList() {
    }

    public FriendList(FriendListPK friendListPK) {
        this.friendListPK = friendListPK;
    }

    public FriendList(int userId, int fruendId) {
        this.friendListPK = new FriendListPK(userId, fruendId);
    }

    public FriendListPK getFriendListPK() {
        return friendListPK;
    }

    public void setFriendListPK(FriendListPK friendListPK) {
        this.friendListPK = friendListPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendListPK != null ? friendListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendList)) {
            return false;
        }
        FriendList other = (FriendList) object;
        if ((this.friendListPK == null && other.friendListPK != null) || (this.friendListPK != null && !this.friendListPK.equals(other.friendListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.FriendList[ friendListPK=" + friendListPK + " ]";
    }
    
}
