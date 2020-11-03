package pagination;

import java.io.Serializable;
import java.util.List;

import coupon.Coupon;

public class PaginationModel implements Serializable{

	private int currentPage;
	private int pageSize;
	private List<Coupon> visibleCoupons;
	private boolean active;
	private int totalPages;
	
	public PaginationModel() {
		super();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Coupon> getVisibleCoupons() {
		return visibleCoupons;
	}
	public void setVisibleCoupons(List<Coupon> visibleCoupons) {
		this.visibleCoupons = visibleCoupons;
	}
	
	public boolean getActive(){
		return this.active;
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
