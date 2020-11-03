import CouponClient from "@/clients/coupon-client.js"

let ShopClient = {
    loadShops(comp) {
      fetch("http://localhost:8080/ProjekatWebBackend/kupoman/shops")
        .then(function(response) {
          return response.json();
        })
        .then(function(shops) {
          comp.shops = shops;
        });
	},
	addShop(shop,comp){
		fetch("http://localhost:8080/ProjekatWebBackend/kupoman/shops", {
			method: "POST",
			headers: {
			"Accept": "application/json",
            "Content-Type": "application/json"
			},
			body: JSON.stringify(shop)
		}).then(function(){
			ShopClient.loadShops(comp);
		})
	},
	getCoupons(id,comp) {
      fetch("http://localhost:8080/ProjekatWebBackend/kupoman/shops/" + id, {
		method: "GET",
	}).then(function(response) {
          return response.json();
        })
        .then(function(coupons) {
          comp.couponsForShop = coupons;
        });
	},
	deleteShop(paginationInfo,id,comp) {
      fetch("http://localhost:8080/ProjekatWebBackend/kupoman/shops/" + id,{
		method: "DELETE",
	}).then( () => {
			ShopClient.loadShops(comp);
			CouponClient.loadCoupons(paginationInfo,comp);
			comp.shop = null;
        
	} );
	},
}


export default ShopClient