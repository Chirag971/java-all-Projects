/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Customer;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface CEjbLocal {
    boolean addCus(String name);
    Collection<Customer> getall();
    boolean deletecus(Integer id);
    boolean updateCus(Integer id,String name);
}
