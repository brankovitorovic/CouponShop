package shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import coupon.Coupon;
import coupon.MapperCoupon;
import coupon.RepositoryCoupon;

public class ShopService {

	private final ShopMapper shopMapper;
	private final MapperCoupon couponMapper;
	
	public ShopService(){
		this.shopMapper = new ShopMapper();
		this.couponMapper = new MapperCoupon();
	}
	
	public List<Shop> getShops(){
		return this.shopMapper.mapToModelList(RepositoryShop.getShops());
	}
	
	public void deteleShop(String id) throws IOException{
		
Shop shop = shopMapper.mapToModel(RepositoryShop.getShopById(id));
		
		List<Coupon> tmpList = new ArrayList();
		System.out.println(tmpList);
		for(Coupon c: couponMapper.mapToModelList(( RepositoryCoupon.getCoupons() ) ) ){
			if(shop.getId().equals(c.getShop().getId())){
				RepositoryCoupon.deleteCoupon(c.getId());
			}
		}
		
		RepositoryShop.deleteShop(id);
	}
	
	public void addShop(Shop shop) throws IOException{
		RepositoryShop.addShop(this.shopMapper.mapToEntity(shop));
	}
	
	public List<Coupon> getCouponsForShop(String id){
		Shop shop = shopMapper.mapToModel(RepositoryShop.getShopById(id));
		
		List<Coupon> tmpList = new ArrayList();
		System.out.println(tmpList);
		for(Coupon c: couponMapper.mapToModelList(( RepositoryCoupon.getCoupons() ) ) ){
			if(shop.getId().equals(c.getShop().getId())){
				tmpList.add(c);
			}
		}
		return tmpList;
	}
	
}
