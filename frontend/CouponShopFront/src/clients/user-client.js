
let UserClient = {

	checkUser(user,comp){
		fetch("http://localhost:8080/ProjekatWebBackend/kupoman/user", {
			method: "PUT",
			headers: {
			"Accept": "application/json",
            "Content-Type": "application/json"
			},
			body: JSON.stringify(user)
		})
			.then(function(response) {
            return response.json();
          })
        .then(function(user) {
			
        comp.user = user
        });

			
	},

	addUser(user){
		
		fetch("http://localhost:8080/ProjekatWebBackend/kupoman/user", {
			method: "POST",
			headers: {
			"Accept": "application/json",
            "Content-Type": "application/json"
			},
			body: JSON.stringify(user)
		});
	}

}

export default UserClient