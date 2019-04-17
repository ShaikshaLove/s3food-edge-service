angular.module("MyProfile").controller("MyProfileCtrl",function($scope,navService){
	$scope.navbar={};
	navService.getNavBar().then(function(response){
    $scope.navbar=response.data;
	console.log("Hey!! from myprofile COntroller")
	console.log($scope.navbar)


      },function(error){
    		$scope.showNav=false;    	  
      });

});