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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "customers_takes_medicines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomersTakesMedicines.findAll", query = "SELECT c FROM CustomersTakesMedicines c")
    , @NamedQuery(name = "CustomersTakesMedicines.findByCuId", query = "SELECT c FROM CustomersTakesMedicines c WHERE c.customersTakesMedicinesPK.customersId = :customersId")
    , @NamedQuery(name = "CustomersTakesMedicines.findByMedId", query = "SELECT c FROM CustomersTakesMedicines c WHERE c.customersTakesMedicinesPK.medicinsId = :medicinsId")
    , @NamedQuery(name = "CustomersTakesMedicines.findByMedDosage", query = "SELECT c FROM CustomersTakesMedicines c WHERE c.medDosage = :medDosage")
    , @NamedQuery(name = "CustomersTakesMedicines.findByMedStartDate", query = "SELECT c FROM CustomersTakesMedicines c WHERE c.medStartDate = :medStartDate")
    , @NamedQuery(name = "CustomersTakesMedicines.findByMedIntakeSched", query = "SELECT c FROM CustomersTakesMedicines c WHERE c.medInterval= :medInterval")})
public class CustomersTakesMedicines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomersTakesMedicinesPK customersTakesMedicinesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "med_dosage")
    private String medDosage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "med_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date medStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "med_interval")
    private double medInterval;
    @JoinColumn(name = "medicins_id", referencedColumnName = "med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicines medicines;

    public CustomersTakesMedicines() {
    }

    public CustomersTakesMedicines(CustomersTakesMedicinesPK customersTakesMedicinesPK) {
        this.customersTakesMedicinesPK = customersTakesMedicinesPK;
    }

    public CustomersTakesMedicines(CustomersTakesMedicinesPK customersTakesMedicinesPK, String medDosage, Date medStartDate, double medicationintakeschedule) {
        this.customersTakesMedicinesPK = customersTakesMedicinesPK;
        this.medDosage = medDosage;
        this.medStartDate = medStartDate;
        this.medInterval = medicationintakeschedule;
    }

    public CustomersTakesMedicines(int customersId, int medicinsId) {
        this.customersTakesMedicinesPK = new CustomersTakesMedicinesPK(customersId, medicinsId);
    }

    public CustomersTakesMedicinesPK getCustomersTakesMedicinesPK() {
        return customersTakesMedicinesPK;
    }

    public void setCustomersTakesMedicinesPK(CustomersTakesMedicinesPK customersTakesMedicinesPK) {
        this.customersTakesMedicinesPK = customersTakesMedicinesPK;
    }

    public String getMedDosage() {
        return medDosage;
    }

    public void setMedDosage(String medDosage) {
        this.medDosage = medDosage;
    }

    public Date getMedStartDate() {
        return medStartDate;
    }

    public void setMedStartDate(Date medStartDate) {
        this.medStartDate = medStartDate;
    }

    public double getMedicationintakeschedule() {
        return medInterval;
    }

    public void setMedicationintakeschedule(double medInterval) {
        this.medInterval = medInterval;
    }

    public Medicines getMedicines() {
        return medicines;
    }

    public void setMedicines(Medicines medicines) {
        this.medicines = medicines;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customersTakesMedicinesPK != null ? customersTakesMedicinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomersTakesMedicines)) {
            return false;
        }
        CustomersTakesMedicines other = (CustomersTakesMedicines) object;
        if ((this.customersTakesMedicinesPK == null && other.customersTakesMedicinesPK != null) || (this.customersTakesMedicinesPK != null && !this.customersTakesMedicinesPK.equals(other.customersTakesMedicinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomersTakesMedicines[ customersTakesMedicinesPK=" + customersTakesMedicinesPK + " ]";
    }
    
}
