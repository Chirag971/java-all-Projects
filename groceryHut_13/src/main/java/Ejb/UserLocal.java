/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Addressmaster;
import Entity.Cart;
import Entity.Getintouch;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productreview;
import Entity.Registermaster;
import java.util.Collection;
import javax.ejb.Local;


@Local
public interface UserLocal {

    boolean Register(String Name, String email, String password, String username);

    Integer getIdByusername(String Username);

    boolean resetpass(Integer regId, String username, String password);

    boolean Update(Integer regId, String Name, String email, String username);

    boolean inReview(String review, Integer regId, Integer pId);

    Collection<Productreview> getByPid(Integer pId);

    Collection<Manageproduct> getallProduct();
    
     Collection<Manageproduct> getallProductByCat(Integer cid);

    Manageproduct getById(Integer pid);

    boolean addPayment(Integer oId, Integer regId, String paymentMode, String upiId, Integer amt);

    Collection<Payment> getPayByUser(Integer regId);

    boolean addgit(Integer regId, String que);

    Collection<Getintouch> getgitByUser(Integer regId);

    boolean inAddress(Integer phoneNo, Integer altPhoneNo, String address, String altAddress, Integer regId);

    boolean delAddress(Integer addId, Integer regId);

    boolean upAddress(Integer addId, Integer phoneNo, Integer altPhoneNo, String address, String altAddress, Integer regId);

    Collection<Addressmaster> getByUid(Integer regId);

    boolean addProductToCart(Integer regId, Integer pId, Integer quantity);

    boolean removeProductFromCart(Integer regId, Integer pId);

    Collection<Cart> viewCart(Integer regId);
    
    boolean placeOrder(Integer regId,Integer addid);
    
    Collection<Orderdeatails> getOrderDetailsById(Integer regId);
    
    
    
    
    

}
