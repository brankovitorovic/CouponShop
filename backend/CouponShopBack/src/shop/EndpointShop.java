package shop;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import coupon.Coupon;

@Path("shops")
public class EndpointShop {
	
	
	private static ShopService shopService;

	public EndpointShop(){
		this.shopService = new ShopService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shop> getShops() {
        return this.shopService.getShops();
    }
	
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Coupon> getCouponsForShop(@PathParam("id") String id){
		return shopService.getCouponsForShop(id);
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void addShop(Shop shop) throws IOException{
		this.shopService.addShop(shop);
	}
	
	@DELETE
    @Path("{id}")
    public void deleteShop(@PathParam("id") String id) throws IOException{
		this.shopService.deteleShop(id);
	}
}
