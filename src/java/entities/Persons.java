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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "persons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persons.findAll", query = "SELECT p FROM Persons p")
    , @NamedQuery(name = "Persons.findByIdpersons", query = "SELECT p FROM Persons p WHERE p.idpersons = :idpersons")
    , @NamedQuery(name = "Persons.findBySchDate", query = "SELECT p FROM Persons p WHERE p.schDate = :schDate")
    , @NamedQuery(name = "Persons.findBySchTime", query = "SELECT p FROM Persons p WHERE p.schTime = :schTime")
    , @NamedQuery(name = "Persons.findByRecordTimestamp", query = "SELECT p FROM Persons p WHERE p.recordTimestamp = :recordTimestamp")
    , @NamedQuery(name = "Persons.findByName", query = "SELECT p FROM Persons p WHERE p.name = :name")})
public class Persons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersons")
    private Integer idpersons;
    @Column(name = "sch_date")
    @Temporal(TemporalType.DATE)
    private Date schDate;
    @Column(name = "sch_time")
    @Temporal(TemporalType.TIME)
    private Date schTime;
    @Column(name = "record_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordTimestamp;
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    public Persons() {
    }

    public Persons(Integer idpersons) {
        this.idpersons = idpersons;
    }

    public Integer getIdpersons() {
        return idpersons;
    }

    public void setIdpersons(Integer idpersons) {
        this.idpersons = idpersons;
    }

    public Date getSchDate() {
        return schDate;
    }

    public void setSchDate(Date schDate) {
        this.schDate = schDate;
    }

    public Date getSchTime() {
        return schTime;
    }

    public void setSchTime(Date schTime) {
        this.schTime = schTime;
    }

    public Date getRecordTimestamp() {
        return recordTimestamp;
    }

    public void setRecordTimestamp(Date recordTimestamp) {
        this.recordTimestamp = recordTimestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersons != null ? idpersons.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.idpersons == null && other.idpersons != null) || (this.idpersons != null && !this.idpersons.equals(other.idpersons))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persons[ idpersons=" + idpersons + " ]";
    }
    
}
