/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "productreview")
@NamedQueries({
    @NamedQuery(name = "Productreview.findAll", query = "SELECT p FROM Productreview p"),
    @NamedQuery(name = "Productreview.findByReId", query = "SELECT p FROM Productreview p WHERE p.reId = :reId"),
    @NamedQuery(name = "Productreview.findByReview", query = "SELECT p FROM Productreview p WHERE p.review = :review"),
    @NamedQuery(name = "Productreview.findByDate", query = "SELECT p FROM Productreview p WHERE p.date = :date")})
public class Productreview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reId")
    private Integer reId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "review")
    private String review;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    @ManyToOne(optional = false)
    private Registermaster regId;
    @JoinColumn(name = "pId", referencedColumnName = "pId")
    @ManyToOne(optional = false)
    private Manageproduct pId;

    public Productreview() {
    }

    public Productreview(Integer reId) {
        this.reId = reId;
    }

    public Productreview(Integer reId, String review, Date date) {
        this.reId = reId;
        this.review = review;
        this.date = date;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Registermaster getRegId() {
        return regId;
    }

    public void setRegId(Registermaster regId) {
        this.regId = regId;
    }

    public Manageproduct getPId() {
        return pId;
    }

    public void setPId(Manageproduct pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reId != null ? reId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productreview)) {
            return false;
        }
        Productreview other = (Productreview) object;
        if ((this.reId == null && other.reId != null) || (this.reId != null && !this.reId.equals(other.reId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productreview[ reId=" + reId + " ]";
    }
    
}
