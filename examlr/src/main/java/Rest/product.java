/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import JPA.Category;
import JPA.Product;
import ejb.productLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("product")
@RequestScoped
public class product {

    @Context
    private UriInfo context;

    @EJB
    productLocal ejb;

    public product() {
    }

    @GET
    @Path("getcategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategory() {
        return ejb.getallcat();
    }

    @POST
    @Path("AddCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category cat) {
        ejb.addcategory(cat.getCname());
    }

    @DELETE
    @Path("DeleteCat/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCat(@PathParam("cid") Integer cid) {
        ejb.delete(cid);
    }

    @PUT
    @Path("UpdateCat/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCat(@PathParam("cid") Integer cid, Category cat) {
        ejb.updatecat(cid, cat.getCname());
    }

    @GET
    @Path("getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAllProduct() {
        return ejb.getallproduct();
    }

    @POST
    @Path("AddProduct/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(@PathParam("cid") Integer cid, Product p) {
        ejb.addproduct(p.getPname(), p.getPrice(), cid);
    }

    @DELETE
    @Path("DeletePro/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePro(@PathParam("pid") Integer pid) {
        ejb.deletepro(pid);
    }

    @PUT
    @Path("UpdatePro/{pid}/{cid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePro(@PathParam("cid") Integer cid, @PathParam("pid") Integer pid, Product p) {
        ejb.updatepro(pid, p.getPname(), p.getPrice(), cid);
    }

    @GET
    @Path("getByCid/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getByCid(@PathParam("cid") Integer cid) {
        return ejb.getByid(cid);
    }

    @GET
    @Path("getByPid/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getByPid(@PathParam("pid") Integer pid) {
        return ejb.getBypid(pid);
    }

}
