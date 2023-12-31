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
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPayId", query = "SELECT p FROM Payment p WHERE p.payId = :payId"),
    @NamedQuery(name = "Payment.findByPaymentMode", query = "SELECT p FROM Payment p WHERE p.paymentMode = :paymentMode"),
    @NamedQuery(name = "Payment.findByUpiId", query = "SELECT p FROM Payment p WHERE p.upiId = :upiId"),
    @NamedQuery(name = "Payment.findByAmt", query = "SELECT p FROM Payment p WHERE p.amt = :amt")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payId")
    private Integer payId;
    @Size(max = 250)
    @Column(name = "paymentMode")
    private String paymentMode;
    @Size(max = 100)
    @Column(name = "upiId")
    private String upiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amt")
    private int amt;
    @JoinColumn(name = "oId", referencedColumnName = "oId")
    @ManyToOne(optional = false)
    private Ordermaster oId;
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    @ManyToOne(optional = false)
    private Registermaster regId;

    public Payment() {
    }

    public Payment(Integer payId) {
        this.payId = payId;
    }

    public Payment(Integer payId, int amt) {
        this.payId = payId;
        this.amt = amt;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public Ordermaster getOId() {
        return oId;
    }

    public void setOId(Ordermaster oId) {
        this.oId = oId;
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
        hash += (payId != null ? payId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.payId == null && other.payId != null) || (this.payId != null && !this.payId.equals(other.payId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Payment[ payId=" + payId + " ]";
    }
    
}
