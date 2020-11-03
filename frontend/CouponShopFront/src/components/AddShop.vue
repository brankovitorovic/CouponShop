<template>
	<div>
		<form>
		<input type="text" v-model="name" placeholder="Enter shop's name.." required>
		</form>
		<br>
		<button v-on:click="addShop">Add</button>
	
	</div>
</template>

<script>
export default {
	
	data() {
		return{
			name: ""
		}
	},

	methods:{
		addShop(){

			if(this.name == ""){
				window.alert("Name of shop must be entered.");
				return;
			}

			const shop = {
				name: this.name
			}
			this.$emit("add-shop",shop);
			this.name = "" ;
		}
	}



}
</script>

