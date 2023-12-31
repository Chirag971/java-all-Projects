/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Bean;

import Entity.Addressmaster;
import Entity.Cart;
import Entity.Getintouch;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Productreview;
import Entity.Registermaster;
import client.userClient;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "userCDI")
@RequestScoped
public class UserCDI {

    Response rs;
    userClient ul;

//User
    String name, email, password, username;
    Registermaster reg = new Registermaster();

    String pname, description, pimage, category, brand, pid, cid;
    Integer unit, stock, qty;
    Double ammount, discount, discountedprice, totaldiscount;

    Collection<Cart> cart;
    GenericType<Collection<Cart>> gcart;

    Collection<Manageproduct> pro;
    GenericType<Collection<Manageproduct>> gpro;
//    Review
    GenericType<Collection<Productreview>> gpreview;
    GenericType<Collection<Orderdeatails>> gorder;
    Productreview pre = new Productreview();
    String review;
//address
    GenericType<Collection<Addressmaster>> gadd;
    Addressmaster ad = new Addressmaster();
    Integer phone,altphone,addId;
    String addrs,altaddrs;
    
//    getintouch
    GenericType<Collection<Getintouch>> ggit;
    Getintouch gt = new Getintouch();
    String query;
    
    public UserCDI() {
        ul = new userClient();
        cart = new ArrayList<>();
        gcart = new GenericType<Collection<Cart>>() {
        };
        gpro = new GenericType<Collection<Manageproduct>>() {
        };      
        gpreview = new GenericType<Collection<Productreview>>() {
        };
        gorder = new GenericType<Collection<Orderdeatails>>(){};
        gadd = new GenericType<Collection<Addressmaster>>(){};
        ggit = new GenericType<Collection<Getintouch>>(){};
    }

    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(false);
    Integer userid = (Integer) session.getAttribute("User");
    String usern = (String) session.getAttribute("Username");

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Registermaster getReg() {
        return reg;
    }

    public void setReg(Registermaster reg) {
        this.reg = reg;
    }

    public String register(String username) {
        this.reg.setName(name);
        this.reg.setEmail(email);
        this.reg.setPassword(password);
        rs = ul.registerUsermaster(this.reg, username);
        if (rs != null) {
            return "Login.jsf?faces-redirect=true";
        } else {
            return "something went wrong";
        }
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Double getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(Double discountedprice) {
        this.discountedprice = discountedprice;
    }

    public Double getTotaldiscount() {
        return totaldiscount;
    }

    public void setTotaldiscount(Double totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void emptyCart() {
        this.qty = null;
    }

    public Addressmaster getAd() {
        return ad;
    }

    public void setAd(Addressmaster ad) {
        this.ad = ad;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getAltphone() {
        return altphone;
    }

    public void setAltphone(Integer altphone) {
        this.altphone = altphone;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public String getAltaddrs() {
        return altaddrs;
    }

    public void setAltaddrs(String altaddrs) {
        this.altaddrs = altaddrs;
    }

    public Getintouch getGt() {
        return gt;
    }

    public void setGt(Getintouch gt) {
        this.gt = gt;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String addToCart() {
        System.out.println("Email:" + userid);
        System.out.println("ProductId" + pid);
        System.out.println("Quantity:" + qty);
        String uid = userid.toString();
        String qtys = qty.toString();

        rs = ul.addToCart(uid, pid, qtys);
        this.emptyCart();
        if (rs != null) {
            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
         return "Products.jsf?faces-redirect=true";
    }

    public void loaddetails() {
        GenericType<Manageproduct> pro = new GenericType<Manageproduct>() {
        };
        rs = ul.getProductById(Response.class, pid);

        if (rs != null && rs.getStatus() == 200) { // Check if the response is successful
            Manageproduct p = rs.readEntity(pro);

            if (p != null) {
                this.setPname(p.getPName());
                this.setPimage(p.getPImage());
                this.setDescription(p.getDescription());
                this.setAmmount(p.getAmmount());
                this.setDiscount(p.getDiscount());
                this.setDiscountedprice(p.getDiscountedPrice());
                this.setCategory(p.getCId().getCName());
                this.setBrand(p.getBId().getBName());
                this.setUnit(p.getUnit());
                this.setStock(p.getStock());
                this.setTotaldiscount(p.getTotalDiscount());
            } else {
                // Handle the case when the response does not contain a valid Manageproduct object
                System.out.println("Error: Invalid response data");
            }
        } else {
            // Handle the case when the response is not successful
            System.out.println("Error: Unable to retrieve product details");
        }
    }

    public Collection<Cart> getAllCart() {
        String uid = userid.toString();
        rs = ul.viewCart(Response.class, uid);
        cart = rs.readEntity(gcart);
        return cart;
    }

    public void removeCart(Integer id) {
        String pids = id.toString();
        String uid = userid.toString();
        System.out.println(pids);
        System.out.println(uid);
        ul.removeCart(uid, pids);

    }

    public Collection<Manageproduct> getProByCat() {
        rs = ul.getProductByCat(Response.class, cid);
        pro = rs.readEntity(gpro);
        return pro;
    }

    public Collection<Addressmaster> getAddByuid(){
         String uid = userid.toString();
        return ul.getAddresses(Response.class, uid).readEntity(gadd);
    }
    
    public String addAddress(){
        String uid = userid.toString();
        this.ad.setAddress(addrs);
        this.ad.setAltAddress(altaddrs);
        this.ad.setPhoneNo(phone);
        this.ad.setAtlPhoneNo(altphone);
        
        rs = ul.addAddresses(ad, uid);
        if (rs != null) {

            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
        return "Address.jsf?faces-redirect=true";
    }
   
    public String checkout(Integer aid) {
        String uid = userid.toString();
        String adids = aid.toString();
                      
        rs = ul.placeOrder(uid,adids);
        if (rs != null) {

            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
        return "Success.jsf?faces-redirect=true";
    }

    public Productreview getPre() {
        return pre;
    }

    public void setPre(Productreview pre) {
        this.pre = pre;
    }

     public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
    public Collection<Productreview> getReviewByPro() {
        return ul.getReview(Response.class, pid).readEntity(gpreview);
       
    }

    public String insertReview() {
        String uid = userid.toString();
        this.pre.setReview(review);
        System.out.println("uid :"+uid);
        System.out.println("review :"+ pre.getReview());
        System.out.println("pid :" + pid);
        rs = ul.addReview(pre, uid, pid);
        if (rs != null) {
            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
        return "Products.jsf?faces-redirect=true";
    }

    public Collection<Orderdeatails> getAllOrder(){
         String uid = userid.toString();
        return ul.getOrderById(Response.class, uid).readEntity(gorder);
    }
    
    public Collection<Getintouch> getAllgetintouch(){
        String uid = userid.toString();
        return ul.getQueriesByUser(Response.class,uid).readEntity(ggit);
    }
    
    public String addQuery(){
        this.gt.setQuery(query);
        String uid = userid.toString();
         rs = ul.addGit(gt, uid);
        if (rs != null) {

            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
        return "getintouch.jsf?faces-redirect=true";
    }
    
    
}
