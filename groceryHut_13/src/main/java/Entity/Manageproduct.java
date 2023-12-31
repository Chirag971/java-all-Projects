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
@Table(name = "manageproduct")
@NamedQueries({
    @NamedQuery(name = "Manageproduct.findAll", query = "SELECT m FROM Manageproduct m"),
    @NamedQuery(name = "Manageproduct.findByPId", query = "SELECT m FROM Manageproduct m WHERE m.pId = :pId"),
    @NamedQuery(name = "Manageproduct.findByPName", query = "SELECT m FROM Manageproduct m WHERE m.pName = :pName"),
    @NamedQuery(name = "Manageproduct.findByPImage", query = "SELECT m FROM Manageproduct m WHERE m.pImage = :pImage"),
    @NamedQuery(name = "Manageproduct.findByAmmount", query = "SELECT m FROM Manageproduct m WHERE m.ammount = :ammount"),
    @NamedQuery(name = "Manageproduct.findByDescription", query = "SELECT m FROM Manageproduct m WHERE m.description = :description"),
    @NamedQuery(name = "Manageproduct.findByUnit", query = "SELECT m FROM Manageproduct m WHERE m.unit = :unit"),
    @NamedQuery(name = "Manageproduct.findByStock", query = "SELECT m FROM Manageproduct m WHERE m.stock = :stock"),
    @NamedQuery(name = "Manageproduct.findByDiscount", query = "SELECT m FROM Manageproduct m WHERE m.discount = :discount"),
    @NamedQuery(name = "Manageproduct.findByDiscountedPrice", query = "SELECT m FROM Manageproduct m WHERE m.discountedPrice = :discountedPrice"),
    @NamedQuery(name = "Manageproduct.findByTax", query = "SELECT m FROM Manageproduct m WHERE m.tax = :tax"),
    @NamedQuery(name = "Manageproduct.findByGst", query = "SELECT m FROM Manageproduct m WHERE m.gst = :gst"),
    @NamedQuery(name = "Manageproduct.findBySgst", query = "SELECT m FROM Manageproduct m WHERE m.sgst = :sgst"),
    @NamedQuery(name = "Manageproduct.findByTotalDiscount", query = "SELECT m FROM Manageproduct m WHERE m.totalDiscount = :totalDiscount")})
public class Manageproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pId")
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "pName")
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "pImage")
    private String pImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ammount")
    private double ammount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit")
    private int unit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discount")
    private Double discount;
    @Column(name = "discountedPrice")
    private Double discountedPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private double tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gst")
    private double gst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sgst")
    private double sgst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalDiscount")
    private double totalDiscount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Productreview> productreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Orderdeatails> orderdeatailsCollection;
    @JoinColumn(name = "cId", referencedColumnName = "cId")
    @ManyToOne(optional = false)
    private Managecategory cId;
    @JoinColumn(name = "bId", referencedColumnName = "bId")
    @ManyToOne(optional = false)
    private Managebrand bId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Cart> cartCollection;

    public Manageproduct() {
    }

    public Manageproduct(Integer pId) {
        this.pId = pId;
    }

    public Manageproduct(Integer pId, String pName, String pImage, double ammount, String description, int unit, int stock, double tax, double gst, double sgst, double totalDiscount) {
        this.pId = pId;
        this.pName = pName;
        this.pImage = pImage;
        this.ammount = ammount;
        this.description = description;
        this.unit = unit;
        this.stock = stock;
        this.tax = tax;
        this.gst = gst;
        this.sgst = sgst;
        this.totalDiscount = totalDiscount;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPImage() {
        return pImage;
    }

    public void setPImage(String pImage) {
        this.pImage = pImage;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getSgst() {
        return sgst;
    }

    public void setSgst(double sgst) {
        this.sgst = sgst;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @JsonbTransient
    public Collection<Productreview> getProductreviewCollection() {
        return productreviewCollection;
    }

    public void setProductreviewCollection(Collection<Productreview> productreviewCollection) {
        this.productreviewCollection = productreviewCollection;
    }

    @JsonbTransient
    public Collection<Orderdeatails> getOrderdeatailsCollection() {
        return orderdeatailsCollection;
    }

    public void setOrderdeatailsCollection(Collection<Orderdeatails> orderdeatailsCollection) {
        this.orderdeatailsCollection = orderdeatailsCollection;
    }

    public Managecategory getCId() {
        return cId;
    }

    public void setCId(Managecategory cId) {
        this.cId = cId;
    }

    public Managebrand getBId() {
        return bId;
    }

    public void setBId(Managebrand bId) {
        this.bId = bId;
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
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manageproduct)) {
            return false;
        }
        Manageproduct other = (Manageproduct) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Manageproduct[ pId=" + pId + " ]";
    }

}
