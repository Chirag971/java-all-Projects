/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Dell
 */
@DeclareRoles({"Admin", "User"})
@Stateless
public class SecureBean {

    @RolesAllowed("Admin")
//@PermitAll  
    //@DenyAll   
    public String saySecureHello() {
        return "Secure Hello from Secure Bean";
    }

}
