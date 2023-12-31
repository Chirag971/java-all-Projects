    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Beans;

import Client.EmpClient;
import Entity.Emp;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
@Named(value = "empBean")
@RequestScoped
public class EmpBean {

    EmpClient el;
    Response rs;
    String EmpName;
    String address;
    String id;
    Collection<Emp> emp;
    GenericType<Collection<Emp>> gemp;

    private Emp emps = new Emp();

    public EmpBean() {
        el = new EmpClient();
        emp = new ArrayList<>();
        gemp = new GenericType<Collection<Emp>>() {
        };
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Emp getEmps() {
        return emps;
    }

    public void setEmps(Emp emps) {
        this.emps = emps;
    }

    public void setEmp(Collection<Emp> emp) {
        this.emp = emp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Emp> getEmp() {
        rs = el.getEmp(Response.class);
        emp = rs.readEntity(gemp);
        return emp;
    }

    public String insert() {
        this.emps.setName(EmpName);
        this.emps.setAddress(address);
        el.InsertEmp(this.emps);
        return "EmpBook.xhtml";
    }

    public String delete(String id) {
        el.delete(id);
        return "EmpBook.xhtml";
    }

    public String getById(String id) {
        rs = el.getUserByID(Response.class, id);
        GenericType<Emp> emp = new GenericType<Emp>() {
        };
        Emp ec = rs.readEntity(emp);
        id = ec.getId().toString();
        EmpName = ec.getName();
        address = ec.getAddress();
        this.emps.setName(EmpName);
        this.emps.setAddress(address);
        this.emps.setId(Integer.parseInt(id));
//        System.out.println(id);
        return "Update.xhtml";
    }

    public String Update(Integer id, String EmpName, String address) {
        String ids = id.toString();
        this.emps.setName(EmpName);
        this.emps.setAddress(address);
        this.emps.setId(id);
        el.update(this.emps, ids);

        return "EmpBook.xhtml";
    }

}
