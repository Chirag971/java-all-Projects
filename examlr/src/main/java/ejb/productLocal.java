/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import JPA.Category;
import JPA.Product;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface productLocal {

    void addcategory(String catname);

    void delete(Integer cid);

    void updatecat(Integer cid, String catname);

    Collection<Category> getallcat();

    void addproduct(String pname, Integer price, Integer cid);

    void deletepro(Integer pid);

    void updatepro(Integer pid, String pname, Integer price, Integer cid);

    Collection<Product> getallproduct();
    
    Category getByid(Integer cid);
    
    Product getBypid(Integer pid);
}
