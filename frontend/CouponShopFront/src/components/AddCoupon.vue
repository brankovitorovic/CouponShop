<template>

  <form v-on:submit="addCoupon">

	<input type="text" v-model="productName" name="productName" placeholder="Product name" required>
    

    <select v-model="selectedShop" required>
		<option v-bind:key="shop.id" v-for="shop in shops" :value="shop" >{{shop.name}}</option>
    </select>
    
   
	 <input
      type="number"
      v-model.number="oldPrice"
      name="oldPrice"
      placeholder="Enter old price"
	  required
    >
    
    <input
      type="number"
      v-model.number="newPrice"
      name="newPrice"
      placeholder="Enter new price"
	  required
    >
    
    <input type="submit" value="Create">
  </form>
</template>

<script>
export default {
  name: "AddCoupon",

 props: ["shops"],
  data() {
    return {
      selectedShop: {},
      productName: "",
      oldPrice: 0,
      newPrice: 0
    };
  },
  methods: {
    addCoupon(e) {
      e.preventDefault();

      const newCoupon = {
        shop: this.selectedShop,
        productName: this.productName,
        oldPrice: this.oldPrice,
        newPrice: this.newPrice
      };

     this.$emit("add-coupon", newCoupon);

      this.shop = this.shops[0];
      this.productName = "";
      this.oldPrice = 0;
      this.newPrice = 0;
return false;
    }
  }
};
</script>
