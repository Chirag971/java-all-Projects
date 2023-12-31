/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

import Entity.Address;
import Entity.Customer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public Collection<Address> getAddress() {
        Collection<Address> ad = em.createNamedQuery("Address.findAll").getResultList();
        return ad;
    }
    
    @Override
    public boolean addAddress(String city, String state, Integer cid) {
        Customer cus = em.find(Customer.class, cid);
        Collection<Address> addresses = cus.getAddressCollection();
        Address ad = new Address();
        ad.setCity(city);
        ad.setState(state);
        ad.setCid(cus);
        addresses.add(ad);
        cus.setAddressCollection(addresses);
        em.persist(ad);
        em.merge(cus);
        return true;
        
    }
    
    @Override
    public boolean deleteAdd(Integer aid, Integer cid) {
        Address ad = em.find(Address.class, aid);
        Customer cus = em.find(Customer.class, cid);
        Collection<Address> addresses = cus.getAddressCollection();
        
        if (addresses.contains(ad)) {
            em.remove(ad);
        }
        return true;
    }
    
    @Override
    public boolean upAdd(Integer aid, String city, String state, Integer cid) {
        Address ad = em.find(Address.class, aid);
        Customer cus = em.find(Customer.class, cid);
        Collection<Address> addresses = cus.getAddressCollection();
        
        if (addresses.contains(ad)) {
            ad.setCity(city);
            ad.setState(state);
            em.merge(ad);
        }
        return true;
    }
}

// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

