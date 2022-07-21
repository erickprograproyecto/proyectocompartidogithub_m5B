/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "gps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gps.findAll", query = "SELECT g FROM Gps g"),
    @NamedQuery(name = "Gps.findByIdgps", query = "SELECT g FROM Gps g WHERE g.idgps = :idgps"),
    @NamedQuery(name = "Gps.findByEquipo", query = "SELECT g FROM Gps g WHERE g.equipo = :equipo"),
    @NamedQuery(name = "Gps.findByImei", query = "SELECT g FROM Gps g WHERE g.imei = :imei"),
    @NamedQuery(name = "Gps.findByNumeroChip", query = "SELECT g FROM Gps g WHERE g.numeroChip = :numeroChip"),
    @NamedQuery(name = "Gps.findBySerie", query = "SELECT g FROM Gps g WHERE g.serie = :serie"),
    @NamedQuery(name = "Gps.findByCosto", query = "SELECT g FROM Gps g WHERE g.costo = :costo"),
    @NamedQuery(name = "Gps.findByObservacion", query = "SELECT g FROM Gps g WHERE g.observacion = :observacion")})
public class Gps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgps")
    private Integer idgps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "equipo")
    private String equipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_chip")
    private String numeroChip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;

    public Gps() {
    }

    public Gps(Integer idgps) {
        this.idgps = idgps;
    }

    public Gps(Integer idgps, String equipo, String imei, String numeroChip, String serie, double costo) {
        this.idgps = idgps;
        this.equipo = equipo;
        this.imei = imei;
        this.numeroChip = numeroChip;
        this.serie = serie;
        this.costo = costo;
    }

    public Integer getIdgps() {
        return idgps;
    }

    public void setIdgps(Integer idgps) {
        this.idgps = idgps;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getNumeroChip() {
        return numeroChip;
    }

    public void setNumeroChip(String numeroChip) {
        this.numeroChip = numeroChip;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgps != null ? idgps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gps)) {
            return false;
        }
        Gps other = (Gps) object;
        if ((this.idgps == null && other.idgps != null) || (this.idgps != null && !this.idgps.equals(other.idgps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Gps[ idgps=" + idgps + " ]";
    }
    
}
