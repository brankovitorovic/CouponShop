<template>
	<div class="wrapper">
		Number of coupons per page:
		<select id="pages" v-model="numberOfPages">
			<option selected>5</option>
			<option value="10">10</option>
			<option value="15">15</option>
			<option value="20">20</option>
		</select>

		<input type="checkbox" id="checkbox" v-model="checked"> Only active coupons 

		<button id="filter" v-on:click="doPagination()"> 
			Activate filter
		</button>

		

	</div>	
</template>

<script>
  export default {

	props:["paginationInfo"],

    data() {
      return {
		checked: 'true',
		numberOfPages: 5,
      }
	},
	methods: {
		doPagination(){
			this.$emit("do-pagination",this.numberOfPages,this.checked);
		}

	}
  }
</script>

<style>

#pages {
	margin-right:30px;
	margin-left: 5px;
}

#filter {
	margin-left: 50px;
}

.wrapper{
	margin-bottom: 15px;
}

</style>