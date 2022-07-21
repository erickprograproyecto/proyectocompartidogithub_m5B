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
@Table(name = "zapatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zapatos.findAll", query = "SELECT z FROM Zapatos z"),
    @NamedQuery(name = "Zapatos.findByIdZapatos", query = "SELECT z FROM Zapatos z WHERE z.idZapatos = :idZapatos"),
    @NamedQuery(name = "Zapatos.findByMarca", query = "SELECT z FROM Zapatos z WHERE z.marca = :marca"),
    @NamedQuery(name = "Zapatos.findByCodigo", query = "SELECT z FROM Zapatos z WHERE z.codigo = :codigo"),
    @NamedQuery(name = "Zapatos.findByCosto", query = "SELECT z FROM Zapatos z WHERE z.costo = :costo"),
    @NamedQuery(name = "Zapatos.findByCantidad", query = "SELECT z FROM Zapatos z WHERE z.cantidad = :cantidad"),
    @NamedQuery(name = "Zapatos.findByCostoTotalZ", query = "SELECT z FROM Zapatos z WHERE z.costoTotalZ = :costoTotalZ"),
    @NamedQuery(name = "Zapatos.findByTipoDeZapatos", query = "SELECT z FROM Zapatos z WHERE z.tipoDeZapatos = :tipoDeZapatos")})
public class Zapatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zapatos")
    private Integer idZapatos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
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
    private double cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_total_z")
    private Double costoTotalZ;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_de_zapatos")
    private String tipoDeZapatos;

    public Zapatos() {
    }

    public Zapatos(Integer idZapatos) {
        this.idZapatos = idZapatos;
    }

    public Zapatos(Integer idZapatos, String marca, String codigo, double costo, double cantidad, String tipoDeZapatos) {
        this.idZapatos = idZapatos;
        this.marca = marca;
        this.codigo = codigo;
        this.costo = costo;
        this.cantidad = cantidad;
        this.tipoDeZapatos = tipoDeZapatos;
    }

    public Integer getIdZapatos() {
        return idZapatos;
    }

    public void setIdZapatos(Integer idZapatos) {
        this.idZapatos = idZapatos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoTotalZ() {
        return costoTotalZ;
    }

    public void setCostoTotalZ(Double costoTotalZ) {
        this.costoTotalZ = costoTotalZ;
    }

    public String getTipoDeZapatos() {
        return tipoDeZapatos;
    }

    public void setTipoDeZapatos(String tipoDeZapatos) {
        this.tipoDeZapatos = tipoDeZapatos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZapatos != null ? idZapatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zapatos)) {
            return false;
        }
        Zapatos other = (Zapatos) object;
        if ((this.idZapatos == null && other.idZapatos != null) || (this.idZapatos != null && !this.idZapatos.equals(other.idZapatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Zapatos[ idZapatos=" + idZapatos + " ]";
    }
    
}
