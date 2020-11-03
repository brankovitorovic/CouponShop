
// eslint-disable-next-line no-unused-vars
let CouponClient = {
    loadCoupons(paginationInfo,comp) {
		fetch("http://localhost:8080/ProjekatWebBackend/kupoman/coupons",{
			method: "POST",
			headers: {
			"Accept": "application/json",
            "Content-Type": "application/json"
			},
			body: JSON.stringify(paginationInfo)
		}).then(function (response) {
                return response.json();
            })
            .then(function (couponsVal) {
				comp.coupons = couponsVal.visibleCoupons;
				comp.paginationInfo.totalPages = couponsVal.totalPages;
				comp.paginationInfo.currentPage = couponsVal.currentPage;
				comp.paginationInfo.active = couponsVal.active;
				comp.paginationInfo.pageSize = couponsVal.pageSize;
            });
	},

	removeCoupon(coupon,paginationInfo,comp){

		fetch("http://localhost:8080/ProjekatWebBackend/kupoman/coupons", {
			method: "DELETE",
			headers: {
			"Accept": "application/json",
            "Content-Type": "application/json"
			},
			body: JSON.stringify(coupon)
		}).then(function(){
			CouponClient.loadCoupons(paginationInfo,comp);
		})
		},

		addCoupon(coupon, paginationInfo,comp) {  
        fetch("http://localhost:8080/ProjekatWebBackend/kupoman/coupons", {
          method: "PUT",
          headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
          },
          body: JSON.stringify(coupon)
        }).then(function() {
			CouponClient.loadCoupons(paginationInfo,comp);
          });
      }
	}

	export default CouponClient