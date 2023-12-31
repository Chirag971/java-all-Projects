/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Bean;

import Entities.Address;
import Entities.Customer;
import Entities.Subscription;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface PublishBeanLocal {

//  =========================================  for Customer ===============================================
    void addCustomer(String firstName, String lastName);

    void updateCustomer(String firstName, String lastName, Integer cId);

    void deleteCustomer(Integer cId);

    Collection<Customer> getAllCustomer();

    Collection<Customer> getCustomerByfirstName(String firstName);

    Collection<Customer> getCustomerBylastName(String lastName);

    Customer findCustomerById(Integer cId);

//  ===========================================for Address ================================================     
    void addAddressToCustomer(String street, String city, String state, String zip, Integer cId);

    void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid);

    void removeAddressToCustomer(Integer aid, Integer cid);

    Collection<Address> getAddressesofCustomer(Integer cid);

    Collection<Address> getAddressesByCity(String city);

    Collection<Address> getAddressesByStreet(String street);

    Collection<Address> getAddressesByState(String state);

    Collection<Address> getAddressesByZip(String zip);

    Address findAddressById(Integer aId);

//   ========================================== subscription  ===============================================
    void addSubscription(String title, String type);

    void updateSubscription(Integer SubscriptionId, String title, String type);

    void removeSubscription(Integer SubscriptionId);

    Collection<Subscription> getAllSubscription();

    Collection<Subscription> getSubscriptionByType(String type);

    Collection<Subscription> getAllSubscriptionsOfCustomer(Integer cid);

    Subscription findSubsById(Integer SubscriptionId);

    void addSubscriptionsToCustomer(int cid, Collection<Integer> sids);

    void removeSubscriptionsToCustomer(int cid, Collection<Integer> sids);
}
