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
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "addressmaster")
@NamedQueries({
    @NamedQuery(name = "Addressmaster.findAll", query = "SELECT a FROM Addressmaster a"),
    @NamedQuery(name = "Addressmaster.findByAddId", query = "SELECT a FROM Addressmaster a WHERE a.addId = :addId"),
    @NamedQuery(name = "Addressmaster.findByPhoneNo", query = "SELECT a FROM Addressmaster a WHERE a.phoneNo = :phoneNo"),
    @NamedQuery(name = "Addressmaster.findByAtlPhoneNo", query = "SELECT a FROM Addressmaster a WHERE a.atlPhoneNo = :atlPhoneNo"),
    @NamedQuery(name = "Addressmaster.findByAddress", query = "SELECT a FROM Addressmaster a WHERE a.address = :address"),
    @NamedQuery(name = "Addressmaster.findByAltAddress", query = "SELECT a FROM Addressmaster a WHERE a.altAddress = :altAddress")})
public class Addressmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addId")
    private Integer addId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phoneNo")
    private int phoneNo;
    @Column(name = "AtlPhoneNo")
    private Integer atlPhoneNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "address")
    private String address;
    @Size(max = 250)
    @Column(name = "altAddress")
    private String altAddress;
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    @ManyToOne(optional = false)
    private Registermaster regId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addid")
    private Collection<Orderdeatails> orderdeatailsCollection;

    public Addressmaster() {
    }

    public Addressmaster(Integer addId) {
        this.addId = addId;
    }

    public Addressmaster(Integer addId, int phoneNo, String address) {
        this.addId = addId;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getAtlPhoneNo() {
        return atlPhoneNo;
    }

    public void setAtlPhoneNo(Integer atlPhoneNo) {
        this.atlPhoneNo = atlPhoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAltAddress() {
        return altAddress;
    }

    public void setAltAddress(String altAddress) {
        this.altAddress = altAddress;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addId != null ? addId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addressmaster)) {
            return false;
        }
        Addressmaster other = (Addressmaster) object;
        if ((this.addId == null && other.addId != null) || (this.addId != null && !this.addId.equals(other.addId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Addressmaster[ addId=" + addId + " ]";
    }

}
