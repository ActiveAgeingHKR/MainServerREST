/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Chris
 */
@Embeddable
public class CustomersTakesMedicinesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "customers_id")
    private int customersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "medicins_id")
    private int medicinsId;

    public CustomersTakesMedicinesPK() {
    }

    public CustomersTakesMedicinesPK(int customersId, int medicinsId) {
        this.customersId = customersId;
        this.medicinsId = medicinsId;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public int getMedicinsId() {
        return medicinsId;
    }

    public void setMedicinsId(int medicinsId) {
        this.medicinsId = medicinsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customersId;
        hash += (int) medicinsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomersTakesMedicinesPK)) {
            return false;
        }
        CustomersTakesMedicinesPK other = (CustomersTakesMedicinesPK) object;
        if (this.customersId != other.customersId) {
            return false;
        }
        if (this.medicinsId != other.medicinsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomersTakesMedicinesPK[ customersId=" + customersId + ", medicinsId=" + medicinsId + " ]";
    }
    
}
