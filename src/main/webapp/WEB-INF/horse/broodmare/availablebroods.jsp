<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available Broodmares</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Current Available Broodmares</h1>
	<p><a href="/home" class="button">My Stable</a></p>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<c:forEach items="${allBroods}" var="brood">
			<tr>
				<td>${brood.id}</td>
				<td>${brood.height}</td>
				<td>${brood.weight}</td>
				<td>${brood.speed}</td>
				<td>${brood.gait}</td>
				<td>${brood.endurance}</td>
				<th><a href="/broodmareinfo/${brood.id}" class="button">More Info</a></th>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>