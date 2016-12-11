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
    , @NamedQuery(name = "CustomersTakesMedicines.findByMedicationintakeschedule", query = "SELECT c FROM CustomersTakesMedicines c WHERE c.medicationintakeschedule = :medicationintakeschedule")})
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
    //@Temporal(TemporalType.TIMESTAMP)
    private String medStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "`Medication intake schedule`") //single quotes essential for query to work because spaces in column name
    // see http://stackoverflow.com/questions/14190798/how-to-select-a-column-name-with-space-between-in-mysql-on-liunx-ubuntu
    private double medicationintakeschedule;
    @JoinColumn(name = "customers_id", referencedColumnName = "cu_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;
    @JoinColumn(name = "medicins_id", referencedColumnName = "med_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicines medicines;

    public CustomersTakesMedicines() {
    }

    public CustomersTakesMedicines(CustomersTakesMedicinesPK customersTakesMedicinesPK) {
        this.customersTakesMedicinesPK = customersTakesMedicinesPK;
    }

    public CustomersTakesMedicines(CustomersTakesMedicinesPK customersTakesMedicinesPK, String medDosage, String medStartDate, double medicationintakeschedule) {
        this.customersTakesMedicinesPK = customersTakesMedicinesPK;
        this.medDosage = medDosage;
        this.medStartDate = medStartDate;
        this.medicationintakeschedule = medicationintakeschedule;
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

    public String getMedStartDate() {
        return medStartDate;
    }

    public void setMedStartDate(String medStartDate) {
        this.medStartDate = medStartDate;
    }

   public double getMedicationintakeschedule() {
        return medicationintakeschedule;
    }

    public void setMedicationintakeschedule(double medicationintakeschedule) {
        this.medicationintakeschedule = medicationintakeschedule;
    }
    
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
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
