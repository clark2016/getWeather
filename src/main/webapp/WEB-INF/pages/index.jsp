<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Get Current Weather</title>
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery.min.js" var="jqueryMinJs" />
<script src="${jqueryMinJs}"></script>
<script src="${bootstrapJs}"></script>

</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Get Current Weather</a>
		</div>
	</div>
</nav>
<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<p>
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Choose a city <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="index.jsp?dcd=01">Sydney</a></li>
				<li><a href="index.jsp?dcd=02">Melbourne</a></li>
				<li><a href="index.jsp?dcd=03">Wollongong</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>City</th>
				<th><c:if test="${not empty cityName}">
				${cityName}
			</c:if></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Updated time</td>
				<td><c:if test="${not empty updatedTime}">
				${updatedTime}
			</c:if></td>
			</tr>
			<tr>
				<td>Weather</td>
				<td><c:if test="${not empty weather}">
				${weather}
			</c:if></td>
			</tr>
			<tr>
				<td>Temperature</td>
				<td><c:if test="${not empty temperature}">
				${temperature}
			</c:if></td>
			</tr>
			<tr>
				<td>Wind</td>
				<td><c:if test="${not empty wind}">
				${wind}
			</c:if></td>
			</tr>
		</tbody>
	</table>
	<hr>
	<footer>
		<p>&copy; Clark 2016</p>
	</footer>
</div>
</body>
</html>