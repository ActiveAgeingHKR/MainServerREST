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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t")
    , @NamedQuery(name = "Tasks.findByTaskId", query = "SELECT t FROM Tasks t WHERE t.taskId = :taskId")
    , @NamedQuery(name = "Tasks.findByTaskTitle", query = "SELECT t FROM Tasks t WHERE t.taskTitle = :taskTitle")
    , @NamedQuery(name = "Tasks.findByTaskContent", query = "SELECT t FROM Tasks t WHERE t.taskContent = :taskContent")
    , @NamedQuery(name = "Tasks.findByTaskdueDate", query = "SELECT t FROM Tasks t WHERE t.taskdueDate = :taskdueDate")
    , @NamedQuery(name = "Tasks.findTaskbyEmpId", query = "SELECT t FROM Tasks t,Employees e, e.tasksCollection etc WHERE t.taskId = etc.taskId AND e.empId = :empId")
    , @NamedQuery(name = "Tasks.findTaskbyEmpIdActive", query = "SELECT t FROM Tasks t,Employees e, e.tasksCollection etc WHERE t.taskId = etc.taskId AND e.empId = :empId AND t.taskCompl=false")  
    , @NamedQuery(name = "Tasks.getUpdatedTasksForEmp", query = "SELECT t FROM Tasks t,Employees e, e.tasksCollection etc WHERE t.taskId = etc.taskId "
            + "AND e.empId = :empId "
            + "AND t.taskCompl=false "
            + "AND t.taskId > :taskId")    
    , @NamedQuery(name = "Tasks.findByTaskCompl", query = "SELECT t FROM Tasks t WHERE t.taskCompl = :taskCompl")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "task_title")
    private String taskTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "task_content")
    private String taskContent;
    @Column(name = "task_dueDate")
    @Temporal(TemporalType.DATE)
    private Date taskdueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "task_compl")
    private boolean taskCompl;
    @ManyToMany(mappedBy = "tasksCollection")
    private Collection<Reminders> remindersCollection;

    public Tasks() {
    }

    public Tasks(Integer taskId) {
        this.taskId = taskId;
    }

    public Tasks(Integer taskId, String taskTitle, String taskContent, boolean taskCompl) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
        this.taskCompl = taskCompl;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Date getTaskdueDate() {
        return taskdueDate;
    }

    public void setTaskdueDate(Date taskdueDate) {
        this.taskdueDate = taskdueDate;
    }

    public boolean getTaskCompl() {
        return taskCompl;
    }

    public void setTaskCompl(boolean taskCompl) {
        this.taskCompl = taskCompl;
    }

    @XmlTransient
    public Collection<Reminders> getRemindersCollection() {
        return remindersCollection;
    }

    public void setRemindersCollection(Collection<Reminders> remindersCollection) {
        this.remindersCollection = remindersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tasks[ taskId=" + taskId + " ]";
    }
    
}
