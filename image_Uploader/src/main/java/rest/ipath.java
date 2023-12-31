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
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
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
    public Response addPerson(Person p) {
        if (up.addPhoto(p.getPname(), p.getPimage())) {
            String message = "Person added";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        } // Handle the exception appropriately in a production scenario
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getallperson(){
        return up.getall();
    }
    
    @DELETE
    @Path("del/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(@PathParam("id")Integer id){
        up.deletephoto(id);
        String msg = "deleted";
        return Response.status(Response.Status.CREATED).entity(msg).build();
    }
}
