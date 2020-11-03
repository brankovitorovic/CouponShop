package coupon;

import java.io.IOException;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pagination.PaginationModel;

@Path("/coupons")
public class EndpointCoupon {

	private final ServiceCoupon service;
	
	public EndpointCoupon(){
		this.service = new ServiceCoupon();
	}
	
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public PaginationModel getCoupons(PaginationModel paginationModel) throws ParseException {
		
		
		
        return service.getCoupons(paginationModel);
    }

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Coupon deleteCoupon(Coupon coupon) throws IOException{ 
		service.deleteCoupon(coupon.getId());
		return coupon;
	}
	

	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCoupon(Coupon coupon) throws IOException{
		service.addCoupon(coupon);
	}
	
}
