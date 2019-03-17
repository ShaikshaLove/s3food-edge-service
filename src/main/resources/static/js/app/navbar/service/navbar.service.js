angular.module("navBar").service("navService",function($http){
	this.getNavBar=function(){
		return $http.get("/myaccount/navbar");
	}
});