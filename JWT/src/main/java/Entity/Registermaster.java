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
@Table(name = "registermaster")
@NamedQueries({
    @NamedQuery(name = "Registermaster.findAll", query = "SELECT r FROM Registermaster r"),
    @NamedQuery(name = "Registermaster.findByRegId", query = "SELECT r FROM Registermaster r WHERE r.regId = :regId"),
    @NamedQuery(name = "Registermaster.findByName", query = "SELECT r FROM Registermaster r WHERE r.name = :name"),
    @NamedQuery(name = "Registermaster.findByEmail", query = "SELECT r FROM Registermaster r WHERE r.email = :email"),
    @NamedQuery(name = "Registermaster.findByPassword", query = "SELECT r FROM Registermaster r WHERE r.password = :password")})
public class Registermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "regId")
    private Integer regId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    @ManyToOne(optional = false)
    private Rolemaster userName;

    public Registermaster() {
    }

    public Registermaster(Integer regId) {
        this.regId = regId;
    }

    public Registermaster(Integer regId, String name, String email, String password) {
        this.regId = regId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rolemaster getUserName() {
        return userName;
    }

    public void setUserName(Rolemaster userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registermaster)) {
            return false;
        }
        Registermaster other = (Registermaster) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Registermaster[ regId=" + regId + " ]";
    }
    
}
