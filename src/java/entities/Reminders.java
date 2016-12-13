/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "reminders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reminders.findAll", query = "SELECT r FROM Reminders r")
    , @NamedQuery(name = "Reminders.findByRemId", query = "SELECT r FROM Reminders r WHERE r.remId = :remId")
    , @NamedQuery(name = "Reminders.findByRemDate", query = "SELECT r FROM Reminders r WHERE r.remDate = :remDate")
    , @NamedQuery(name = "Reminders.findByRemTime", query = "SELECT r FROM Reminders r WHERE r.remTime = :remTime")})
public class Reminders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rem_id")
    private Integer remId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rem_date")
    @Temporal(TemporalType.DATE)
    private Date remDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rem_time")
    @Temporal(TemporalType.DATE)
    private Date remTime;
    @JoinTable(name = "tasks_has_reminders", joinColumns = {
        @JoinColumn(name = "reminders_rem_id", referencedColumnName = "rem_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tasks_task_id", referencedColumnName = "task_id")})
    @ManyToMany
    private Collection<Tasks> tasksCollection;

    public Reminders() {
    }

    public Reminders(Integer remId) {
        this.remId = remId;
    }

    public Reminders(Integer remId, Date remDate, Date remTime) {
        this.remId = remId;
        this.remDate = remDate;
        this.remTime = remTime;
    }

    public Integer getRemId() {
        return remId;
    }

    public void setRemId(Integer remId) {
        this.remId = remId;
    }

    public Date getRemDate() {
        return remDate;
    }

    public void setRemDate(Date remDate) {
        this.remDate = remDate;
    }

    public Date getRemTime() {
        return remTime;
    }

    public void setRemTime(Date remTime) {
        this.remTime = remTime;
    }

    @XmlTransient
    public Collection<Tasks> getTasksCollection() {
        return tasksCollection;
    }

    public void setTasksCollection(Collection<Tasks> tasksCollection) {
        this.tasksCollection = tasksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (remId != null ? remId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reminders)) {
            return false;
        }
        Reminders other = (Reminders) object;
        if ((this.remId == null && other.remId != null) || (this.remId != null && !this.remId.equals(other.remId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reminders[ remId=" + remId + " ]";
    }
    
}
