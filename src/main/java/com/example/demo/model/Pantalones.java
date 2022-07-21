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
@Table(name = "pantalones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalones.findAll", query = "SELECT p FROM Pantalones p"),
    @NamedQuery(name = "Pantalones.findByIdPantalones", query = "SELECT p FROM Pantalones p WHERE p.idPantalones = :idPantalones"),
    @NamedQuery(name = "Pantalones.findByMarca", query = "SELECT p FROM Pantalones p WHERE p.marca = :marca"),
    @NamedQuery(name = "Pantalones.findByModelo", query = "SELECT p FROM Pantalones p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Pantalones.findByFabricante", query = "SELECT p FROM Pantalones p WHERE p.fabricante = :fabricante"),
    @NamedQuery(name = "Pantalones.findByCodigo", query = "SELECT p FROM Pantalones p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pantalones.findByCosto", query = "SELECT p FROM Pantalones p WHERE p.costo = :costo"),
    @NamedQuery(name = "Pantalones.findByCantidad", query = "SELECT p FROM Pantalones p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Pantalones.findByCostoTotalP", query = "SELECT p FROM Pantalones p WHERE p.costoTotalP = :costoTotalP")})
public class Pantalones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pantalones")
    private Integer idPantalones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_total_p")
    private Double costoTotalP;

    public Pantalones() {
    }

    public Pantalones(Integer idPantalones) {
        this.idPantalones = idPantalones;
    }

    public Pantalones(Integer idPantalones, String marca, String modelo, String fabricante, String codigo, double costo, int cantidad) {
        this.idPantalones = idPantalones;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Integer getIdPantalones() {
        return idPantalones;
    }

    public void setIdPantalones(Integer idPantalones) {
        this.idPantalones = idPantalones;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoTotalP() {
        return costoTotalP;
    }

    public void setCostoTotalP(Double costoTotalP) {
        this.costoTotalP = costoTotalP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPantalones != null ? idPantalones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalones)) {
            return false;
        }
        Pantalones other = (Pantalones) object;
        if ((this.idPantalones == null && other.idPantalones != null) || (this.idPantalones != null && !this.idPantalones.equals(other.idPantalones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Pantalones[ idPantalones=" + idPantalones + " ]";
    }
    
}
