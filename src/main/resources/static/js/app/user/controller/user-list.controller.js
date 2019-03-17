angular.module("UserApp").controller("userListController",function($scope,userService){
	$scope.showMessage=false;
	userService.getUsers().then(function(response){
		$scope.users=response.data;
	},function(error){
		console.log(error);
	});

	$scope.delete=function(userId){

		userService.deleteUser(userId).then(
				function(response){
					$scope.message=(response.data).content;
					$scope.showMessage=true;
					
					userService.getUsers().then(function(response){
						$scope.users=response.data;
					},function(error){
						console.log(error);
					});
					
					
				},
				function(error){
					$scope.showMessage=true;
					if(error.status===405){
					    $scope.message="Oye! You are not a owner of s3food.  Obviously you have no right to delete or update any user data";
					}else{
						alert("Some technical error try again")

					}
				}			

		);

	};
	
	$scope.user={};	
	$scope.getUser=function(emailId){
		console.log(emailId+" from getUser()");
		userService.getUser(emailId).then(function(response){
			$scope.user=response.data;	
			console.log($scope.user);
		},function(error){});
	};
	$scope.loader=false;
	$scope.hide=false;
	$scope.roles=[];
	$scope.update=function(){
		$scope.loader=true;
		$scope.roles.push($scope.user.roles);
		$scope.user.roles=$scope.roles;
		userService.updateUser($scope.user).then(function(response){
			$scope.message="The user details are updated for the user "+$scope.user.email;	
			$scope.loader=false;
			$scope.showMessage=true;
			$scope.hide=true;
			$scope.user={};	
			
			userService.getUsers().then(function(response){
				$scope.users=response.data;
			},function(error){
				console.log(error);
			});
		},function(error){
			$scope.message="Some technical issue during updation of the user details, try again please.";	
			$scope.loader=false;
			$scope.user={};	
		});
	}
	
	
	
	

});