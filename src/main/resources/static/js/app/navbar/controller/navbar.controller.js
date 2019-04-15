angular.module("navBar").controller("navController",function($scope,navService){
	$scope.navbar={};
	$scope.showNav=false;
	navService.getNavBar().then(function(response){
    $scope.navbar=response.data;
	$scope.showNav=true;    	  
      },function(error){
    		$scope.showNav=false;    	  
      });

});