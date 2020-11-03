<template>
	<div class="proba">
		<div>	<p class="table">Name:</p> {{coupon.productName}} </div>
		<div>	<p class="table"> Shop:</p> <span id="shop" v-on:click="setShop()" > {{coupon.shop.name}}</span> </div>
		<div>	<p class="table">Price:</p> <label class="zelena"> {{coupon.newPrice}} </label> </div>
		<div>	<p class="table">Old price:</p> <label class="crvena">  {{coupon.oldPrice}} </label> </div>
		<div>	<p class="table">Valid from:</p> {{format_date(coupon.validFrom)}} </div>
		<div>	<p class="table">Valid to: </p> {{format_date(coupon.validTo)}} </div>
		<div>	<p class="table">Discount:</p> {{format_number(coupon.discount)}}%   </div>
		<div>	<p class="table"><button class="removeCoupon" v-on:click="removeCoupon"> remove </button>  </p> </div> 
	</div>
</template>

<script>

import moment from 'moment'

export default {
	name: "coupon",
	props: ['coupon'],
	methods: {
		removeCoupon(){
			this.$emit('removeCoupon',this.coupon);
		},
      	format_date(value){
		if(value == null){
			return 'Always';
		}
        if (value) {
           return moment(String(value.substring(0,10))).format('DD-MM-YYYY')
          }
	  	},
	 	format_number(number){
		  return Number(number).toFixed(2);
		},
		setShop(){
			this.$emit('set-shop',this.coupon.shop);
		},
   }
	

}
</script>

<style>

.zelena {
	color: #7FFF00;
}

.crvena {
	color: red;
}

.proba {
	display: grid;
    grid-template-columns: repeat(7, 1fr);
    grid-gap: 10px;
	max-width: 1200px;
	border: 5px;
	border-color: blue;
}

p {
	display: inline;
	
}

.proba div {
	display: inline;
}

#shop {
	  cursor: pointer;
}

.table {
	color: blue;
}

</style>