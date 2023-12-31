/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import Ejb.UploadLocal;
import Entity.Person;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("ipath")
@RequestScoped
public class ipath {

    @EJB UploadLocal up;
    @Context
    private UriInfo context;

    public ipath() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello(){
        return "<h1>Hello From Upload</h1>";
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person){
            if (up.addPhoto(person.getPname(), person.getPimage())) {
                 String message = "Person added";
            return Response.status(Response.Status.OK).entity(message).build();
        }
            else{
                return Response.notModified().build();
            }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getallperson(){
        return up.getall();
    }
}
