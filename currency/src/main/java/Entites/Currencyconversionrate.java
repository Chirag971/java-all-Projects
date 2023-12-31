/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entites;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "currencyconversionrate")
@NamedQueries({
    @NamedQuery(name = "Currencyconversionrate.findAll", query = "SELECT c FROM Currencyconversionrate c"),
    @NamedQuery(name = "Currencyconversionrate.findById", query = "SELECT c FROM Currencyconversionrate c WHERE c.id = :id"),
    @NamedQuery(name = "Currencyconversionrate.findByFromCurrency", query = "SELECT c FROM Currencyconversionrate c WHERE c.fromCurrency = :fromCurrency"),
    @NamedQuery(name = "Currencyconversionrate.findByToCurrency", query = "SELECT c FROM Currencyconversionrate c WHERE c.toCurrency = :toCurrency"),
    @NamedQuery(name = "Currencyconversionrate.findByConversionRate", query = "SELECT c FROM Currencyconversionrate c WHERE c.conversionRate = :conversionRate")})
public class Currencyconversionrate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 3)
    @Column(name = "from_currency")
    private String fromCurrency;
    @Size(max = 3)
    @Column(name = "to_currency")
    private String toCurrency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;

    public Currencyconversionrate() {
    }

    public Currencyconversionrate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currencyconversionrate)) {
            return false;
        }
        Currencyconversionrate other = (Currencyconversionrate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Currencyconversionrate[ id=" + id + " ]";
    }
    
}
