/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "medicines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicines.findAll", query = "SELECT m FROM Medicines m")
    , @NamedQuery(name = "Medicines.findByMedId", query = "SELECT m FROM Medicines m WHERE m.medId = :medId")
    , @NamedQuery(name = "Medicines.findByMedName", query = "SELECT m FROM Medicines m WHERE m.medName = :medName")
    , @NamedQuery(name = "Medicines.findByVolume", query = "SELECT m FROM Medicines m WHERE m.volume = :volume")
    , @NamedQuery(name = "Medicines.findByMedMeasurementUnit", query = "SELECT m FROM Medicines m WHERE m.medMeasurementUnit = :medMeasurementUnit")})
public class Medicines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "med_id")
    private Integer medId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "med_name")
    private String medName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volume")
    private int volume;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "med_measurement_unit")
    private String medMeasurementUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicines")
    private Collection<CustomersTakesMedicines> customersTakesMedicinesCollection;

    public Medicines() {
    }

    public Medicines(Integer medId) {
        this.medId = medId;
    }

    public Medicines(Integer medId, String medName, int volume, String medMeasurementUnit) {
        this.medId = medId;
        this.medName = medName;
        this.volume = volume;
        this.medMeasurementUnit = medMeasurementUnit;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getMedMeasurementUnit() {
        return medMeasurementUnit;
    }

    public void setMedMeasurementUnit(String medMeasurementUnit) {
        this.medMeasurementUnit = medMeasurementUnit;
    }

    @XmlTransient
    public Collection<CustomersTakesMedicines> getCustomersTakesMedicinesCollection() {
        return customersTakesMedicinesCollection;
    }

    public void setCustomersTakesMedicinesCollection(Collection<CustomersTakesMedicines> customersTakesMedicinesCollection) {
        this.customersTakesMedicinesCollection = customersTakesMedicinesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medId != null ? medId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicines)) {
            return false;
        }
        Medicines other = (Medicines) object;
        if ((this.medId == null && other.medId != null) || (this.medId != null && !this.medId.equals(other.medId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medicines[ medId=" + medId + " ]";
    }
    
}
