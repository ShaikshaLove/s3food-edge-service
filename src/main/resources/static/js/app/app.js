angular.module("foodapp",["MyProfile","navBar","UserApp","ProductApp","HomeApp","ngRoute"]);

/*angular.module("s3food").config(function($routeProvider){
	console.log("from route  config")

	$routeProvider.when("/home",{
		templateUrl:"/js/app/home/html/home.html",
		controller:"HomeController"
	});
	$routeProvider.otherwise({
		templateUrl:"/js/app/home/html/home.html",
		controller:"HomeController"
	});
});
 */

angular.module("foodapp").config(function($httpProvider,$routeProvider){
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	console.log("from route  config")

	$routeProvider.when("/home",{
		templateUrl:"js/app/home/html/home.html",
		controller:"HomeCtrl"
	}
	);

	$routeProvider.when("/error",{

		templateUrl:"js/app/home/html/error.html",
		controller:"HomeCtrl"

	}
	);


	$routeProvider.when("/products",{

		templateUrl:"js/app/product/html/product-list.html",
		controller:"productListCtrl"

	}
	);

	$routeProvider.when("/product-register",{

		templateUrl:"js/app/product/html/product-register.html",
		controller:"productRegisterCtrl"

	}
	);

	$routeProvider.when("/product-manipulation",{

		templateUrl:"js/app/product/html/product-manipulation.html",
		controller:"productManipulationCtrl"

	}
	);
		
	$routeProvider.when("/user-data",{

		templateUrl:"js/app/user/html/user-data.html",
		controller:"userListController"

	}
	);
	
	
	$routeProvider.when("/my-profile",{

		templateUrl:"js/app/myprofile/html/MyProfile.html",
		controller:"MyProfileCtrl"

	}
	);


	$routeProvider.otherwise(
			{
				templateUrl:"js/app/home/html/home.html",
				controller:"HomeCtrl"
			});


});