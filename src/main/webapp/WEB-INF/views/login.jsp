<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>S3food</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	     rel="stylesheet" crossorigin="anonymous" />

</head>
<body class="jumbotron jumbotron-fluid">




	<header>
		<nav style="background-color: black;" class="navbar navbar-expand-md  navbar-dark fixed-top">
		<!--	<a class="navbar-brand" href="#"
				style="font-style: inherit; font-family: Verdana, Geneva, Tahoma, sans-serif">S3food
			</a><img src="./images/run.gif" alt="Logo" style="width:60px;">-->
			
			 <a class="navbar-brand text-center" href="#">
               <img src="./images/index_logo1.jpg" alt="Logo" style="width:180px;height:60px;">
             </a>
			<marquee> <small style="color:cyan;">S3food is under development. we are glad of you being here</small></marquee> 
		</nav>      
		
	</header>

	<nav  style="background-color:black;" class="navbar navbar-expand-sm  navbar-dark fixed-bottom">
		<small class="text-light">Copyrights &#169; 2019 Designed and Developed by shaiksha</small>
	</nav>

<div style="margin-top: 100px" class="container">
		<form class="form-signin" method="post" action="perform-login">
			<h5 style="color:red"	 class="form-signin-heading text-center">Please Sign in</h5>
			<p>
				<label for="username" class="sr-only">Username</label> <input
					type="text" id="username" name="username" class="form-control"
					placeholder="Username" required autofocus>
			</p>
			<p>
				<label for="password" class="sr-only">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Password" required>
			</p>
			<button class="btn btn-md
			 btn-success btn-block" type="submit">Log
				in</button>

			<br> <small style="padding-top: 30px;">Don't you have an account? <a href="./user-registration">&nbsp;<strong
					class="text-danger">Click here</strong></a>
			</small>
			
		</form>
		
		<c:if test="${message ne null}">
	       <div class="alert alert-danger alert-dismissible">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
                 <h6 class="text-center">${message}</h6>
           </div>
	    </c:if>
	</div>
	
	<c:if test="${authMessage ne null}">
	   <div class="alert alert-danger alert-dismissible">
           <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h6  class="text-center">${authMessage}</h6>
       </div>
	</c:if>
	
	<c:if test="${logoutMessage ne null}">
	   <div class="alert alert-success alert-dismissible">
           <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h6  class="text-center">${logoutMessage}</h6>
       </div>
	</c:if>
	
	
	
	
	
</body>
</html>
