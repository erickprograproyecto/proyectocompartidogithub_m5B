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
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c"),
    @NamedQuery(name = "Casas.findByIdCasas", query = "SELECT c FROM Casas c WHERE c.idCasas = :idCasas"),
    @NamedQuery(name = "Casas.findByPropietario", query = "SELECT c FROM Casas c WHERE c.propietario = :propietario"),
    @NamedQuery(name = "Casas.findByCodigo", query = "SELECT c FROM Casas c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Casas.findByArea", query = "SELECT c FROM Casas c WHERE c.area = :area"),
    @NamedQuery(name = "Casas.findByTipoTerreno", query = "SELECT c FROM Casas c WHERE c.tipoTerreno = :tipoTerreno"),
    @NamedQuery(name = "Casas.findByCostoTotal", query = "SELECT c FROM Casas c WHERE c.costoTotal = :costoTotal")})
public class Casas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_casas")
    private Integer idCasas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "propietario")
    private String propietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private double area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_terreno")
    private String tipoTerreno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_total")
    private Double costoTotal;

    public Casas() {
    }

    public Casas(Integer idCasas) {
        this.idCasas = idCasas;
    }

    public Casas(Integer idCasas, String propietario, String codigo, double area, String tipoTerreno) {
        this.idCasas = idCasas;
        this.propietario = propietario;
        this.codigo = codigo;
        this.area = area;
        this.tipoTerreno = tipoTerreno;
    }

    public Integer getIdCasas() {
        return idCasas;
    }

    public void setIdCasas(Integer idCasas) {
        this.idCasas = idCasas;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasas != null ? idCasas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.idCasas == null && other.idCasas != null) || (this.idCasas != null && !this.idCasas.equals(other.idCasas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Casas[ idCasas=" + idCasas + " ]";
    }
    
}
