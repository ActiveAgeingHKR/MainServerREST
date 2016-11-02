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
@Table(name = "visitor_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitorSchedule.findAll", query = "SELECT v FROM VisitorSchedule v")
    , @NamedQuery(name = "VisitorSchedule.findByVisSchId", query = "SELECT v FROM VisitorSchedule v WHERE v.visitorSchedulePK.visSchId = :visSchId")
    , @NamedQuery(name = "VisitorSchedule.findByVisitorsVisId", query = "SELECT v FROM VisitorSchedule v WHERE v.visitorSchedulePK.visitorsVisId = :visitorsVisId")
    , @NamedQuery(name = "VisitorSchedule.findByCustomersCuId", query = "SELECT v FROM VisitorSchedule v WHERE v.visitorSchedulePK.customersCuId = :customersCuId")
    , @NamedQuery(name = "VisitorSchedule.findByVisitStartDate", query = "SELECT v FROM VisitorSchedule v WHERE v.visitStartDate = :visitStartDate")
    , @NamedQuery(name = "VisitorSchedule.findByVisitStartTime", query = "SELECT v FROM VisitorSchedule v WHERE v.visitStartTime = :visitStartTime")
    , @NamedQuery(name = "VisitorSchedule.findByVisitEndTime", query = "SELECT v FROM VisitorSchedule v WHERE v.visitEndTime = :visitEndTime")
    , @NamedQuery(name = "VisitorSchedule.findByVisRepetitionCircle", query = "SELECT v FROM VisitorSchedule v WHERE v.visRepetitionCircle = :visRepetitionCircle")
    , @NamedQuery(name = "VisitorSchedule.findByVisitHash", query = "SELECT v FROM VisitorSchedule v WHERE v.visitHash = :visitHash")})
public class VisitorSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitorSchedulePK visitorSchedulePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_start_date")
    @Temporal(TemporalType.DATE)
    private Date visitStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_start_time")
    @Temporal(TemporalType.TIME)
    private Date visitStartTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_end_time")
    @Temporal(TemporalType.TIME)
    private Date visitEndTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "vis_repetition_circle")
    private String visRepetitionCircle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "visit_hash")
    private String visitHash;
    @JoinColumn(name = "visitors_vis_id", referencedColumnName = "vis_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Visitors visitors;

    public VisitorSchedule() {
    }

    public VisitorSchedule(VisitorSchedulePK visitorSchedulePK) {
        this.visitorSchedulePK = visitorSchedulePK;
    }

    public VisitorSchedule(VisitorSchedulePK visitorSchedulePK, Date visitStartDate, Date visitStartTime, Date visitEndTime, String visRepetitionCircle, String visitHash) {
        this.visitorSchedulePK = visitorSchedulePK;
        this.visitStartDate = visitStartDate;
        this.visitStartTime = visitStartTime;
        this.visitEndTime = visitEndTime;
        this.visRepetitionCircle = visRepetitionCircle;
        this.visitHash = visitHash;
    }

    public VisitorSchedule(int visSchId, int visitorsVisId, int customersCuId) {
        this.visitorSchedulePK = new VisitorSchedulePK(visSchId, visitorsVisId, customersCuId);
    }

    public VisitorSchedulePK getVisitorSchedulePK() {
        return visitorSchedulePK;
    }

    public void setVisitorSchedulePK(VisitorSchedulePK visitorSchedulePK) {
        this.visitorSchedulePK = visitorSchedulePK;
    }

    public Date getVisitStartDate() {
        return visitStartDate;
    }

    public void setVisitStartDate(Date visitStartDate) {
        this.visitStartDate = visitStartDate;
    }

    public Date getVisitStartTime() {
        return visitStartTime;
    }

    public void setVisitStartTime(Date visitStartTime) {
        this.visitStartTime = visitStartTime;
    }

    public Date getVisitEndTime() {
        return visitEndTime;
    }

    public void setVisitEndTime(Date visitEndTime) {
        this.visitEndTime = visitEndTime;
    }

    public String getVisRepetitionCircle() {
        return visRepetitionCircle;
    }

    public void setVisRepetitionCircle(String visRepetitionCircle) {
        this.visRepetitionCircle = visRepetitionCircle;
    }

    public String getVisitHash() {
        return visitHash;
    }

    public void setVisitHash(String visitHash) {
        this.visitHash = visitHash;
    }

    public Visitors getVisitors() {
        return visitors;
    }

    public void setVisitors(Visitors visitors) {
        this.visitors = visitors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitorSchedulePK != null ? visitorSchedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitorSchedule)) {
            return false;
        }
        VisitorSchedule other = (VisitorSchedule) object;
        if ((this.visitorSchedulePK == null && other.visitorSchedulePK != null) || (this.visitorSchedulePK != null && !this.visitorSchedulePK.equals(other.visitorSchedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VisitorSchedule[ visitorSchedulePK=" + visitorSchedulePK + " ]";
    }
    
}
