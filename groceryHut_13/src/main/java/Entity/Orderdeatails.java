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
@Table(name = "orderdeatails")
@NamedQueries({
    @NamedQuery(name = "Orderdeatails.findAll", query = "SELECT o FROM Orderdeatails o"),
    @NamedQuery(name = "Orderdeatails.findByOrderId", query = "SELECT o FROM Orderdeatails o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orderdeatails.findByTaxAmt", query = "SELECT o FROM Orderdeatails o WHERE o.taxAmt = :taxAmt"),
    @NamedQuery(name = "Orderdeatails.findByGstAmt", query = "SELECT o FROM Orderdeatails o WHERE o.gstAmt = :gstAmt"),
    @NamedQuery(name = "Orderdeatails.findBySgstAmt", query = "SELECT o FROM Orderdeatails o WHERE o.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "Orderdeatails.findByPName", query = "SELECT o FROM Orderdeatails o WHERE o.pName = :pName"),
    @NamedQuery(name = "Orderdeatails.findByPQty", query = "SELECT o FROM Orderdeatails o WHERE o.pQty = :pQty"),
    @NamedQuery(name = "Orderdeatails.findByAmt", query = "SELECT o FROM Orderdeatails o WHERE o.amt = :amt"),
    @NamedQuery(name = "Orderdeatails.findByOdate", query = "SELECT o FROM Orderdeatails o WHERE o.odate = :odate")})
public class Orderdeatails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderId")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxAmt")
    private double taxAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gstAmt")
    private double gstAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sgstAmt")
    private double sgstAmt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "pName")
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pQty")
    private int pQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amt")
    private double amt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odate")
    @Temporal(TemporalType.DATE)
    private Date odate;
    @JoinColumn(name = "oId", referencedColumnName = "oId")
    @ManyToOne(optional = false)
    private Ordermaster oId;
    @JoinColumn(name = "pId", referencedColumnName = "pId")
    @ManyToOne(optional = false)
    private Manageproduct pId;
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    @ManyToOne(optional = false)
    private Registermaster regId;
    @JoinColumn(name = "addid", referencedColumnName = "addId")
    @ManyToOne(optional = false)
    private Addressmaster addid;

    public Orderdeatails() {
    }

    public Orderdeatails(Integer orderId) {
        this.orderId = orderId;
    }

    public Orderdeatails(Integer orderId, double taxAmt, double gstAmt, double sgstAmt, String pName, int pQty, double amt, Date odate) {
        this.orderId = orderId;
        this.taxAmt = taxAmt;
        this.gstAmt = gstAmt;
        this.sgstAmt = sgstAmt;
        this.pName = pName;
        this.pQty = pQty;
        this.amt = amt;
        this.odate = odate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(double taxAmt) {
        this.taxAmt = taxAmt;
    }

    public double getGstAmt() {
        return gstAmt;
    }

    public void setGstAmt(double gstAmt) {
        this.gstAmt = gstAmt;
    }

    public double getSgstAmt() {
        return sgstAmt;
    }

    public void setSgstAmt(double sgstAmt) {
        this.sgstAmt = sgstAmt;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public int getPQty() {
        return pQty;
    }

    public void setPQty(int pQty) {
        this.pQty = pQty;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Ordermaster getOId() {
        return oId;
    }

    public void setOId(Ordermaster oId) {
        this.oId = oId;
    }

    public Manageproduct getPId() {
        return pId;
    }

    public void setPId(Manageproduct pId) {
        this.pId = pId;
    }

    public Registermaster getRegId() {
        return regId;
    }

    public void setRegId(Registermaster regId) {
        this.regId = regId;
    }

    public Addressmaster getAddid() {
        return addid;
    }

    public void setAddid(Addressmaster addid) {
        this.addid = addid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdeatails)) {
            return false;
        }
        Orderdeatails other = (Orderdeatails) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orderdeatails[ orderId=" + orderId + " ]";
    }
    
}
