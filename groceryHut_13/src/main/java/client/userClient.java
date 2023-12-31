/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:user [user]<br>
 * USAGE:
 * <pre>
 *        userClient client = new userClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class userClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/groceryHut_13/resources";

    public userClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("user");
    }

    public Response resetPassword(Object requestEntity, String regId, String username) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("resetpass/{0}/{1}", new Object[]{regId, username})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getPaymentsByUser(Class<T> responseType, String regId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPaymentsByUser/{0}", new Object[]{regId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAddresses(Class<T> responseType, String regId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAddresses/{0}", new Object[]{regId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateAddresses(Object requestEntity, String addId, String regId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateAddress/{0}/{1}", new Object[]{addId, regId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response addGit(Object requestEntity, String regId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addgit/{0}", new Object[]{regId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response placeOrder(String regId, String addId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("PlaceOrder/{0}/{1}", new Object[]{regId, addId})).request().post(null, Response.class);
    }

    public <T> T getOrderById(Class<T> responseType, String regId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getOrderById/{0}", new Object[]{regId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReview(Class<T> responseType, String pId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReview/{0}", new Object[]{pId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateUser(Object requestEntity, String regId, String username) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("update/{0}/{1}", new Object[]{regId, username})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getQueriesByUser(Class<T> responseType, String regId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getByUser/{0}", new Object[]{regId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response addAddresses(Object requestEntity, String regId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addAddress/{0}", new Object[]{regId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getProductById(Class<T> responseType, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductById/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProducts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllProducts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductByCat(Class<T> responseType, String catId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductByCat/{0}", new Object[]{catId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response registerUsermaster(Object requestEntity, String username) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("register/{0}", new Object[]{username})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response deleteAddresses(String addId, String regId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteAddress/{0}/{1}", new Object[]{addId, regId})).request().delete(Response.class);
    }

    public Response removeCart(String regId, String pId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteCart/{0}/{1}", new Object[]{regId, pId})).request().delete(Response.class);
    }

    public Response addToCart(String regId, String pId, String qunatity) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}/{2}", new Object[]{regId, pId, qunatity})).request().post(null, Response.class);
    }

    public <T> T viewCart(Class<T> responseType, String regId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("viewCart/{0}", new Object[]{regId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response addPayment(Object requestEntity, String oId, String regId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addPayment/{0}/{1}", new Object[]{oId, regId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response addReview(Object requestEntity, String regId, String pId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addReview/{0}/{1}", new Object[]{regId, pId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public void close() {
        client.close();
    }
    
}
