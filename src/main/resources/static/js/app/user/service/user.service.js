angular.module("UserApp").service("userService",function($http){
	console.log("User-service");
	this.register=function(user){
		return $http.post("/users",user);
	}
	
	this.getUsers=function(){
		return $http.get("/users");
	}
	
	this.deleteUser=function(userId){
		
		return $http.delete("/users/"+userId);
	}
	this.getUser=function(emailId){
		return $http.get("/users/"+emailId);
	}
	
	this.updateUser=function(user){
		console.log(user);
		return $http.put("/users",user);
	};
});