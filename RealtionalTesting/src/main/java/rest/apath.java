package rest;

import Ejbs.NewSessionBeanLocal;
import Entity.Address;
import Entity.Customer;
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
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("apath")
@RequestScoped
public class apath {

    @EJB
    NewSessionBeanLocal obj;
    @Context
    private UriInfo context;

    public apath() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String Hello() {
        return "<h1>Kya Bolti Public</h1>";
    }

    @GET
    @Path("getAddress")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Address> getaddress(){
        return obj.getAddress();
    }
    
    @GET
    @Path("getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getCustomer(){
        return obj.getCustomer();
    }

    @POST
    @Path("/InsertAdd/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertAddress(@PathParam("cid") Integer cid, Address ad) {
        if (obj.InsertCust(ad.getCity(), ad.getState(), cid)) {
            String message = "Addresss added";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("/deleteAdd/{id}/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAddress(@PathParam("id") int id, @PathParam("cid") int cid) {
        if (obj.deleteAdd(id, cid)) {
            String message = "Addresss deleted";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("/updateAddress/{id}/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAddress(@PathParam("id") int id, @PathParam("cid") int cid, Address ad) {
        if (obj.updateAdd(id, ad.getCity(), ad.getState(), cid)) {
            String message = "Addresss udpated";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }

      
    @GET
    @Path("getAddById/{aid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address getAddById(@PathParam("aid") int aid){
        return obj.getAddressById(aid);    }
}
