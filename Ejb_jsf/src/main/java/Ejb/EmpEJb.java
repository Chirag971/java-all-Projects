/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

import Entity.Employee;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class EmpEJb implements EmpEJbLocal {

    @PersistenceContext(unitName = "emppu")
    EntityManager em;

    @Override
    public void insert(String name, String role) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setRole(role);
        em.persist(emp);

    }

    @Override
    public void delete(Integer empId) {
        Employee emp = em.find(Employee.class, empId);
        em.remove(emp);
    }

    @Override
    public void update(Integer empId, String name, String role) {
        Employee emp = em.find(Employee.class, empId);
        emp.setName(name);
        emp.setRole(role);
        em.merge(emp);
    }

    @Override
    public Collection<Employee> getAllEmp() {
        Collection<Employee> emp = em.createNamedQuery("Employee.findAll").getResultList();
        return emp;
    }

    @Override
    public Employee getByid(int empId) {
        Employee emp = em.find(Employee.class, empId);
        return emp;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
