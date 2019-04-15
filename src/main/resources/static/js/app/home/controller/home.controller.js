angular.module("HomeApp").controller("HomeCtrl",function($window,$scope,HomeService){
	$scope.productList={};
	$scope.flag=true;
	$scope.products=[];
	console.log("From home controller")
	HomeService.getHome().then(function(response){
		$scope.productList=response.data;
		$scope.products=$scope.productList.products;
		console.log($scope.productList);
		$scope.flag=false;
	},function(error){
		$scope.flag=false;
	    alert("Please  Refresh  page");
		console.log(error.status);
	});
})