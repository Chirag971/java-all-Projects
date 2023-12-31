/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "groupmaster")
@NamedQueries({
    @NamedQuery(name = "Groupmaster.findAll", query = "SELECT g FROM Groupmaster g"),
    @NamedQuery(name = "Groupmaster.findByGid", query = "SELECT g FROM Groupmaster g WHERE g.gid = :gid"),
    @NamedQuery(name = "Groupmaster.findByGname", query = "SELECT g FROM Groupmaster g WHERE g.gname = :gname")})
public class Groupmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gid")
    private int gid;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "gname")
    private String gname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gname")
    private Collection<Usermaster> usermasterCollection;

    public Groupmaster() {
    }

    public Groupmaster(String gname) {
        this.gname = gname;
    }

    public Groupmaster(String gname, int gid) {
        this.gname = gname;
        this.gid = gid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Collection<Usermaster> getUsermasterCollection() {
        return usermasterCollection;
    }

    public void setUsermasterCollection(Collection<Usermaster> usermasterCollection) {
        this.usermasterCollection = usermasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gname != null ? gname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupmaster)) {
            return false;
        }
        Groupmaster other = (Groupmaster) object;
        if ((this.gname == null && other.gname != null) || (this.gname != null && !this.gname.equals(other.gname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Groupmaster[ gname=" + gname + " ]";
    }
    
}
