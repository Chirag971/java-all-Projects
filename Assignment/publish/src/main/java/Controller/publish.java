/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Bean.CustomerFacade;
import Entities.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author Admin
 */
@Named(value = "publish")
@SessionScoped
public class publish implements Serializable {

    @EJB
    private CustomerFacade customerFacade;
    private Customer selectedCustomer;
    private Customer customer = new Customer();

    private String firstName;
    private String lastName;

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public publish() {
    }

    public Collection<Customer> findAll() {
        return this.customerFacade.findAll();
    }

//    public Collection<Customer> getByFirstName(String firsName){
//
//
//    }
    public String addCustomer() {
        this.customer.setFirstName(firstName);
        this.customer.setLastName(lastName);
        this.customerFacade.create(customer);
        return "index.xhtml?faces-redirect=true";
    }

    public String DeleteCustomer(Customer customer) {
        this.customerFacade.remove(customer);
        return "index.xhtml?faces-redirect=true";
    }

    public String getUpdateCust(Customer customer) {
        this.customer = customer;
        return "updateCust";
    }

    public String updateCust() {
//         this.userFacade.edit(user);
//         this.user = user ;
        this.customerFacade.edit(customer);
        this.customer = customer;
        return "index.xhtml?faces-redirect=true";
    }

}
