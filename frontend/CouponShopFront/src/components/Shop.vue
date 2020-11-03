<template>
	<div>

		<span id="back" v-on:click="resetShop()"> &lt;Back </span>
		<br><br><br>
		<br>
		
		Shop name: {{shop.name}}

		<br><br><br>

		Coupons of this shop: 

		<ul id="1">
 			<li v-for="coupon in couponsForShop" :key="coupon.id">
 				   {{ coupon.productName }}
  			</li>
		</ul>

		<button v-on:click="deleteShop()"> Delete this shop ( all coupons will be deleted automatically) </button>

	</div>
</template>

<script>



export default {


props:["shop","couponsForShop"],

methods: {
	resetShop(){
		this.$emit('reset-shop');
	},
	deleteShop(){
		this.$emit('delete-shop',this.shop.id);
	},
	
},

beforeMount(){

	this.$emit('get-coupons-for-shop',this.shop.id);
}

}
</script>

<style>
#back {
	cursor: pointer;
}
</style>
