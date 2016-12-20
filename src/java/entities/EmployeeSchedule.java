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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "employee_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeSchedule.findAll", query = "SELECT e FROM EmployeeSchedule e")
    , @NamedQuery(name = "EmployeeSchedule.findBySchId", query = "SELECT e FROM EmployeeSchedule e WHERE e.schId = :schId")
    , @NamedQuery(name = "EmployeeSchedule.findBySchDate", query = "SELECT e FROM EmployeeSchedule e WHERE e.schDate = :schDate")
    , @NamedQuery(name = "EmployeeSchedule.findBySchFromTime", query = "SELECT e FROM EmployeeSchedule e WHERE e.schFromTime = :schFromTime")
    , @NamedQuery(name = "EmployeeSchedule.findBySchUntilTime", query = "SELECT e FROM EmployeeSchedule e WHERE e.schUntilTime = :schUntilTime")
    , @NamedQuery(name = "EmployeeSchedule.findByEmplVisitedCust", query = "SELECT e FROM EmployeeSchedule e WHERE e.emplVisitedCust = :emplVisitedCust")
    , @NamedQuery(name = "EmployeeSchedule.findByEmployeeId", query = "SELECT e FROM EmployeeSchedule e WHERE e.employeesEmpId.empId = :empId")
    , @NamedQuery(name = "EmployeeSchedule.findSchAfterDate", query = "SELECT e FROM EmployeeSchedule e WHERE e.schDate >= :schDate")    
    , @NamedQuery(name = "EmployeeSchedule.findByCustomerId", query = "SELECT e FROM EmployeeSchedule e WHERE e.customersCuId.cuId = :cuId")})
public class EmployeeSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sch_id")
    private Integer schId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sch_date")
    //@Temporal(TemporalType.DATE)
    private String schDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sch_from_time")
    //@Temporal(TemporalType.TIME)
    private String schFromTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sch_until_time")
    //@Temporal(TemporalType.TIME)
    private String schUntilTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empl_visited_cust")
    private boolean emplVisitedCust;
    @JoinColumn(name = "customers_cu_id", referencedColumnName = "cu_id")
    @ManyToOne(optional = false)
    private Customers customersCuId;
    @JoinColumn(name = "employees_emp_id", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private Employees employeesEmpId;

    public EmployeeSchedule() {
    }

    public EmployeeSchedule(Integer schId) {
        this.schId = schId;
    }

    public EmployeeSchedule(Integer schId, String schDate, String schFromTime, String schUntilTime, boolean emplVisitedCust) {
        this.schId = schId;
        this.schDate = schDate;
        this.schFromTime = schFromTime;
        this.schUntilTime = schUntilTime;
        this.emplVisitedCust = emplVisitedCust;
    }

    public Integer getSchId() {
        return schId;
    }

    public void setSchId(Integer schId) {
        this.schId = schId;
    }

    public String getSchDate() {
        return schDate;
    }

    public void setSchDate(String schDate) {
        this.schDate = schDate;
    }

    public String getSchFromTime() {
        return schFromTime;
    }

    public void setSchFromTime(String schFromTime) {
        this.schFromTime = schFromTime;
    }

    public String getSchUntilTime() {
        return schUntilTime;
    }

    public void setSchUntilTime(String schUntilTime) {
        this.schUntilTime = schUntilTime;
    }

    public boolean getEmplVisitedCust() {
        return emplVisitedCust;
    }

    public void setEmplVisitedCust(boolean emplVisitedCust) {
        this.emplVisitedCust = emplVisitedCust;
    }
    
    public Customers getCustomersCuId() {
        return customersCuId;
    }

    public void setCustomersCuId(Customers customersCuId) {
        this.customersCuId = customersCuId;
    }

    public Employees getEmployeesEmpId() {
        return employeesEmpId;
    }

    public void setEmployeesEmpId(Employees employeesEmpId) {
        this.employeesEmpId = employeesEmpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schId != null ? schId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeSchedule)) {
            return false;
        }
        EmployeeSchedule other = (EmployeeSchedule) object;
        if ((this.schId == null && other.schId != null) || (this.schId != null && !this.schId.equals(other.schId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EmployeeSchedule[ schId=" + schId + " ]";
    }
    
}
