/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejbs;

import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface HashBeanLocal {
    void Register(String username,String Password,String gname);
}
