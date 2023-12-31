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
@Table(name = "managecategory")
@NamedQueries({
    @NamedQuery(name = "Managecategory.findAll", query = "SELECT m FROM Managecategory m"),
    @NamedQuery(name = "Managecategory.findByCId", query = "SELECT m FROM Managecategory m WHERE m.cId = :cId"),
    @NamedQuery(name = "Managecategory.findByCName", query = "SELECT m FROM Managecategory m WHERE m.cName = :cName"),
    @NamedQuery(name = "Managecategory.findByCImage", query = "SELECT m FROM Managecategory m WHERE m.cImage = :cImage")})
public class Managecategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cId")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cName")
    private String cName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "cImage")
    private String cImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cId")
    private Collection<Manageproduct> manageproductCollection;

    public Managecategory() {
    }

    public Managecategory(Integer cId) {
        this.cId = cId;
    }

    public Managecategory(Integer cId, String cName, String cImage) {
        this.cId = cId;
        this.cName = cName;
        this.cImage = cImage;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCImage() {
        return cImage;
    }

    public void setCImage(String cImage) {
        this.cImage = cImage;
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
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Managecategory)) {
            return false;
        }
        Managecategory other = (Managecategory) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Managecategory[ cId=" + cId + " ]";
    }

}
