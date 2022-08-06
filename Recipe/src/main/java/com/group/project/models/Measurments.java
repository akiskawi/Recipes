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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author akisk
 */
@Entity
@Table(name = "measurments")
@NamedQueries({
    @NamedQuery(name = "Measurments.findAll", query = "SELECT m FROM Measurments m"),
    @NamedQuery(name = "Measurments.findById", query = "SELECT m FROM Measurments m WHERE m.id = :id"),
    @NamedQuery(name = "Measurments.findByMeasurment", query = "SELECT m FROM Measurments m WHERE m.measurment = :measurment")})
public class Measurments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "measurment")
    private String measurment;

    public Measurments() {
    }

    public Measurments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeasurment() {
        return measurment;
    }

    public void setMeasurment(String measurment) {
        this.measurment = measurment;
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
        if (!(object instanceof Measurments)) {
            return false;
        }
        Measurments other = (Measurments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group.project.models.Measurments[ id=" + id + " ]";
    }
    
}
