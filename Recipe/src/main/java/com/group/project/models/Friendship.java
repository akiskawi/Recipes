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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "friendship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f"),
    @NamedQuery(name = "Friendship.findByUserId", query = "SELECT f FROM Friendship f WHERE f.userId = :userId"),
    @NamedQuery(name = "Friendship.findByFriendId", query = "SELECT f FROM Friendship f WHERE f.friendId = :friendId"),
    @NamedQuery(name = "Friendship.findByFriendshipId", query = "SELECT f FROM Friendship f WHERE f.friendshipId = :friendshipId")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "friend_id")
    private Integer friendId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "friendship_id")
    private Integer friendshipId;

    public Friendship() {
    }

    public Friendship(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Friendship(Integer friendshipId, int userId) {
        this.friendshipId = friendshipId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipId != null ? friendshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipId == null && other.friendshipId != null) || (this.friendshipId != null && !this.friendshipId.equals(other.friendshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Friendship[ friendshipId=" + friendshipId + " ]";
    }
    
}
