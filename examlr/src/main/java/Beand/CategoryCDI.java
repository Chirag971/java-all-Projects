/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Beand;

import Client.productClient;
import JPA.Category;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "categoryCDI")
@RequestScoped
public class CategoryCDI {

    productClient p;
    Response rs;
    
    GenericType<Collection<Category>> gcat;
    String cid,cname;
    Category c = new Category();
    public CategoryCDI() {
        p = new productClient();
        gcat = new GenericType<Collection<Category>>(){};
        
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }
    
    public Collection<Category> getAllCategory(){
        return p.getAllCategory(Response.class).readEntity(gcat);
    }
    
   public String addCategory(){
       this.c.setCname(cname);
       p.addCategory(c);
       return "Category.jsf?faces-redirect=true";
   }
   
   public String deletecat(Integer cid){
       String cids = cid.toString();
       p.deleteCat(cids);
       return "Category.jsf?faces-redirect=true";
   }
     
   public String getByCid(Integer cid){
       String cids = cid.toString();
       rs = p.getByCid(Response.class, cids);
       GenericType<Category> cat = new GenericType<Category>(){};
       Category ca = rs.readEntity(cat);
       this.setCid(cids);
       this.setCname(ca.getCname());
       return "UpdateCategory.jsf";
   }
   
   public String updateCat(String cid){
       this.c.setCname(cname);
       p.updateCat(c, cid);
        return "Category.jsf?faces-redirect=true";
   }
    
}
