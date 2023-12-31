package Bean;

import Entity.Manageproduct;
import client.adminClient;
import java.util.Collection;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


@Named(value = "collectionCDI")
@RequestScoped
public class CollectionCDI {

    Response rs;
    adminClient ad;
    
   
    GenericType<Collection<Manageproduct>>  gproduct;
    public CollectionCDI() {
        gproduct = new GenericType<Collection<Manageproduct>>(){};
    }
    
    public Manageproduct getAllProductsByid(String id){
        GenericType<Manageproduct> pro = new GenericType<Manageproduct>(){};
        return ad.getProductById(Response.class, id).readEntity(pro);
    }
    
   
    
    
}
