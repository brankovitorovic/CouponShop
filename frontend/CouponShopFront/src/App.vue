<template>
 <div>

<div v-if="user === null">
<Login class="login" v-on:check-user="checkUser"/>

</div>
<div v-else>

	<div class="login" v-if="this.user.isSuccessfull == false">
		<Login v-on:check-user="checkUser"/>
		<h2> Username or password is wrong! </h2>
	</div>

	<div v-else>

		<div v-if="shop === null">
			<!--ovo se ispisuje ne vezano dal je operator ili administrator -->
			<div class="name"> {{this.user.user.firstName}} {{this.user.user.lastName}} - {{this.user.user.privilegeLevel}} 
				<button id="logout" v-on:click="logOut()"> Logout </button>  </div> 
			
			<!--proverom da li je administrator se dodaje componenta za dodavanje clana -->
			<div v-if="this.user.user.privilegeLevel == 'ADMINISTRATOR' ">
			
				Add new user:	  
				<AddUser v-on:add-user="addUser"/>

			</div>
			
			<br><br><br>Table of coupons: <br> <br>

			

			<Pagination v-on:do-pagination="doPagination" v-bind:paginationInfo="paginationInfo" > </Pagination> 
			
			<Coupon class="coupons" v-for="coupon in coupons" v-bind:coupon="coupon" v-on:set-shop="setShop" v-on:removeCoupon="removeCoupon" :key="coupon.id"> </Coupon>

			<PaginationPages id = "paginationPage" v-on:next-page="changePage" v-on:previous-page="changePage" v-bind:paginationInfo="paginationInfo"> </PaginationPages> 

			<br> <br> <br>
			Add coupon: <br><br>

			<AddCoupon v-on:add-coupon="addCoupon" v-bind:shops="shops"/>

			<br> <br> <br>
			Add shop: <br> <br> 
			<AddShop v-on:add-shop="addShop"/>
		</div>

		<div v-else>

			<Shop v-bind:shop="shop" v-bind:couponsForShop="couponsForShop" v-on:delete-shop="deleteShop" v-on:reset-shop="resetShop" v-on:get-coupons-for-shop="loadCouponsForShop" />

		</div>

	</div>	

	
</div>

</div>
</template>



<script>

import Login from "./components/Login";
import AddUser from "./components/AddUser"
import Coupon from "./components/Coupon"
import Pagination from "./components/Pagination"
import PaginationPages from "./components/PaginationPages"
import AddCoupon from "./components/AddCoupon"
import AddShop from "./components/AddShop"
import Shop from "./components/Shop"

import UserClient from "@/clients/user-client.js"
import CouponClient from "@/clients/coupon-client.js"
import ShopClient from "@/clients/shop-client.js"



export default {
  name: 'app',
  components: {
	Login,
	AddUser,
	Coupon,
	Pagination,
	PaginationPages,
	AddCoupon,
	AddShop,
	Shop
  },

  data() {
      return {
		user:null,
		coupons: [],
		shops: [],
		paginationInfo: {
			pageSize: 5,
			active: true,
			currentPage: 0,
			totalPages: 2,
		},
		shop: null,
		couponsForShop: [],
      }
	},
  methods:{
	checkUser(user){
		UserClient.checkUser(user,this);
	},
	addUser(user){
		UserClient.addUser(user); 
	},
	
	removeCoupon(coupon){
		CouponClient.removeCoupon(coupon,this.paginationInfo,this);
	},

	doPagination(numberOfPages,active){
		this.paginationInfo.pageSize = numberOfPages;
		this.paginationInfo.active = active;
		this.paginationInfo.currentPage = 0;
		CouponClient.loadCoupons(this.paginationInfo,this);
	},
	logOut(){
		this.user = null;
	},
	changePage(curretnPage){
		this.paginationInfo.currentPage = curretnPage;
		CouponClient.loadCoupons(this.paginationInfo,this);
	},
	addCoupon(coupon) {
      CouponClient.addCoupon(coupon,this.paginationInfo, this);
	},
	addShop(shop){
		ShopClient.addShop(shop,this);
	},
	setShop(shop){
		this.shop = shop;
	},
	resetShop(){
		this.shop = null;
	},
	loadCouponsForShop(id){
		ShopClient.getCoupons(id,this);
	},
	deleteShop(id){
		ShopClient.deleteShop(this.paginationInfo,id,this);
	}
  },

created() {
   ShopClient.loadShops(this);
   CouponClient.loadCoupons(this.paginationInfo,this);

 }

}



</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.login {
    text-align: center;
	color: red;
}

#logout {
	margin-left: 10px;
	margin-right: 10px; 
}

.name {
	text-align: right;
	color: blue;
}
.coupons{
	background-color: silver;
}

#paginationPage {
	position: absolute;
	margin-top: 20px;
	text-align: left;
	margin-left: 550px;
	color: blue;
	font-size: 22px;
}

</style>
