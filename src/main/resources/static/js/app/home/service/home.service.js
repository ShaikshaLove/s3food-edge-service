angular.module("HomeApp").service("HomeService",function($http){
	
	this.getHome=function(){
		return $http.get("/api/products");
	}
	
});