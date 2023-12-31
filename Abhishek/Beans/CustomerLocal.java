/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Beans;

import javax.ejb.Local;

/**
 *
 * @author This PC
 */
@Local
public interface CustomerLocal {
    public void registerCustomer(String email,String username,String password,int gid,int phone,String city,String state,int pincode);
}
