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
@Table(name = "managebrand")
@NamedQueries({
    @NamedQuery(name = "Managebrand.findAll", query = "SELECT m FROM Managebrand m"),
    @NamedQuery(name = "Managebrand.findByBId", query = "SELECT m FROM Managebrand m WHERE m.bId = :bId"),
    @NamedQuery(name = "Managebrand.findByBName", query = "SELECT m FROM Managebrand m WHERE m.bName = :bName")})
public class Managebrand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bId")
    private Integer bId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "bName")
    private String bName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bId")
    private Collection<Manageproduct> manageproductCollection;

    public Managebrand() {
    }

    public Managebrand(Integer bId) {
        this.bId = bId;
    }

    public Managebrand(Integer bId, String bName) {
        this.bId = bId;
        this.bName = bName;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    @JsonbTransient
    public Collection<Manageproduct> getManageproductCollection() {
        return manageproductCollection;
    }

    public void setManageproductCollection(Collection<Manageproduct> manageproductCollection) {
        this.manageproductCollection = manageproductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Managebrand)) {
            return false;
        }
        Managebrand other = (Managebrand) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Managebrand[ bId=" + bId + " ]";
    }

}
