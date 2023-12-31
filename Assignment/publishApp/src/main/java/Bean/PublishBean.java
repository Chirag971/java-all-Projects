/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Bean;

import Entities.Address;
import Entities.Customer;
import Entities.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PublishBean implements PublishBeanLocal {

    @PersistenceContext(unitName = "publishpu")
    EntityManager em;

    @Override
    public void addCustomer(String firstName, String lastName) {
        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        em.persist(c);

    }

    @Override
    public void updateCustomer(String firstName, String lastName, Integer cId) {
        Customer c = em.find(Customer.class, cId);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        em.merge(c);
    }

    @Override
    public void deleteCustomer(Integer cId) {
        Customer c = em.find(Customer.class, cId);
        em.remove(c);
    }

    @Override
    public Collection<Customer> getAllCustomer() {
        Collection<Customer> customers = em.createNamedQuery("Customer.findAll").getResultList();
        return customers;
    }

    @Override
    public Collection<Customer> getCustomerByfirstName(String firstName) {
        Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName").setParameter("firstName", firstName).getResultList();
        return customers;
    }

    @Override
    public Collection<Customer> getCustomerBylastName(String lastName) {
        Collection<Customer> customers = em.createNamedQuery("Customer.findByLastName").setParameter("lastName", lastName).getResultList();
        return customers;

    }

    @Override
    public Customer findCustomerById(Integer cId) {
        Customer c = (Customer) em.find(Customer.class, cId);
        return c;
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer cId) {
        Customer c = (Customer) em.find(Customer.class, cId);
        Collection<Address> addresses = c.getAddressCollection();

        Address a = new Address();
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);
        a.setCustomerId(c);

        addresses.add(a);
        c.setAddressCollection(addresses);

        em.persist(a);
        em.merge(c);

    }

    @Override
    public void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid) {
        Address addressUpdate = em.find(Address.class, aid);
        Customer c = em.find(Customer.class, cid);
        if (addressUpdate != null) {
            addressUpdate.setStreet(street);
            addressUpdate.setCity(city);
            addressUpdate.setState(state);
            addressUpdate.setZip(zip);
            addressUpdate.setCustomerId(c);
        }

        em.merge(addressUpdate);

    }

    @Override
    public void removeAddressToCustomer(Integer aid, Integer cid) {
        Customer c = (Customer) em.find(Customer.class, cid);
        Address a = (Address) em.find(Address.class, aid);

        Collection<Address> addresses = c.getAddressCollection();
        if (addresses.contains(a)) {
            addresses.remove(a);
            c.setAddressCollection(addresses);
            em.remove(a);
        }
    }

    @Override
    public Collection<Address> getAddressesofCustomer(Integer cid) {
        Customer c = (Customer) em.find(Customer.class, cid);
        return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        Collection<Address> address = em.createNamedQuery("Address.findByCity").setParameter("city", city).getResultList();
        return address;
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        Collection<Address> address = em.createNamedQuery("Address.findByState").setParameter("state", state).getResultList();
        return address;
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        Collection<Address> address = em.createNamedQuery("Address.findByZip").setParameter("zip", zip).getResultList();
        return address;
    }

    @Override
    public Address findAddressById(Integer aId) {
        Address a = (Address) em.find(Address.class, aId);
        return a;
    }

    @Override
    public Collection<Address> getAddressesByStreet(String street) {
        Collection<Address> address = em.createNamedQuery("Address.findByStreet").setParameter("street", street).getResultList();
        return address;
    }

    @Override
    public void addSubscription(String title, String type) {
        Subscription sub = new Subscription();
        sub.setTitle(title);
        sub.setType(type);
        em.persist(sub);
    }

    @Override
    public void updateSubscription(Integer SubscriptionId, String title, String type) {
        Subscription s = em.find(Subscription.class, SubscriptionId);
        s.setTitle(title);
        s.setType(type);
        em.merge(s);
    }

    @Override
    public void removeSubscription(Integer SubscriptionId) {
        Subscription s = em.find(Subscription.class, SubscriptionId);
        em.remove(s);
    }

    @Override
    public Collection<Subscription> getAllSubscription() {
        Collection<Subscription> subs = em.createNamedQuery("Subscription.findAll").getResultList();
        return subs;
    }

    @Override
    public Collection<Subscription> getSubscriptionByType(String type) {
        Collection<Subscription> subs = em.createNamedQuery("Subscription.findByType").setParameter("type", type).getResultList();
        return subs;
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsOfCustomer(Integer cid) {
        Customer c = (Customer) em.find(Customer.class, cid);
        return c.getSubscriptionCollection();
    }

    @Override
    public void addSubscriptionsToCustomer(int cid, Collection<Integer> sids) {
        Customer c = (Customer) em.find(Customer.class, cid);
        Collection<Subscription> subs = c.getSubscriptionCollection();

        for (Integer sid : sids) {

            Subscription s = (Subscription) em.find(Subscription.class, sid);

            if (!subs.contains(s)) {
                Collection<Customer> customers = s.getCustomerCollection();
                customers.add(c);
                subs.add(s);

                c.setSubscriptionCollection(subs);
                s.setCustomerCollection(customers);

                em.merge(s);

            }
        }
    }

    @Override
    public void removeSubscriptionsToCustomer(int cid, Collection<Integer> sids) {
        Customer c = (Customer) em.find(Customer.class, cid);
        Collection<Subscription> subs = c.getSubscriptionCollection();

        for (Integer sid : sids) {

            Subscription s = (Subscription) em.find(Subscription.class, sid);

            if (subs.contains(s)) {
                Collection<Customer> customers = s.getCustomerCollection();
                customers.remove(c);
                subs.remove(s);

                c.setSubscriptionCollection(subs);
                s.setCustomerCollection(customers);

                em.merge(s);

            }
        }

    }

    @Override
    public Subscription findSubsById(Integer SubscriptionId) {
      Subscription s = (Subscription) em.find(Subscription.class, SubscriptionId);
      return s ;
    }

}
