package coupon;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pagination.PaginationModel;
import shop.RepositoryShop;
import shop.ShopEntity;

public class ServiceCoupon {

	private final MapperCoupon couponMapper;
	
	public ServiceCoupon() {
        couponMapper = new MapperCoupon();
    }

    public PaginationModel getCoupons(PaginationModel paginationModel) throws ParseException {
    	
    	List<Coupon> list = couponMapper.mapToModelList(RepositoryCoupon.getCoupons());
    	List<Coupon> tmpList = new ArrayList<>();
    	
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    	date = sdf.parse(sdf.format(date));
    	
    	if(paginationModel.getActive()){
    		for(Coupon c:list){
    			if(c.getValidTo() == null){
    				tmpList.add(c);
    				continue;
    			}
        		if(c.getValidTo().after(date)){
        			tmpList.add(c);
        		}
        	}
    	}else {
    		tmpList.addAll(list);
    	}
    	
    	paginationModel.setTotalPages( (int) Math.round( ( Math.ceil( tmpList.size() / (float)paginationModel.getPageSize()) ) ) );
    	
    	
   
    	int currentPage = Math.min(paginationModel.getCurrentPage(), paginationModel.getTotalPages() - 1);
    	
    	paginationModel.setCurrentPage(currentPage);
    	
    	
    	int left = paginationModel.getCurrentPage() * paginationModel.getPageSize();
    	int right = Math.min(paginationModel.getCurrentPage() * paginationModel.getPageSize() + paginationModel.getPageSize(), tmpList.size() );
    	
    	
    	tmpList = tmpList.subList(left,right);
    	
    	paginationModel.setVisibleCoupons(tmpList);
    	
    	
        return paginationModel;
    }

    
    public void addCoupon(Coupon c) throws IOException {
        CouponEntity couponEntity = couponMapper.mapToEntity(c);

        ShopEntity shopEntity = RepositoryShop.getShopById(c.getShop().getId());
        couponEntity.setShopId(shopEntity);
        
        RepositoryCoupon.addCoupon(couponEntity);
    }

    public void deleteCoupon(Long id) throws IOException {
    	RepositoryCoupon.deleteCoupon(id);
    }
	
}
