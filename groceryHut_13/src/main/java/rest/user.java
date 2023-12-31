/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import Ejb.AdminLocal;
import Ejb.UserLocal;
import Entity.Addressmaster;
import Entity.Cart;
import Entity.Getintouch;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productreview;
import Entity.Registermaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("user")
@RequestScoped
public class user {

    @Context
    private UriInfo context;

    @EJB
    UserLocal ejb;

    public user() {
    }

    @POST
    @Path("/register/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUsermaster(@PathParam("username") String username, Registermaster request) {
        try {
            boolean registrationResult = ejb.Register(request.getName(), request.getEmail(), request.getPassword(), username);

            if (registrationResult) {
                String msg = "User registration successful";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("User registration failed").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Internal server error").build();
        }
    }

    @PUT
    @Path("/update/{regId}/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("regId") Integer regId, @PathParam("username") String username, Registermaster up) {

        boolean success = ejb.Update(
                regId,
                up.getName(),
                up.getEmail(),
                username
        );

        if (success) {
            String msg = "User updated successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @POST
    @Path("/resetpass/{regId}/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetPassword(@PathParam("regId") Integer regId, @PathParam("username") String username, Registermaster reg) {

        if (ejb.resetpass(regId, username, reg.getPassword())) {
            String msg = "Password reset successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("addReview/{regId}/{pId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReview(@PathParam("regId") Integer regId, @PathParam("pId") Integer pId, Productreview request) {
        try {
            boolean result = ejb.inReview(request.getReview(), regId, pId);
            if (result) {
                String msg = "Review added successfully";
                return Response.status(Response.Status.OK).entity(msg).build();
            } else {
                return Response.notModified().build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("getReview/{pId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productreview> getReview(@PathParam("pId") Integer pId) {
        return ejb.getByPid(pId);

    }

    @GET
    @Path("getAllProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Manageproduct> getAllProducts() {
        return ejb.getallProduct();
    }

    @GET
    @Path("getProductById/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("pid") Integer pid) {
        Manageproduct product = ejb.getById(pid);
        if (product != null) {
            return Response.status(Response.Status.OK).entity(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("getProductByCat/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Manageproduct> getProductByCat(@PathParam("catId") Integer catId) {
        return ejb.getallProductByCat(catId);
    }

    @POST
    @Path("addPayment/{oId}/{regId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPayment(@PathParam("oId") Integer oId, @PathParam("regId") Integer regId, Payment pay) {
        boolean result = ejb.addPayment(oId, regId, pay.getPaymentMode(), pay.getUpiId(), pay.getAmt());

        if (result) {
            String msg = "Payment added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().entity("Failed to add payment").build();
        }
    }

    @GET
    @Path("getPaymentsByUser/{regId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentsByUser(@PathParam("regId") Integer regId) {
        Collection<Payment> payments = ejb.getPayByUser(regId);
        return Response.ok(payments).build();
    }

    @POST
    @Path("addgit/{regId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGit(@PathParam("regId") Integer regId, Getintouch request) {
        if (ejb.addgit(regId, request.getQuery())) {
            String msg = "Query added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().entity("Failed to add query").build();
        }
    }

    @GET
    @Path("getByUser/{regId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQueriesByUser(@PathParam("regId") Integer regId) {
        return Response.ok(ejb.getgitByUser(regId)).build();
    }

    @POST
    @Path("addAddress/{regId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAddresses(@PathParam("regId") Integer regId, Addressmaster address) {
        boolean result = ejb.inAddress(address.getPhoneNo(), address.getAtlPhoneNo(), address.getAddress(), address.getAltAddress(), regId);
        if (result) {
            String msg = "Address added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("deleteAddress/{addId}/{regId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAddresses(@PathParam("addId") Integer addId, @PathParam("regId") Integer regId) {
        boolean result = ejb.delAddress(addId, regId);
        if (result) {
            String msg = "Address deleted successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("updateAddress/{addId}/{regId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAddresses(@PathParam("addId") Integer addId, @PathParam("regId") Integer regId, Addressmaster updateRequest) {
        boolean result = ejb.upAddress(
                addId,
                updateRequest.getPhoneNo(),
                updateRequest.getAtlPhoneNo(),
                updateRequest.getAddress(),
                updateRequest.getAltAddress(),
                regId
        );
        if (result) {
            String msg = "Address updated successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("getAddresses/{regId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddresses(@PathParam("regId") Integer regId) {
        Collection<Addressmaster> addresses = ejb.getByUid(regId);
        return Response.ok(addresses).build();
    }

    @POST
    @Path("addToCart/{regId}/{pId}/{qunatity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(@PathParam("regId") Integer regId, @PathParam("pId") Integer pId, @PathParam("qunatity") Integer qunatity) {
        boolean result = ejb.addProductToCart(regId, pId, qunatity);
        if (result) {
            String msg = "Cart Added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("deleteCart/{regId}/{pId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCart(@PathParam("regId") Integer regId, @PathParam("pId") Integer pId) {
        boolean result = ejb.removeProductFromCart(regId, pId);
        if (result) {
            String msg = "product Remove successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("viewCart/{regId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cart> viewCart(@PathParam("regId") Integer regId) {
        return ejb.viewCart(regId);
    }

    @POST
    @Path("PlaceOrder/{regId}/{addId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(@PathParam("regId") Integer regId,@PathParam("addId") Integer addId) {
        boolean result = ejb.placeOrder(regId,addId);
        if (result) {
            String msg = "Order Place successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("getOrderById/{regId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdeatails> getOrderById(@PathParam("regId") Integer regId) {
        return ejb.getOrderDetailsById(regId);
    }
}
