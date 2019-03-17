angular.module("ProductApp").controller("productListCtrl",function($scope,productService){
	$scope.productList=[];
	console.log("From product controller");
	productService.getProducts().then(
			function(response){
				$scope.productList=response.data;
				console.log($scope.productList);
			},
			function(error){
				alert("Refresh the page")
			}
	
	);
	
	
});