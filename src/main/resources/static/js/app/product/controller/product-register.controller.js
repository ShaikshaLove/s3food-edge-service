angular.module("ProductApp").controller("productRegisterCtrl",function($scope,productService){
	$scope.product={};
	$scope.myFile;
	$scope.loader=false;
	$scope.message="";
	$scope.showMessage=false;
	$scope.save=function(){
		$scope.loader=true;
		console.log($scope.product);
		productService.saveProduct($scope.product,$scope.myFile).then(function (response){

			if(response.status===201){
				$scope.message=(response.data).content;
				$scope.product={};
			}else{
				$scope.message="Oye! You are not a owner of s3food.  Obviously you have no right to Sell any product";
			}
			$scope.showMessage=true;
			$scope.loader=false;
		},function(error){
			$scope.loader=false;
			$scope.showMessage=true;	
			if(error.status===401){
				$scope.message="Oye! You are not a owner of s3food.  Obviously you have no right to Sell any product";
			}
			else if(error.status===405){
				$scope.message="Oye! You are not a owner of s3food.  Obviously you have no right to Sell any product";
			}else{
				$scope.message="Some technical error, please try again";
			}
		}
		);
	}

});