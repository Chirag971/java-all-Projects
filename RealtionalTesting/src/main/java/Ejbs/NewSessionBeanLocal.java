/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejbs;

import Entity.Address;
import Entity.Customer;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface NewSessionBeanLocal {

    Collection<Address> getAddress();

    Collection<Customer> getCustomer();

    boolean InsertCust(String city, String state, Integer cid);

    boolean deleteAdd(int id, int cid);

    boolean updateAdd(int id,String city, String state,int cid);

    Address getAddressById(int aid);
}
