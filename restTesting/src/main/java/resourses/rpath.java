
package resourses;

import Ejb.NewSessionBeanLocal;
import Entity.Emp;
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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kewal dungarwal
 */
@Path("rpath")
@RequestScoped
public class rpath {

    @Context
    private UriInfo context;

    public rpath() {
    }

    @EJB
    NewSessionBeanLocal obj;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String HellString() {
        return "<h3>Hello World of Rest</h3>";
    }

    @GET
    @Path("/getEmp")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Emp> getEmp() {
        return obj.getEmp();
    }

    @POST
    @Path("/Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void InsertEmp(Emp employee) {
//        System.out.println(employee.getName());
//        System.out.println(employee.getAddress());
        obj.Insert(employee.getName(), employee.getAddress());
    }

    @DELETE
    @Path("/Delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {

        if (obj.delete(id)) {
            String message = "Employee " + id + " is removed";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("/Update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Emp employee) {
//        Emp UpdateEmp = obj.update(name, address, id);
        if (obj.update(employee.getName(), employee.getAddress(), id)) {
            String message = "Employee " + id + " is Updated";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }

    @GET
    @Path("/getID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Emp getUserByID(@PathParam("id") Integer id) {
        return obj.getEmpById(id);
    }

    @GET
    @Path("/getbyName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Emp> getEmpByName(@PathParam("name") String name) {
        return obj.getEmpByName(name);
    }

}
