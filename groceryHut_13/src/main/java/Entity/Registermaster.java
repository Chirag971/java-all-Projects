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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Addressmaster> addressmasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Productreview> productreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Ordermaster> ordermasterCollection;
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    @ManyToOne(optional = false)
    private Rolemaster userName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Orderdeatails> orderdeatailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Getintouch> getintouchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Payment> paymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Cart> cartCollection;

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

    @JsonbTransient
    public Collection<Addressmaster> getAddressmasterCollection() {
        return addressmasterCollection;
    }

    public void setAddressmasterCollection(Collection<Addressmaster> addressmasterCollection) {
        this.addressmasterCollection = addressmasterCollection;
    }

    @JsonbTransient
    public Collection<Productreview> getProductreviewCollection() {
        return productreviewCollection;
    }

    public void setProductreviewCollection(Collection<Productreview> productreviewCollection) {
        this.productreviewCollection = productreviewCollection;
    }

    @JsonbTransient
    public Collection<Ordermaster> getOrdermasterCollection() {
        return ordermasterCollection;
    }

    public void setOrdermasterCollection(Collection<Ordermaster> ordermasterCollection) {
        this.ordermasterCollection = ordermasterCollection;
    }

    public Rolemaster getUserName() {
        return userName;
    }

    public void setUserName(Rolemaster userName) {
        this.userName = userName;
    }

    @JsonbTransient
    public Collection<Orderdeatails> getOrderdeatailsCollection() {
        return orderdeatailsCollection;
    }

    public void setOrderdeatailsCollection(Collection<Orderdeatails> orderdeatailsCollection) {
        this.orderdeatailsCollection = orderdeatailsCollection;
    }

    @JsonbTransient
    public Collection<Getintouch> getGetintouchCollection() {
        return getintouchCollection;
    }

    public void setGetintouchCollection(Collection<Getintouch> getintouchCollection) {
        this.getintouchCollection = getintouchCollection;
    }

    @JsonbTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @JsonbTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
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
