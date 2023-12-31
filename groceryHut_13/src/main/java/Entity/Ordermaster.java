/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "ordermaster")
@NamedQueries({
    @NamedQuery(name = "Ordermaster.findAll", query = "SELECT o FROM Ordermaster o"),
    @NamedQuery(name = "Ordermaster.findByOId", query = "SELECT o FROM Ordermaster o WHERE o.oId = :oId"),
    @NamedQuery(name = "Ordermaster.findByGrandTotal", query = "SELECT o FROM Ordermaster o WHERE o.grandTotal = :grandTotal")})
public class Ordermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oId")
    private Integer oId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grandTotal")
    private double grandTotal;
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    @ManyToOne(optional = false)
    private Registermaster regId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oId")
    private Collection<Orderdeatails> orderdeatailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oId")
    private Collection<Payment> paymentCollection;

    public Ordermaster() {
    }

    public Ordermaster(Integer oId) {
        this.oId = oId;
    }

    public Ordermaster(Integer oId, double grandTotal) {
        this.oId = oId;
        this.grandTotal = grandTotal;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Registermaster getRegId() {
        return regId;
    }

    public void setRegId(Registermaster regId) {
        this.regId = regId;
    }

    @JsonbTransient
    public Collection<Orderdeatails> getOrderdeatailsCollection() {
        return orderdeatailsCollection;
    }

    public void setOrderdeatailsCollection(Collection<Orderdeatails> orderdeatailsCollection) {
        this.orderdeatailsCollection = orderdeatailsCollection;
    }

    @JsonbTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oId != null ? oId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordermaster)) {
            return false;
        }
        Ordermaster other = (Ordermaster) object;
        if ((this.oId == null && other.oId != null) || (this.oId != null && !this.oId.equals(other.oId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ordermaster[ oId=" + oId + " ]";
    }

}
