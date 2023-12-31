package rest;

import Ejb.AdminLocal;
import Entity.Getintouch;
import Entity.Managebrand;
import Entity.Managecategory;
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

@Path("admin")
@RequestScoped
public class admin {

    @EJB
    AdminLocal ejb;
    @Context
    private UriInfo context;

    public admin() {
    }

    @GET
    @Path("getAllReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReviews() {
        Collection<Productreview> reviews = ejb.getallreview();
        return Response.status(Response.Status.OK).entity(reviews).build();
    }

    @GET
    @Path("getAllProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Manageproduct> getAllProducts() {
        return ejb.getallProduct();
    }

    @POST
    @Path("addProduct/{cid}/{bid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("cid") Integer cid, @PathParam("bid") Integer bid, Manageproduct product) {
        if (ejb.inProduct(
                product.getPName(), product.getPImage(), product.getAmmount(),
                product.getDescription(), product.getUnit(), product.getStock(),
                product.getDiscount(), product.getTax(), product.getGst(), product.getSgst(),
                cid, bid)) {

            String msg = "Product added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("deleteProduct/{pid}/{cid}/{bid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("pid") Integer pid,
            @PathParam("cid") Integer cid,
            @PathParam("bid") Integer bid) {
        if (ejb.delProduct(pid, cid, bid)) {
            String msg = "Product deleted successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("updateProduct/{pid}/{cid}/{bid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("pid") Integer pid,
            Manageproduct product,
            @PathParam("cid") Integer cid,
            @PathParam("bid") Integer bid) {
        if (ejb.upProduct(
                pid, product.getPName(),  product.getAmmount(),
                product.getDescription(), product.getUnit(), product.getStock(),
                product.getDiscount(), product.getTax(), product.getGst(), product.getSgst(),
                cid, bid)) {

            String msg = "Product updated successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
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
    @Path("getAllPayments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPayments() {
        Collection<Payment> payments = ejb.getAllPayment();
        return Response.ok(payments).build();
    }

    @GET
    @Path("getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQueries() {
        return Response.ok(ejb.getall()).build();
    }

    @POST
    @Path("resgit/{getId}/{regId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response respondToQuery(@PathParam("getId") Integer getId, @PathParam("regId") Integer regId, Getintouch request) {
        if (ejb.resgit(getId, regId, request.getResponse())) {
            String msg = "Response added successfully";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.serverError().entity("Failed to add response").build();
        }
    }

    @GET
    @Path("/getAllCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Managecategory> getallcategory() {
        return ejb.getallCategory();
    }

    @GET
    @Path("getCById/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Managecategory getbyId(@PathParam("cid") Integer cid) {
        return ejb.getCatByid(cid);
    }

    @POST
    @Path("addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incat(Managecategory cat) {

        System.out.println(cat.getCName());
        if (ejb.addCategoryies(cat.getCName(), cat.getCImage())) {
            String msg = "add Category";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("delcat/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delcat(@PathParam("cid") Integer cid) {
        if (ejb.deleteCategory(cid)) {
            String msg = "delete Category";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("upcat/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upcat(@PathParam("cid") Integer cid, Managecategory cat) {
        if (ejb.UpdateCategory(cid, cat.getCName())) {
            String msg = "update Category";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @GET
    @Path("/getAllBrand")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Managebrand> getallbrand() {
        return ejb.getallBrand();
    }

    @GET
    @Path("getBById/{bid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Managebrand getbrandbyId(@PathParam("bid") Integer bid) {
        return ejb.getBById(bid);
    }

    @POST
    @Path("addBrand")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBrand(Managebrand b) {
        if (ejb.inBrand(b.getBName())) {
            String msg = "add Brand";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("delbrand/{bid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delbrand(@PathParam("bid") Integer bid) {
        if (ejb.delBrand(bid)) {
            String msg = "delete brand";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("upbrand/{bid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upbrand(@PathParam("bid") Integer bid, Managebrand brand) {
        if (ejb.upBrand(bid, brand.getBName())) {
            String msg = "update brand";
            return Response.status(Response.Status.OK).entity(msg).build();
        } else {
            return Response.notModified().build();
        }
    }

    @GET
    @Path("getAllOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdeatails> getAllOrders() {
        return ejb.getAllOrders();
    }
    
    @GET
    @Path("getAllUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Registermaster> getAllUser() {
        return ejb.getallUsers();
    }

}
