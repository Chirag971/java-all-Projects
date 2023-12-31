/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

import Entity.Emp;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kewal dungarwal
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext(unitName = "emppu")
    EntityManager em;

    @Override
    public void Insert(String name, String address) {
    Emp emp = new Emp();
    emp.setName(name);
    emp.setAddress(address);
    em.persist(emp);
    
    }

    @Override
    public Collection<Emp> getEmp() {
       
        Collection<Emp> emp = em.createNamedQuery("Emp.findAll").getResultList();
        return emp;
    }

    @Override
    public boolean delete(Integer id) {
         
        Emp e = em.find(Emp.class, id);
         em.remove(e);
        return true; 
    }

    @Override
    public boolean update(String name, String address, Integer id) {
      Emp e = em.find(Emp.class, id);
      e.setName(name);
      e.setAddress(address);
      em.merge(e);
      return true;
    }

    @Override
    public Emp getEmpById(Integer id) {
         Emp e = em.find(Emp.class, id);
         return e;
    }

    @Override
    public Collection<Emp> getEmpByName(String name) {
      Collection<Emp> emp = em.createNamedQuery("Emp.findByName").setParameter("name", name).getResultList();
      return emp;
    }

    @Override
    public boolean InsertEmp(String name, String address) {
        Emp ems = new Emp();
        ems.setName(name);
        ems.setAddress(address);
        em.persist(ems);
        return true;
    }

  
}
