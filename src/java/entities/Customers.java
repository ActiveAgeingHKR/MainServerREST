/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCuId", query = "SELECT c FROM Customers c WHERE c.cuId = :cuId")
    , @NamedQuery(name = "Customers.findByCuFirstname", query = "SELECT c FROM Customers c WHERE c.cuFirstname = :cuFirstname")
    , @NamedQuery(name = "Customers.findByCuLastname", query = "SELECT c FROM Customers c WHERE c.cuLastname = :cuLastname")
    , @NamedQuery(name = "Customers.findByCuBirthdate", query = "SELECT c FROM Customers c WHERE c.cuBirthdate = :cuBirthdate")
    , @NamedQuery(name = "Customers.findByCuAddress", query = "SELECT c FROM Customers c WHERE c.cuAddress = :cuAddress")
    , @NamedQuery(name = "Customers.findByCuPersonnummer", query = "SELECT c FROM Customers c WHERE c.cuPersonnummer = :cuPersonnummer")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cu_id")
    private Integer cuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cu_firstname")
    private String cuFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cu_lastname")
    private String cuLastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cu_birthdate")
    //@Temporal(TemporalType.DATE)
    private String cuBirthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cu_address")
    private String cuAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cu_personnummer")
    private String cuPersonnummer;

    public Customers() {
    }

    public Customers(Integer cuId) {
        this.cuId = cuId;
    }

    public Customers(Integer cuId, String cuFirstname, String cuLastname, String cuBirthdate, String cuAddress, String cuPersonnummer) {
        this.cuId = cuId;
        this.cuFirstname = cuFirstname;
        this.cuLastname = cuLastname;
        this.cuBirthdate = cuBirthdate;
        this.cuAddress = cuAddress;
        this.cuPersonnummer = cuPersonnummer;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getCuFirstname() {
        return cuFirstname;
    }

    public void setCuFirstname(String cuFirstname) {
        this.cuFirstname = cuFirstname;
    }

    public String getCuLastname() {
        return cuLastname;
    }

    public void setCuLastname(String cuLastname) {
        this.cuLastname = cuLastname;
    }

    public String getCuBirthdate() {
        return cuBirthdate;
    }

    public void setCuBirthdate(String cuBirthdate) {
        this.cuBirthdate = cuBirthdate;
    }

    public String getCuAddress() {
        return cuAddress;
    }

    public void setCuAddress(String cuAddress) {
        this.cuAddress = cuAddress;
    }

    public String getCuPersonnummer() {
        return cuPersonnummer;
    }

    public void setCuPersonnummer(String cuPersonnummer) {
        this.cuPersonnummer = cuPersonnummer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuId != null ? cuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.cuId == null && other.cuId != null) || (this.cuId != null && !this.cuId.equals(other.cuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customers[ cuId=" + cuId + " ]";
    }
    
}
