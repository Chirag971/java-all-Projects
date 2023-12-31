/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import JPA.Category;
import JPA.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class product implements productLocal {

    @PersistenceContext(unitName = "lr")EntityManager em;
    
    @Override
    public void addcategory(String catname) {
       Category c = new Category();
       c.setCname(catname);
       em.persist(c);
    }

    @Override
    public void delete(Integer cid) {
        Category c = em.find(Category.class, cid);
        em.remove(c);
    }

    @Override
    public void updatecat(Integer cid, String catname) {
        Category c = em.find(Category.class, cid);
        c.setCname(catname);
        em.merge(c);
    }

    @Override
    public Collection<Category> getallcat() {
        Collection<Category> c = em.createNamedQuery("Category.findAll").getResultList();
        return c;
    }

    @Override
    public void addproduct(String pname, Integer price, Integer cid) {
        Category c = em.find(Category.class, cid);
        Product p = new Product();
        p.setPname(pname);
        p.setPrice(price);
        p.setCid(c);
        em.persist(p);
        
    }

    @Override
    public void deletepro(Integer pid) {
        Product p = em.find(Product.class, pid);
        em.remove(p);
        
    }

    @Override
    public void updatepro(Integer pid, String pname, Integer price, Integer cid) {
        Product p = em.find(Product.class, pid);
//        Category c = em.find(Category.class, cid);
        p.setPname(pname);
        p.setPrice(price);
        p.setCid(em.find(Category.class, cid));
        em.merge(p);
    }

    @Override
    public Collection<Product> getallproduct() {
       Collection<Product> p = em.createNamedQuery("Product.findAll").getResultList();
       return p;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Category getByid(Integer cid) {
       Category c = em.find(Category.class, cid);
       return c;
    }

    @Override
    public Product getBypid(Integer pid) {
      Product p = em.find(Product.class, pid);
      return p;
    }
}
