<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="edu.ben.daos.RecipeDao"%>
	<%@ page import="edu.ben.models.Recipe"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Recipe Board</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap and Font Awesome css-->
<!-- we use cdn but you can also include local files located in css directory-->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Google fonts - Roboto for copy, Montserrat for headings-->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:300,400,700">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
<!-- owl carousel-->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="favicon.png">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>

	<!-- Facebook plugin -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.8";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- navbar-->
	<header class="header">
	<div role="navigation" class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a href="ServHome" class="navbar-brand"><img
					src="img/logoNew.png" alt="logo" class="hidden-xs hidden-sm"><img
					src="img/logoNew.png" alt="logo" class="visible-xs visible-sm"><span
					class="sr-only">Go to homepage</span></a>
				<div class="navbar-buttons">
					<button type="button" data-toggle="collapse"
						data-target=".navbar-collapse" class="navbar-toggle navbar-btn">
						Menu<i class="fa fa-align-justify"></i>
					</button>
				</div>
			</div>
			<div id="navigation" class="collapse navbar-collapse navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="ServHome">Home</a></li>
					<li><a href="ServCategory">Recipes</a></li>
					<li><a href="ServAddRecipe">Add Recipe</a></li>
					<li><a href="ServContact">Contact</a></li>

				</ul>
				<a href="#" data-toggle="modal" data-target="#login-modal"
					class="btn navbar-btn btn-white"><i class="fa fa-sign-in"></i>Log
					in/out</a>
			</div>
		</div>
	</div>
	</header>
	<!-- *** LOGIN MODAL ***_________________________________________________________
    -->
	<div id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true" class="modal fade">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" data-dismiss="modal" aria-hidden="true"
						class="close">×</button>
					<h4 id="Login" class="modal-title">User login</h4>
				</div>
				<div class="modal-body">
					<form action="ServLogin" name="servletlogin" method="post"
						onSubmit="return formLoginValidation();">
						<div class="form-group">
							<input id="userName_modal" type="text" placeholder="Username"
								class="form-control" name="userName" required>
						</div>
						<div class="form-group">
							<input id="password_modal" type="password" placeholder="password"
								class="form-control" name="pWord" required>
						</div>
						<p class="text-center">
							<button class="btn btn-primary">
								<i class="fa fa-sign-in"></i> Log in
							</button>
						</p>
					</form>

					<form action="ServLogout" method="post">
						<p class="text-right">
							<button class="btn btn-primary">
								<i class="fa fa-sign-in"></i> Log out
							</button>
						</p>
					</form>
					<p class="text-center text-muted">Not registered yet?</p>
					<p class="text-center text-muted">
						<a href="ServRegister"><strong>Register now</strong></a>! It is
						easy and done in 1 minute and gives you access to special
						discounts and much more!
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- *** LOGIN MODAL END ***-->
	<div class="container">
	</div>
	<div class="container">
		<form method="post" action="ServAdmin">
			<input type="text" name="deleteTitle"> 
			<button type="submit">  </button>
		
		</form>
	
	</div>
	
	
	
	
	
	<c:forEach items="${recipes}" var="recipe">

			<div class="row">
				<div class="job-listing  ">
					<div class="col-sm-12 col-md-6">
						<div class="row">
							<div class="col-xs-2 col-sm-2 col-md-2">
								<form method="post" action="ServDetailPage">
									<input type="hidden">
									<h5 class="job__title">
										<a
											href="ServDetailPage?title=${recipe.title}&path=img/${recipe.title}.jpg">
											<c:out value=" ${recipe.title}"></c:out>
										</a>
									</h5>

								</form>




							</div>

						</div>
					</div>
					


				</div>
			</div>
		</c:forEach>

</body>
</html>