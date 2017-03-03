<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ben.daos.RecipeDao"%>
<%@ page import="edu.ben.models.Recipe"%>
<%@ page import="edu.ben.servlets.ServSearchRecipe"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
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
					<li>
						
						<%out.println((request.getSession().getAttribute("userName")));%>
						
					
					
					</li>
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
	<section class="job-form-section job-form-section--image">

	<div class="container">

		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<div class="job-form-box">
					<h2 class="heading">
						Find a <span class="accent">Recipe</span> you will <span
							class="accent">love</span>.
					</h2>
					<form id="job-main-form" method="post" action="ServSearchRecipe"
						class="job-main-form">
						<div class="controls">
							<div class="row">
								<div class="col-sm-5">
									<div class="form-group">
										<label >Ethnicity</label> <input type="text"
											id="ethnicity" name="ethnicity"
											placeholder="Italian, Mexican, American..."
											class="form-control" required>
									</div>
								</div>
								<div class="col-sm-5">
									<div class="form-group">
										<label >Cook Time</label> <input type="text"
											id="cooktime" name="cooktime"
											placeholder="30, 45, 60 in mintues" class="form-control required">
									</div>
								</div>
								<div class="col-sm-2">
									<button type="submit" name="submit"
										class="btn btn-primary job-main-form__button">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	
	<%
		RecipeDao rDao = new RecipeDao();
		LinkedList<Recipe> recipeList = rDao.displayRecipe();
		int index = 0;
		int recipeCount = 0;
	%>
	<%
		while (recipeCount < 3) {
	%>
	
	
	<section style="background: #fafafa;">
	<div class="container">
		<h3 class="heading">Featured Recipes</h3>
		<div class="row featured same-height-row">
			<div class="col-md-4">
				<div class="box-image-text bg-visible same-height">
					<div class="top">
						<a href="#">
							
							
						</a>
					</div>
					<div class="content">
						<h5>
							<a ><%out.println(recipeList.get(index).getTitle());%></a>
						</h5>
						<p class="featured__details">
							
						
						<p><%
 	out.println(recipeList.get(index++).getRecipeFile());
 %></p>
 <%recipeCount++; %>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="box-image-text bg-visible same-height">
					<div class="top">
						<a href="#">
							
							
						</a>
					</div>
					<div class="content">
						<h5>
							<a><%out.println(recipeList.get(index).getTitle());%></a>
						</h5>
						<p class="featured__details">
							
						<p><%
 	out.println(recipeList.get(index++).getRecipeFile());
 %></p>
 <%recipeCount++; %>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="box-image-text bg-visible same-height">
					<div class="top">
						<a href="#">
							
							
						</a>
					</div>
					<div class="content">
						<h5>
							<a><%out.println(recipeList.get(index).getTitle());%></a>
						</h5>
						<p class="featured__details">
							
								
						
						<p><%
 	out.println(recipeList.get(index).getRecipeFile());
 %></p>
 <%recipeCount++; %>
					</div>
				</div>
			</div>
		</div>
		<div class="row text-center margin-top">
			<a href="ServCategory" class="btn btn-ghost">See more Recipes</a>
		</div>
	</div>
	</section>
	<%
		index++;
		}
	%>
	

	<footer class="footer">
	<div class="footer__block">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<h4>About CookBook</h4>
					<p>
						CookBook is a <strong>social recipe sharing website</strong>
						developed by Frank Rooks, Ian Birkholz, Raza Mohammed, and Gerald
						Valenzula
					</p>
					<p>This sight was built to offer a place where you can look at
						and share different recipes.</p>
				</div>
				<div class="col-md-4 col-sm-6">
					<h4>Pages</h4>
					<ul>
						<li><a href="ServHome">Home</a></li>
						<li><a href="ServCategory">Recipes</a></li>
						<li><a href="ServAddRecipe">Add Recipe</a></li>
						<li><a href="ServContact">Contact</a></li>

					</ul>
				</div>
				<div class="col-md-4 col-sm-6">
				<h4>Let's be Friends</h4>
				<!-- <p class="social"><a href="https://www.facebook.com/" data-animate-hover="pulse" class="external facebook"><i class="fa fa-facebook"></i></a><a href="#" data-animate-hover="pulse" class="external gplus"><i class="fa fa-google-plus"></i></a><a href="#" data-animate-hover="pulse" class="external twitter"><i class="fa fa-twitter"></i></a><a href="#" data-animate-hover="pulse" class="email"><i class="fa fa-envelope"></i></a></p>-->
				<div class="fb-share-button"
					data-href="http://localhost:8080/CookBook/ServHome"
					data-layout="button" data-size="small" data-mobile-iframe="true">
					<a class="fb-xfbml-parse-ignore" target="_blank"
						href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8080%2FCookBook%2FServHome&amp;src=sdkpreparse">Share</a>
				</div>
			</div>

			</div>

			
			<div class="col-md-4 col-sm-12">
			
		</div>
	</div>
	</div>
	<div class="footer__copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<p>&copy;2016 The Amateur Developers</p>
				</div>
				<div class="col-md-6"></div>
			</div>
		</div>
	</div>
	</footer>
	
	<!-- Javascript files-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document.write(
						'<script src="js/jquery-1.11.0.min.js"><\/script>')
	</script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/jquery.cookie.js">
		
	</script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/front.js"></script>
	<!-- Google Analytics: change UA-XXXXX-X to be your site's ID.-->
	<!---->
	<script>
		(function(b, o, i, l, e, r) {
					b.GoogleAnalyticsObject = l;
					b[l] || (b[l] = function() {
						(b[l].q = b[l].q || []).push(arguments)
					});
					b[l].l = +new Date;
					e = o.createElement(i);
					r = o.getElementsByTagName(i)[0];
					e.src = '//www.google-analytics.com/analytics.js';
					r.parentNode.insertBefore(e, r)
				}(window, document, 'script', 'ga'));
		ga('create', 'UA-XXXXX-X');
		ga('send', 'pageview');
	</script>
</body>
</html>

