/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejbs;

import Entity.Address;
import Entity.Customer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jdk.jfr.internal.Cutoff;

/**
 *
 * @author Dell
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext(unitName = "crudupu")
    EntityManager em;

    @Override
    public Collection<Address> getAddress() {
        Collection<Address> ad = em.createNamedQuery("Address.findAll").getResultList();
        return ad;
    }

    @Override
    public boolean InsertCust(String city, String state, Integer cid) {
        Address ad = new Address();
        Customer c = em.find(Customer.class, cid);
        Collection<Address> address = c.getAddressCollection();
        ad.setCity(city);
        ad.setState(state);
        ad.setCid(c);
        address.add(ad);
        c.setAddressCollection(address);
        em.persist(ad);
        em.merge(c);
        return true;
    }

    @Override
    public boolean deleteAdd(int id, int cid) {
        Address ad = em.find(Address.class, id);
        Customer c = em.find(Customer.class, cid);
        Collection<Address> address = c.getAddressCollection();
        if (address.contains(ad)) {
            em.remove(ad);
        }
        return true;

    }

    @Override
    public boolean updateAdd(int id,String city, String state,int cid) {
        try {
            Address ad = em.find(Address.class, id);
            Customer c = em.find(Customer.class, cid);
            Collection<Address> address = c.getAddressCollection();
            if (address.contains(ad)) {
                ad.setCity(city);
                ad.setState(state);
                Address mergeAd = em.merge(ad);
                if (mergeAd != null) {
                    System.out.println("Successfully merged");
                    return true;
                } else {
                    System.out.println("failure");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
//            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Collection<Customer> getCustomer() {
        Collection<Customer> c = em.createNamedQuery("Customer.findAll").getResultList();
        return c;
    }

    @Override
    public Address getAddressById(int aid) {
        Address ad = em.find(Address.class, aid);
        return ad;
    }

}
