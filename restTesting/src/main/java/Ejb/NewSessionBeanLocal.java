/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import Entity.Emp;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author kewal dungarwal
 */
@Local
public interface NewSessionBeanLocal {
   void Insert(String name,String address);
    Collection<Emp> getEmp();
    boolean delete(Integer id);
    boolean update(String name,String address, Integer id);
    Emp getEmpById(Integer id);
    Collection<Emp> getEmpByName(String name);
    boolean InsertEmp(String name, String address);
}
