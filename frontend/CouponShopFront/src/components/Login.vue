<template>
	
<form v-on:submit="checkUser">

	<input type="text" v-model="username" name="username" placeholder="Username..">

	<input type="password" v-model="password" name="password" placeholder="Password..">

	<input type="submit" value="Login">

</form>

</template>

<script>
export default {
	name:"checkUser",

	data(){
		return{
			username:"",
			password:""
		};
	},

	methods: {
		checkUser(e){
			e.preventDefault();

			const user = {
				username: this.username,
				password: this.password
			};
		this.$emit("check-user",user);

		this.username = "";
		this.password = "";

		return false;

		}
	}

}

</script>
