package CDIBaan;

import Client.addressClient;
import Entity.Address;
import Entity.Customer;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Named(value = "addressBean")
@RequestScoped
public class AddressBean {

    Response rs;
    addressClient ad;
    Collection<Customer> customer;
    GenericType<Collection<Customer>> gcustomer;
    Collection<Address> address;
    GenericType<Collection<Address>> gaddress;
    Address adrs = new Address();
    Customer cus = new Customer();
    private String customer_name;
    private String city, state, aid;
    private int cid;

    public AddressBean() {
        ad = new addressClient();
        customer = new ArrayList<>();
        gcustomer = new GenericType<Collection<Customer>>() {
        };
        address = new ArrayList<>();
        gaddress = new GenericType<Collection<Address>>() {
        };
    }

    public Collection<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Collection<Customer> customer) {
        this.customer = customer;
    }

    public Collection<Address> getAddress() {
        rs = ad.getaddress(Response.class);
        address = rs.readEntity(gaddress);
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }

    public Address getAdrs() {
        return adrs;
    }

    public void setAdrs(Address adrs) {
        this.adrs = adrs;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public void emptyVariable() {
        this.city = "";
        this.state = "";
        this.aid = "";
    }

    public Collection<Customer> getAllCustomers() {
        rs = ad.getCustomer(Response.class);
        customer = rs.readEntity(gcustomer);
        return customer;
    }

    public String insertAdd(Integer cid) {
        this.adrs.setCity(city);
        this.adrs.setState(state);
        String cids = cid.toString();
        ad.insertAddress(this.adrs, cids);
        this.emptyVariable();
        return "Address.xhtml";
    }

    public String Deleteaddress(String aid, String cid) {
        ad.deleteAddress(aid, cid);
        return "Address.xhtml";
    }

    public String getById(String aid) {
        rs = ad.getAddById(Response.class, aid);
        GenericType<Address> add = new GenericType<Address>() {
        };
        Address adrss = rs.readEntity(add);
        aid = adrss.getAid().toString();
        city = adrss.getCity();
        state = adrss.getState();
        cus = adrss.getCid();
        this.adrs.setAid(Integer.parseInt(aid));
        this.adrs.setCity(city);
        this.adrs.setState(state);
        this.adrs.setCid(cus);
        return "Update.xhtml";

    }

    public String Update(Integer aid, Integer cid, String city, String state) {
        String aids = aid.toString();
        String cids = cid.toString();
        this.adrs.setCity(city);
        this.adrs.setState(state);
        this.adrs.setAid(aid);
        cus.setCid(cid);
        this.adrs.setCid(cus);
        System.out.println(this.adrs.getCid());

        ad.updateAddress(this.adrs, aids, cids);
        return "Address.xhtml";

    }
}
