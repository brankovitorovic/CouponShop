package user;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/user")
public class UserEndpoint {

	 private final UserService service;

	    public UserEndpoint() {
	        this.service = new UserService();
	    }
	    
	    @GET
	    public String something(){
	    	return "proba";
	    }

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public User addUser(User user) {
	    	try {
		    	return this.service.addUser(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return null;
	    }
	    
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public UserWrapper isRegistered(UserLogIn userLogIn) {
	        return service.isRegistered(userLogIn);
	    }
	
}
