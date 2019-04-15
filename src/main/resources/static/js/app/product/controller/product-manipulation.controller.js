angular.module("ProductApp").controller("productManipulationCtrl",function($scope,productService){
//	$scope.productList=[];
	$scope.flag=false;
	$scope.message="";
	console.log("From product manipulation controller");
	productService.getProducts().then(
			function(response){
				$scope.products=(response.data).products;
				console.log($scope.products);
			},
			function(error){
				alert("Refresh the page")
			}

	);
	$scope.delete=function(productId){
		console.log("From product manipulation controller"+productId);

		productService.delete(productId).then(
				function(response){
					$scope.message=(response.data).content;
					$scope.flag=true;
					
					
					productService.getProducts().then(
							function(response){
								$scope.products=(response.data).products;
								console.log($scope.products);
							},
							function(error){
								alert("Refresh the page")
							}

					);			
				},
				function(error){
					$scope.flag=true;
					if(error.status===405){
					    $scope.message="Oye! You are not a owner of s3food.  Obviously you have no right to delete or update any product";
					}else{
						alert("Some technical error try again")

					}
					
				}
		);
	};
	
	
	$scope.product={};
	$scope.getProduct=function(productId){
		console.log(productId+" from getProduct")
		productService.getProduct(productId).then(function(response){
			$scope.product=response.data;
		},function(error){});
	}
	
	$scope.hide=false;
	$scope.loader=false;
	$scope.update=function(){
		$scope.loader=true;
		productService.update($scope.product).then(function(response){
			$scope.message=response.data;
			$scope.hide=true;
			$scope.loader=false;
			$scope.product={};
			
			productService.getProducts().then(
					function(response){
						$scope.products=(response.data).products;
						console.log($scope.products);
					},
					function(error){
						alert("Refresh the page")
					}

			);
			
			
		},function(error){
			$scope.message="Some technical error. try again";
			$scope.loader=false;

		});
	}
	
	
	

});