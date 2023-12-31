/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Address;
import java.util.Collection;
import java.util.Collections;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface NewSessionBeanLocal {

    Collection<Address> getAddress();

    boolean addAddress(String city, String state, Integer cid);

    boolean deleteAdd(Integer aid, Integer cid);

    boolean upAdd(Integer aid, String city, String state, Integer cid);
}
