<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="UserApp">
<head>
<meta charset="ISO-8859-1">
<title>S3food</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  
    <script type="text/javascript" src="./js/vendor/angular.js"></script>
    <script type="text/javascript" src="./js/vendor/angular-route.js"></script>
    
    <script type="text/javascript" src="./js/app/user/user.module.js"></script>
    <script type="text/javascript" src="./js/app/user/service/user.service.js"></script>
    <script type="text/javascript" src="./js/app/user/controller/user.controller.js"></script>
   
   <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	        rel="stylesheet" crossorigin="anonymous" />
	     


</head>
<body ng-controller="userController">





	<header>
		<nav  style="background-color: #1C1514;"  class="navbar navbar-expand-md navbar-dark fixed-top">
		<!--	<a class="navbar-brand" href="#"
				style="font-style: inherit; font-family: Verdana, Geneva, Tahoma, sans-serif">S3food
			</a><img src="./images/run.gif" alt="Logo" style="width:60px;">-->
			
			 <a class="navbar-brand text-center" href="#">
               <img src="./images/logo5.jpg" alt="Logo" style="width:130px;height:50px;">
             </a>
			<!--<marquee> <h6 style="color:cyan;">S3food-Tadipatri welcomes you</h6></marquee>-->
		</nav>
	</header>


	<nav  style="background-color: #1C1514;"  class="navbar navbar-expand-sm  navbar-dark fixed-bottom">
		<small class="text-light">@S3food.in, Contrived and
			originated by shaiksha</small>
	</nav>





<div style="margin-top:25px" class="container">
    
    <div style="margin-top:120px" ng-show="showMessage">
	       <div class="alert alert-info >
                 <h5 class="text-center">Verify your email by simply clicking the link. {{message}}</h5>
                 
                 <br> 
           </div>
           <small style="padding-top: 30px;">Do you wish to login ? <a href="/login">&nbsp;<strong
					class="text-danger">Click here</strong></a>
			</small>
	 </div>

		<form ng-hide="showMessage" class="form-signin">
			<h4 class="form-signin-heading text-center text-muted">Sign Up</h4>
			<p>
				<label for="firstname" class="sr-only">First Name</label> <input
					type="text" id="firstname" name="firstName" class="form-control"
					ng-model="user.firstName" placeholder="First Name" required autofocus>
					<small ng-show="error"
					class="text-danger">{{errors.firstName}}</small>
				</p>	<p>
					<label for="lastname" class="sr-only">Last Name</label> <input
					type="text" id="lastname" name="lastName" class="form-control"
				ng-model="user.lastName"	placeholder="Last Name" required autofocus>
				<small
					ng-show="error" class="text-danger">{{errors.lastName}}</small>
						</p>	<p>
					<label for="email" class="sr-only">Last Name</label> <input
					type="email" id="email" name="email" class="form-control"
					ng-model="user.email" placeholder="Email" required autofocus>
						<small ng-show="error" class="text-danger">{{errors.email}}</small>
					
						</p>	
						<p>
					<label for="password" class="sr-only">Last Name</label> <input
					type="password" id="password" name="password" class="form-control"
				ng-model="user.password"	placeholder="Password" required autofocus>
				<small ng-show="error" class="text-danger">{{errors.password}}</small>
				</p>	
				<p>
				   <label for="password" class="sr-only">Conforrm Password</label> <input
					type="password" id="Cnfpassword" name="matchingPassword" class="form-control"
				ng-model="user.matchingPassword"	placeholder="Conform Password" required>
					
				<small ng-show="error"
					class="text-danger">{{errors.matchingPassword}}</small>	
					
			</p>
			<button ng-show="flag" ng-click="reg();" class="btn btn-md
			 btn-danger btn-block" type="submit">Register</button>
			 
			 
			 <button ng-hide="flag" class="btn btn-warning btn-block" type="button" disabled>
               <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                   We're registering you...
             </button>
			 

			<br> <small style="padding-top: 30px;">Do you  have an account already? <a href="/login">&nbsp;<strong
					class="text-danger">Click here</strong></a>
			</small>
			
		</form>
		
		
	</div>
	
	
	
	
	
	
	
</body>
</html>