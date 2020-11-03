package coupon;

import java.util.List;
import java.util.stream.Collectors;

import shop.ShopMapper;

public class MapperCoupon {

	private final ShopMapper mapper = new ShopMapper();
	
	public CouponEntity mapToEntity(Coupon coupon){
		
		
		if(coupon == null){
			return null;
		}
		
		CouponEntity c = new CouponEntity();
		c.setId(coupon.getId());
		c.setShopId(mapper.mapToEntity(coupon.getShop()));
		c.setProductName(coupon.getProductName());
		c.setNewPrice(coupon.getNewPrice());
		c.setOldPrice(coupon.getOldPrice());
		c.setValidFrom(coupon.getValidFrom());
		c.setValidTo(coupon.getValidTo());
		
		return c;
		
	}
	
	public Coupon mapToModel(CouponEntity couponEntity){
		
		Coupon coupon = new Coupon();
		
		if(couponEntity == null){
			return null;
		}
		
		coupon.setId(couponEntity.getId());
		coupon.setProductName(couponEntity.getProductName());
        coupon.setNewPrice(couponEntity.getNewPrice());
        coupon.setOldPrice(couponEntity.getOldPrice());
        coupon.setShop(mapper.mapToModel(couponEntity.getShopId()));
        coupon.setDiscount(calculateDiscount(couponEntity.getOldPrice(), couponEntity.getNewPrice()));
        coupon.setValidFrom(couponEntity.getValidFrom());
        coupon.setValidTo(couponEntity.getValidTo());
        
        return coupon;
		
	}

	public List<Coupon> mapToModelList(List<CouponEntity> couponEntities) {
        if (couponEntities == null) {
            return null;
        }
        return couponEntities.stream().map(this::mapToModel).collect(Collectors.toList());
    }
	
	private Float calculateDiscount(Float oldPrice, Float newPrice) {
        if(newPrice.equals(oldPrice)){
            return 0f;
        }

        if(newPrice == 0){
            return 100f;
        }

        return (100 - (newPrice * 100 / oldPrice)) * -1;
    }
	
}
