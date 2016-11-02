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
@Table(name = "incidents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidents.findAll", query = "SELECT i FROM Incidents i")
    , @NamedQuery(name = "Incidents.findByInId", query = "SELECT i FROM Incidents i WHERE i.inId = :inId")
    , @NamedQuery(name = "Incidents.findByInTime", query = "SELECT i FROM Incidents i WHERE i.inTime = :inTime")
    , @NamedQuery(name = "Incidents.findByInSeverity", query = "SELECT i FROM Incidents i WHERE i.inSeverity = :inSeverity")
    , @NamedQuery(name = "Incidents.findByInNotes", query = "SELECT i FROM Incidents i WHERE i.inNotes = :inNotes")})
public class Incidents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "in_id")
    private Integer inId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "in_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "in_severity")
    private String inSeverity;
    @Size(max = 165)
    @Column(name = "in_notes")
    private String inNotes;

    public Incidents() {
    }

    public Incidents(Integer inId) {
        this.inId = inId;
    }

    public Incidents(Integer inId, Date inTime, String inSeverity) {
        this.inId = inId;
        this.inTime = inTime;
        this.inSeverity = inSeverity;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getInSeverity() {
        return inSeverity;
    }

    public void setInSeverity(String inSeverity) {
        this.inSeverity = inSeverity;
    }

    public String getInNotes() {
        return inNotes;
    }

    public void setInNotes(String inNotes) {
        this.inNotes = inNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inId != null ? inId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidents)) {
            return false;
        }
        Incidents other = (Incidents) object;
        if ((this.inId == null && other.inId != null) || (this.inId != null && !this.inId.equals(other.inId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Incidents[ inId=" + inId + " ]";
    }
    
}
