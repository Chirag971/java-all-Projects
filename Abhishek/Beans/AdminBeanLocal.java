/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import Entity.Contactus;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productcategory;
import Entity.Products;
import Entity.Userregister;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface AdminBeanLocal {
    
    //---------------------------------Get All Details--------------------------------
    public Collection<Userregister> getAllUserRegister();
    
    //--------------------------------For Products-----------------------------------
    public void addProduct(String productName,Double price,int quntity,Double tax,Double gst,int categoryid,String description, String image);
    
    public void deleteProduct(int productid);
    
    public void updateProduct(int productid,String productName,Double price,int quantity,Double tax,Double gst,int categoryid,String discription,String image);
    
    public Collection<Products> getAllProducts();
    
    //-------------------------------For Category------------------------------------
    public void addCategory(String categoryName);
    public Collection<Productcategory> getAllProductcategorys();
    public void deleteCategory(int categoryid);
    public void updateCategory(int categoryid,String categoryName);
    
    //-------------------------------Get All Query-----------------------------------
    public Collection<Contactus> getAllContactuses();
    
    //--------------------------------For Payment----------------------------------
    public void updatePaymentStatus(int paymentId, String newStatus);
    public Collection<Payment> getAllPayments();
    
    public Collection<Ordermaster> viewAllOrders();
    public void updateOrderStatus(int orderid,String status);
    public String getOrderStatus(int orderId);
}
