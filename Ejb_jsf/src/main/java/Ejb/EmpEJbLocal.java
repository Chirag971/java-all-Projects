/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Employee;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface EmpEJbLocal {
    void insert(String name,String role);
    void delete(Integer empId);
    void update(Integer empId,String name,String role);
    Collection<Employee> getAllEmp();
    Employee getByid(int empId);
    
    
}
