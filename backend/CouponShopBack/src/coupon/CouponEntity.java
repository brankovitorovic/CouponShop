package coupon;

import java.util.Date;

import shop.Shop;
import shop.ShopEntity;

public class CouponEntity {

	private Long id;
    private ShopEntity shop;
    private String productName;
    private Float newPrice;
    private Float oldPrice;
	private Date validFrom;
	private Date validTo;
	
	public CouponEntity() {
		super();
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public ShopEntity getShopId() {
		return shop;
	}



	public void setShopId(ShopEntity shopId) {
		this.shop = shopId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public Float getNewPrice() {
		return newPrice;
	}



	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}



	public Float getOldPrice() {
		return oldPrice;
	}



	public void setOldPrice(Float oldPrice) {
		this.oldPrice = oldPrice;
	}



	public Date getValidFrom() {
		return validFrom;
	}



	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}



	public Date getValidTo() {
		return validTo;
	}



	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}



	@Override
	public String toString() {
		return "CouponEntity [id=" + id + ", shopId=" + shop + ", productName=" + productName + ", newPrice="
				+ newPrice + ", oldPrice=" + oldPrice + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}
	
	
}
