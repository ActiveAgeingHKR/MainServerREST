/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "devices_customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevicesCustomers.findAll", query = "SELECT d FROM DevicesCustomers d")
    , @NamedQuery(name = "DevicesCustomers.findByDevId", query = "SELECT d FROM DevicesCustomers d WHERE d.devId = :devId")
    , @NamedQuery(name = "DevicesCustomers.findByDevName", query = "SELECT d FROM DevicesCustomers d WHERE d.devName = :devName")})
public class DevicesCustomers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "dev_id")
    private String devId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dev_name")
    private String devName;
    @JoinColumn(name = "customers_cu_id", referencedColumnName = "cu_id")
    @ManyToOne(optional = false)
    private Customers customersCuId;

    public DevicesCustomers() {
    }

    public DevicesCustomers(String devId) {
        this.devId = devId;
    }

    public DevicesCustomers(String devId, String devName) {
        this.devId = devId;
        this.devName = devName;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }
    
    public Customers getCustomersCuId() {
        return customersCuId;
    }

    public void setCustomersCuId(Customers customersCuId) {
        this.customersCuId = customersCuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (devId != null ? devId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevicesCustomers)) {
            return false;
        }
        DevicesCustomers other = (DevicesCustomers) object;
        if ((this.devId == null && other.devId != null) || (this.devId != null && !this.devId.equals(other.devId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DevicesCustomers[ devId=" + devId + " ]";
    }
    
}
