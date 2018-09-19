<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<title>SkyScanner</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
body {
	background-image:
		url("https://www.gspairport.com/site/user/images/airlines.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	background-attachment: fixed;
}

#signup {
	top: 38%;
	left: 35%;
}

#login {
	top: 36%;
	left: 25%;
}

#signup, #login {
	position: fixed;
	transition: 0.5s cubic-bezier(0.64, 0.35, 0.58, 1);
}

.login-signup {
	width: 400px;
	padding-bottom: 20px;
	background-color: rgba(251, 252, 252);
	border-radius: 20px;
}

input.field-input {
	width: 100%;
	background-color: rgba(2, 2, 2, 0.07);
	border: 1px solid rgba(0, 0, 0, 0.02);
	border-radius: 8px;
	padding: 8px;
	border-radius: 20px;
	margin-top: 12px;
	outline: 0;
}

.submit-btn {
	width: 100%;
	margin-top: 28px;
	text-align: center;
	padding: 8px 0 8px 0;
	border-radius: 20px;
	background-color: #5bc0de;
	color: #FFF;
	border: none;
	transition: 0.5s cubic-bezier(0.72, 0.15, 0.53, 0.84);
}

.s-atbottom {
	transform: translate3d(50px, -40px, 0);
	z-index: 0;
	-webkit-filter: blur(1px);
	filter: blur(1px);
	opacity: 0.6;
}

.s-attop {
	transform: translate3d(50px, -40px, 0);
	z-index: 1;
	-webkit-filter: blur(0);
	filter: blur(0);
	box-shadow: -5px 6px 48px -13px rgba(0, 0, 0, 0.75);
}

.l-attop {
	z-index: 1;
	-webkit-filter: blur(0);
	filter: blur(0);
	box-shadow: -5px 6px 48px -13px rgba(0, 0, 0, 0.75);
}

.l-atbottom {
	z-index: 0;
	-webkit-filter: blur(1px);
	filter: blur(1px);
	opacity: 0.6;
}
</style>
<script>
	$(document).ready(function() {

		$('#signup').on("click", function() {
			console.log('signup');
			var x = this.id;
			$("#" + x).removeClass("s-atbottom");
			$("#" + x).addClass("s-attop");
			$("#login").removeClass("l-attop");
			$("#login").addClass("l-atbottom");

		});

		$('#login').on("click", function() {
			console.log('login');
			var x = this.id;
			$("#" + x).removeClass("l-atbottom");
			$("#" + x).addClass("l-attop");
			$("#signup").removeClass("s-attop");
			$("#signup").addClass("s-atbottom");
		});
	}

	);
</script>
</head>
<body>
	<div class="">
		<div class="d-flex justify-content-center my-5">
			<h1 class="text-info font-weight-light">SkyScanner</h1>
		</div>
		<div class="login-signup l-attop" id="login">
			<h6 class="text-danger font-weight-light text-sm-center pt-3">
				<c:out value='${loginMessage}' />
			</h6>
			<form action="authenticate" method="post" autocomplete="off"
				class="mx-3">
				<input type="text" placeholder="Username" name="username" value=""
					class="field-input" required /> <input type="password"
					placeholder="Password" name="password" value="" class="field-input"
					required /> <input type="submit" class="submit-btn" value="Login">
			</form>
		</div>

		<div class="login-signup s-atbottom" id="signup">
			<h6 class="text-danger font-weight-light text-sm-center pt-3">
				<c:out value='${signupMessage}' />
			</h6>
			<form action="register" method="post" autocomplete="off" class="mx-3">
				<input type="text" placeholder="Username" name="username" value=""
					class="field-input" required /> <input type="password"
					placeholder="Password" name="password" value="" class="field-input"
					required /> <input type="password" placeholder="Confirm Password"
					name="confirmPassword" value="" class="field-input" required /> <input
					type="submit" class="submit-btn" value="Signup">
			</form>
		</div>
	</div>
</body>
</html>
