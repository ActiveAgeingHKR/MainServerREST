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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "visitors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitors.findAll", query = "SELECT v FROM Visitors v")
    , @NamedQuery(name = "Visitors.findByVisId", query = "SELECT v FROM Visitors v WHERE v.visId = :visId")
    , @NamedQuery(name = "Visitors.findByVisFirstname", query = "SELECT v FROM Visitors v WHERE v.visFirstname = :visFirstname")
    , @NamedQuery(name = "Visitors.findByVisLastname", query = "SELECT v FROM Visitors v WHERE v.visLastname = :visLastname")
    , @NamedQuery(name = "Visitors.findByVisEmail", query = "SELECT v FROM Visitors v WHERE v.visEmail = :visEmail")
    , @NamedQuery(name = "Visitors.findByVisPhone", query = "SELECT v FROM Visitors v WHERE v.visPhone = :visPhone")
        //NEW
    , @NamedQuery(name = "Visitors.searchForFirstName", query = "SELECT v FROM Visitors v WHERE v.visFirstname LIKE :visFirstname ORDER BY v.visFirstname")})
public class Visitors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vis_id")
    private String visId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vis_firstname")
    private String visFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vis_lastname")
    private String visLastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vis_email")
    private String visEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "vis_phone")
    private String visPhone;
    @JoinColumn(name = "company_comp_id", referencedColumnName = "comp_id")
    @ManyToOne(optional = false)
    private Company companyCompId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitors")
    private Collection<VisitorSchedule> visitorScheduleCollection;

    public Visitors() {
    }

    public Visitors(String visId) {
        this.visId = visId;
    }

    public Visitors(String visId, String visFirstname, String visLastname, String visEmail, String visPhone) {
        this.visId = visId;
        this.visFirstname = visFirstname;
        this.visLastname = visLastname;
        this.visEmail = visEmail;
        this.visPhone = visPhone;
    }

    public String getVisId() {
        return visId;
    }

    public void setVisId(String visId) {
        this.visId = visId;
    }

    public String getVisFirstname() {
        return visFirstname;
    }

    public void setVisFirstname(String visFirstname) {
        this.visFirstname = visFirstname;
    }

    public String getVisLastname() {
        return visLastname;
    }

    public void setVisLastname(String visLastname) {
        this.visLastname = visLastname;
    }

    public String getVisEmail() {
        return visEmail;
    }

    public void setVisEmail(String visEmail) {
        this.visEmail = visEmail;
    }

    public String getVisPhone() {
        return visPhone;
    }

    public void setVisPhone(String visPhone) {
        this.visPhone = visPhone;
    }

    public Company getCompanyCompId() {
        return companyCompId;
    }

    public void setCompanyCompId(Company companyCompId) {
        this.companyCompId = companyCompId;
    }

    @XmlTransient
    public Collection<VisitorSchedule> getVisitorScheduleCollection() {
        return visitorScheduleCollection;
    }

    public void setVisitorScheduleCollection(Collection<VisitorSchedule> visitorScheduleCollection) {
        this.visitorScheduleCollection = visitorScheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visId != null ? visId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitors)) {
            return false;
        }
        Visitors other = (Visitors) object;
        if ((this.visId == null && other.visId != null) || (this.visId != null && !this.visId.equals(other.visId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Visitors[ visId=" + visId + " ]";
    }
    
}
