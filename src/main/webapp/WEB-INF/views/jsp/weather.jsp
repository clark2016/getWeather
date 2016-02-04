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
		<h1></h1>
		<p>
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				${cityName} <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">

				<c:forEach items="${citylist}" var="row">

					<li><a href="<c:out value="${row.key}"/>"><c:out
								value="${row.key}" /></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<table class="table">
		<tbody>
			<tr>
				<td>City</td>
				<td><c:if test="${not empty cityName}">
				${cityName}
			</c:if></td>
			</tr>
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

	<c:if test="${not empty errormsg}">
		<div class="alert alert-info">
			<strong>Message</strong> ${errormsg}
		</div>

	</c:if>

	<hr>
	<footer>
		<p>&copy; Clark 2016</p>
	</footer>
</div>
</body>
</html>