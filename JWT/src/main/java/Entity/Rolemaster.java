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
@Table(name = "rolemaster")
@NamedQueries({
    @NamedQuery(name = "Rolemaster.findAll", query = "SELECT r FROM Rolemaster r"),
    @NamedQuery(name = "Rolemaster.findByUserName", query = "SELECT r FROM Rolemaster r WHERE r.userName = :userName"),
    @NamedQuery(name = "Rolemaster.findByRole", query = "SELECT r FROM Rolemaster r WHERE r.role = :role")})
public class Rolemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userName")
    private Collection<Registermaster> registermasterCollection;

    public Rolemaster() {
    }

    public Rolemaster(String userName) {
        this.userName = userName;
    }

    public Rolemaster(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Registermaster> getRegistermasterCollection() {
        return registermasterCollection;
    }

    public void setRegistermasterCollection(Collection<Registermaster> registermasterCollection) {
        this.registermasterCollection = registermasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolemaster)) {
            return false;
        }
        Rolemaster other = (Rolemaster) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Rolemaster[ userName=" + userName + " ]";
    }
    
}
