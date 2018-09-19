<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Profile</title>
<style>
body {
	background-color: #BFDFEC;
	background-repeat: repeat-x;
	background-image: url("https://i.stack.imgur.com/b7z29.png");
	background-attachment: fixed;
	animation: movement 30s linear infinite;
}

@keyframes movement { 
0% {
	background-position: 0px 0px;
}

100% {
	background-position: 560px 0px;
}
}

.clock {
	opacity: 0.5;
}

.header {
	z-index: 10;
	background: inherit;
}

.content {
	width: 100%;
	z-index: 5;
	overflow: auto;
}

.input {
	height: 40px;
	outline: 0;
	padding: 8px;
	border: 0.01rem solid #ECF0F1;
	background-color: rgba(253, 254, 254, 0.8);
}

.logout-btn {
	height: 40px;
	width: 40px;
	background: rgba(253, 254, 254, 0.8)
		url('http://www.iconsalot.com/asset/icons/pixel-perfect/basic-icons/512/124-logout-icon.png');
	background-position: center;
	background-size: 50% 50%;
	background-repeat: no-repeat;
}

#search-btn {
	background: rgba(253, 254, 254, 0.8)
		url('https://cdn1.iconfinder.com/data/icons/hawcons/32/698627-icon-111-search-512.png');
	background-size: cover;
	background-position: center;
	height: 40px;
	width: 40px;
	border-radius: 0;
}

.flight-card {
	background: #ECF0F1;
	height: 150px;
	width: 100%;
	border-radius: 20px;
}

.flight-card-title {
	background: #7FB3D5;
	border-radius: 20px 0 0 20px;
	text-align: center;
	height: 100%;
}

.flight-card-content {
	display: flex;
	justify-content: space-between;
	align-items: center;
}
</style>
</head>
<body>
	<div class="d-flex justify-content-between p-3 sticky-top header">
		<h1 class="text-light font-weight-light">SkyScanner</h1>
		<div class="d-flex">
			<h3 class="text-light font-weight-light mx-4">
				Welcome
				<%
				out.print(session.getAttribute("username"));
			%>
			</h3>
			<a href="logout"><div class="logout-btn rounded-circle shadow"></div></a>
		</div>
	</div>
	<div class="content my-5">
		<div class="d-flex justify-content-center my-5">
			<form class="shadow-lg" action="search" method="post">
				<input class="input float-left" type="text" placeholder="From"
					name="departure" maxLength='3' minLength='3' autocomplete="off"
					required value="<c:out value="${searchCriteria.departure}" />"> <input class="input float-left" type="text"
					placeholder="To" name="arrival" maxLength='3' minLength='3'
					autocomplete="off" required> <input
					class="input float-left" type="date" name="travelDate" required>
				<select class="input float-left" name="travelClass">
					<option value="Economy">Economy</option>
					<option value="Business">Business</option>
				</select> <select class="input float-left" name="sortOrder">
					<option value="byFare">Sort by Fare</option>
					<option value="byBoth">Sort by Fare & Duration</option>
				</select> <input type="submit" id="search-btn" class="btn" value="">
			</form>
		</div>
		<div class="container">
			<h5 class="text-sm-center font-weight-light">
				<c:out value="${message}" />
			</h5>
			<c:forEach var="flight" items="${flights}">
				<div class="flight-card row mt-3 shadow">
					<div class="flight-card-title col-md-3 pt-4">
						<h1 class="text-light font-weight-light">
							<c:out value="${flight.flightNo}" />
						</h1>
						<h4 class="text-light font-weight-light">
							<c:out value="${flight.departure}" />
							<span>-</span>
							<c:out value="${flight.arrival}" />
						</h4>
					</div>
					<div class="flight-card-content col-md-9">
						<div class="">
							<h5 class="font-weight-light">Valid Till:</h5>
							<h2 class="text-info font-weight-light">
								<c:out value="${flight.validTill}" />
							</h2>
						</div>
						<div class="text-sm-center">
							<img src="https://image.flaticon.com/icons/png/512/1/1711.png"
								height=40 width=40 class="clock">
							<h4 class="font-weight-light">
								<c:out value="${flight.flightTime}" />
								Hrs
							</h4>
							<h6 class="font-weight-light">
								Duration:
								<c:out value="${flight.flightDuration}" />
							</h6>
						</div>
						<div class="text-sm-center">
							<h3 class="text-info font-weight-bold">
								Rs.
								<c:out value="${flight.fare}" />
								/-
							</h3>
							<h4 class="font-weight-light">
								<c:choose>
									<c:when test="${flight.flightClass=='EB'}">
								        Economy, Business
								    </c:when>
									<c:otherwise>
								        Economy
								    </c:otherwise>
								</c:choose>
							</h4>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>