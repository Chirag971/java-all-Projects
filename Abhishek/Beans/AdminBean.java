/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import Entity.Contactus;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productcategory;
import Entity.Products;
import Entity.Userregister;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdminBean implements AdminBeanLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public Collection<Userregister> getAllUserRegister() {
        try {
            Collection<Userregister> custs = em.createNamedQuery("Userregister.findAll").getResultList();
            return custs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<Products> getAllProducts() {
        try {
            Collection<Products> products = em.createNamedQuery("Products.findAll").getResultList();
            return products;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void addProduct(String productName, Double price, int quantity, Double tax, Double gst, int categoryId, String description, String image) {
        try {
            Products prods = new Products();
            prods.setProductname(productName);
            prods.setPrice(price);
            prods.setQuntity(quantity);
            prods.setTax(tax);
            prods.setGst(gst);

            Productcategory category = em.find(Productcategory.class, categoryId);

            if (category != null) {
                prods.setProductcategory(category);
                System.out.println("Category found: " + category.getCategoryname());
            } else {
                System.out.println("Category not found for categoryId: " + categoryId);
            }

            prods.setDescription(description);
            prods.setImage(image);

            em.persist(prods);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(int productid) {
        try {
            Products product = em.find(Products.class, productid);
            em.remove(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateProduct(int productid, String productName, Double price, int quantity, Double tax, Double gst, int categoryid, String discription, String image) {
        try {
            Products existingProduct = em.find(Products.class, productid);

            if (existingProduct != null) {
                existingProduct.setProductname(productName);
                existingProduct.setPrice(price);
                existingProduct.setQuntity(quantity);

                Productcategory existingCategory = em.find(Productcategory.class, categoryid);
                if (existingCategory != null) {
                    existingProduct.setProductcategory(existingCategory);
                    existingProduct.setDescription(discription);
                    existingProduct.setImage(image);

                    em.merge(existingProduct);
                } else {
                    throw new IllegalArgumentException("Categoryid not found for update product!!!");
                }
            }else{
                throw new IllegalArgumentException("Productid not found for update product!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addCategory(String categoryName) {
        try {
            Productcategory category = new Productcategory();
            category.setCategoryname(categoryName);
            em.persist(category);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<Productcategory> getAllProductcategorys() {
        try {
            Collection<Productcategory> allCategory = em.createNamedQuery("Productcategory.findAll").getResultList();
            return allCategory;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCategory(int categoryid) {
        try {
            Productcategory category = em.find(Productcategory.class, categoryid);
            em.remove(category);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateCategory(int categoryid,String categoryName) {
        try{
            Productcategory category = em.find(Productcategory.class,categoryid);
            
            if(category == null){
                throw new IllegalArgumentException("Category id not found!!!");
            }else{
                category.setCategoryname(categoryName);
                em.merge(category);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public Collection<Contactus> getAllContactuses() {
        try {
            Collection<Contactus> queries = em.createNamedQuery("Contactus.findAll").getResultList();
            return queries;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void updatePaymentStatus(int paymentId, String newStatus) {
        try {
            Payment payment = em.find(Payment.class, paymentId);

            if (payment != null) {
                payment.setPaymentStatus(newStatus);
                em.merge(payment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<Ordermaster> viewAllOrders() {
        try{
            Collection<Ordermaster> AllOrders = em.createNamedQuery("Ordermaster.findAll").getResultList();
            return AllOrders;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateOrderStatus(int orderid, String status) {
        try{
            Ordermaster order = em.find(Ordermaster.class, orderid);
            if(order == null){
                throw new IllegalArgumentException("Order id not found!!!");
            }else{
                order.setStatus(status);
                em.merge(order);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public String getOrderStatus(int orderId) {
        try{
            Ordermaster status = em.find(Ordermaster.class, orderId);
            return status.getStatus();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    

    @Override
    public Collection<Payment> getAllPayments() {
        try{
            Collection<Payment> allpayments = em.createNamedQuery("Payment.findAll").getResultList();
            return allpayments;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
    
}
