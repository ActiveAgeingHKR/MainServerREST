/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n")
    , @NamedQuery(name = "Notes.findByNoteId", query = "SELECT n FROM Notes n WHERE n.notesPK.noteId = :noteId")
    , @NamedQuery(name = "Notes.findByEmployeesEmpId", query = "SELECT n FROM Notes n WHERE n.notesPK.employeesEmpId = :employeesEmpId")
    , @NamedQuery(name = "Notes.findByNoteTitle", query = "SELECT n FROM Notes n WHERE n.noteTitle = :noteTitle")
    , @NamedQuery(name = "Notes.findByContent", query = "SELECT n FROM Notes n WHERE n.content = :content")})
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotesPK notesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "note_title")
    private String noteTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;

    public Notes() {
    }

    public Notes(NotesPK notesPK) {
        this.notesPK = notesPK;
    }

    public Notes(NotesPK notesPK, String noteTitle, String content) {
        this.notesPK = notesPK;
        this.noteTitle = noteTitle;
        this.content = content;
    }

    public Notes(int noteId, int employeesEmpId) {
        this.notesPK = new NotesPK(noteId, employeesEmpId);
    }

    public NotesPK getNotesPK() {
        return notesPK;
    }

    public void setNotesPK(NotesPK notesPK) {
        this.notesPK = notesPK;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notesPK != null ? notesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.notesPK == null && other.notesPK != null) || (this.notesPK != null && !this.notesPK.equals(other.notesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notes[ notesPK=" + notesPK + " ]";
    }
    
}
