/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Beand;

import Client.productClient;
import JPA.Product;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "productCDI")
@RequestScoped
public class productCDI {

    productClient p;
    Response rs;
    String pname,pid;
    Integer cid,price;
    
    Product pro = new Product();
    
    GenericType<Collection<Product>> gproduct;
    public productCDI() {
        p = new productClient();
        gproduct = new GenericType<Collection<Product>>(){};
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }
   
    public Collection<Product> getAllProduct(){
        return p.getAllProduct(Response.class).readEntity(gproduct);
    }
    
    public String InPRoduct(Integer cid){
        String cids = cid.toString();
        this.pro.setPname(pname);
        this.pro.setPrice(price);
        p.addProduct(pro, cids);
        return "Product.jsf?faces-redirect=true";
    }
    
    public String delProduct(Integer pid){
         String pids = pid.toString();
        p.deletePro(pids);
        return "Product.jsf?faces-redirect=true";
    }
}