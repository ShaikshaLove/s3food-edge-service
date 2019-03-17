angular.module("navBar").controller("navController",function($scope,navService){
	$scope.navbar={};
	navService.getNavBar().then(function(response){
    $scope.navbar=response.data;
      },function(error){
    	  
      });

});