package backend;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import filter.CorsFilter;


@ApplicationPath("/kupoman")
public class RestApp extends ResourceConfig{

	public RestApp() {
		packages("src");

		
	}
	
}