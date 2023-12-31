/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "getintouch")
@NamedQueries({
    @NamedQuery(name = "Getintouch.findAll", query = "SELECT g FROM Getintouch g"),
    @NamedQuery(name = "Getintouch.findByGetId", query = "SELECT g FROM Getintouch g WHERE g.getId = :getId"),
    @NamedQuery(name = "Getintouch.findByQuery", query = "SELECT g FROM Getintouch g WHERE g.query = :query"),
    @NamedQuery(name = "Getintouch.findByResponse", query = "SELECT g FROM Getintouch g WHERE g.response = :response")})
public class Getintouch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "getId")
    private Integer getId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "query")
    private String query;
    @Size(max = 250)
    @Column(name = "response")
    private String response;
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    @ManyToOne(optional = false)
    private Registermaster regId;

    public Getintouch() {
    }

    public Getintouch(Integer getId) {
        this.getId = getId;
    }

    public Getintouch(Integer getId, String query) {
        this.getId = getId;
        this.query = query;
    }

    public Integer getGetId() {
        return getId;
    }

    public void setGetId(Integer getId) {
        this.getId = getId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Registermaster getRegId() {
        return regId;
    }

    public void setRegId(Registermaster regId) {
        this.regId = regId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId != null ? getId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Getintouch)) {
            return false;
        }
        Getintouch other = (Getintouch) object;
        if ((this.getId == null && other.getId != null) || (this.getId != null && !this.getId.equals(other.getId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Getintouch[ getId=" + getId + " ]";
    }
    
}
