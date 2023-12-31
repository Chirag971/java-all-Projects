/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.SecureBean;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@DeclareRoles("Admin")  
@Path("secure")
@RequestScoped
public class SecureResource {

    @EJB
    SecureBean sb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SecureResource
     */
    public SecureResource() {
    }

    /**
     * Retrieves representation of an instance of rest.SecureResource
     *
     * @return an instance of java.lang.String
     */
    @RolesAllowed({"Admin"})
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        
        return sb.saySecureHello() + " from Rest Client";
    }

}
