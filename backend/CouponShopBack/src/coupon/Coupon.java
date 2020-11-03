package coupon;

import java.util.Date;

import shop.Shop;

public class Coupon {

	private Long id;
    private Shop shop;
    private String productName;
    private Float newPrice;
    private Float oldPrice;
	private Date validFrom;
	private Date validTo;
	private Float discount;
	
	public Coupon() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
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
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	
	
	
}
