
package resourses;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;


@Path("repath")
@RequestScoped
public class repath {

    @Context
    private UriInfo context;

    public repath() {
    }
    
    

  
    
}
