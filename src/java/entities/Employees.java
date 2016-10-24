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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmpId", query = "SELECT e FROM Employees e WHERE e.empId = :empId")
    , @NamedQuery(name = "Employees.findByEmpFirstname", query = "SELECT e FROM Employees e WHERE e.empFirstname = :empFirstname")
    , @NamedQuery(name = "Employees.findByEmpLastname", query = "SELECT e FROM Employees e WHERE e.empLastname = :empLastname")
    , @NamedQuery(name = "Employees.findByEmpUsername", query = "SELECT e FROM Employees e WHERE e.empUsername = :empUsername")
    , @NamedQuery(name = "Employees.findByEmpPassword", query = "SELECT e FROM Employees e WHERE e.empPassword = :empPassword")
    , @NamedQuery(name = "Employees.findByEmpEmail", query = "SELECT e FROM Employees e WHERE e.empEmail = :empEmail")
    , @NamedQuery(name = "Employees.findByEmpPhone", query = "SELECT e FROM Employees e WHERE e.empPhone = :empPhone")
    , @NamedQuery(name = "Employees.findByEmpRegistered", query = "SELECT e FROM Employees e WHERE e.empRegistered = :empRegistered")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emp_firstname")
    private String empFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emp_lastname")
    private String empLastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "emp_username")
    private String empUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "emp_password")
    private String empPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emp_email")
    private String empEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "emp_phone")
    private String empPhone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_registered")
    private boolean empRegistered;
    @JoinColumn(name = "managers_man_id", referencedColumnName = "man_id")
    @ManyToOne(optional = false)
    private Managers managersManId;

    public Employees() {
    }

    public Employees(Integer empId) {
        this.empId = empId;
    }

    public Employees(Integer empId, String empFirstname, String empLastname, String empUsername, String empPassword, String empEmail, String empPhone, boolean empRegistered) {
        this.empId = empId;
        this.empFirstname = empFirstname;
        this.empLastname = empLastname;
        this.empUsername = empUsername;
        this.empPassword = empPassword;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empRegistered = empRegistered;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpFirstname() {
        return empFirstname;
    }

    public void setEmpFirstname(String empFirstname) {
        this.empFirstname = empFirstname;
    }

    public String getEmpLastname() {
        return empLastname;
    }

    public void setEmpLastname(String empLastname) {
        this.empLastname = empLastname;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public boolean getEmpRegistered() {
        return empRegistered;
    }

    public void setEmpRegistered(boolean empRegistered) {
        this.empRegistered = empRegistered;
    }

    public Managers getManagersManId() {
        return managersManId;
    }

    public void setManagersManId(Managers managersManId) {
        this.managersManId = managersManId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employees[ empId=" + empId + " ]";
    }
    
}
