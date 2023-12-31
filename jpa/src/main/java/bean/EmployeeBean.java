/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import web.Employee;

/**
 *
 * @author Admin
 */
@Stateless
public class EmployeeBean implements EmployeeBeanLocal {
@PersistenceContext(unitName = "persistence")
EntityManager em;
    @Override
    public Collection<Employee> getEmployees() {
        Collection<Employee> emp = em.createNamedQuery("Employee.findAll").getResultList();
        return emp;
    }

    
}
