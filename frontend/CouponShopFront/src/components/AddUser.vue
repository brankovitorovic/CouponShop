<template>
	
	
<form v-on:submit="addUser">

	<input type="text" v-model="firstName" name="firstName" placeholder="FirstName" required>

	<input type="text" v-model="lastName" name="lastName" placeholder="LastName" required>

	<select v-model="level" required>
		<option>ADMINISTRATOR</option>
		<option>OPERATOR</option>
	</select>

	<input type="text" v-model="username" name="username" placeholder="username" required>

	<input type="text" v-model="password" name="password" placeholder="password" required>
	

	<input type="submit" value="Add">

</form>

</template>

<script>
export default {
	name:"addUser",

	data(){
		return {
			firstName:"",
			lastName:"",
			username:"",
			password:"",
			level:"OPERATOR"
		};
	},

	methods: {
		addUser(e){
			e.preventDefault();

			const user = {
				firstName: this.firstName,
				lastName: this.lastName,
				privilegeLevel: this.level,
				username: this.username,
				password: this.password
			};
		this.$emit("add-user",user);

		this.firstName = "";
		this.lastName = "";
		
		this.username = "";
		this.password = "";

		return false;
		}
	}

}
</script>
