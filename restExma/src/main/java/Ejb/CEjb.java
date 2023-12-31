/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

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
public class CEjb implements CEjbLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public boolean addCus(String name) {
        Customer cs = new Customer();
        cs.setCustomerName(name);
        em.persist(cs);
        return true;

    }

    @Override
    public Collection<Customer> getall() {
        Collection<Customer> cus = em.createNamedQuery("Customer.findAll").getResultList();
        return cus;
    }

    @Override
    public boolean deletecus(Integer id) {
        Customer cus = em.find(Customer.class, id);
        em.remove(cus);
        return true;
    }

    @Override
    public boolean updateCus(Integer id, String name) {
        Customer cus = em.find(Customer.class, id);
        cus.setCustomerName(name);
        em.merge(cus);
        return true;

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
