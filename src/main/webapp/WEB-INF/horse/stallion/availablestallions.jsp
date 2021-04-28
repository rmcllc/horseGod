<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available Stallions</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Current Available Stallions</h1>
	<p><a href="/home" id="button">My Stable</a></p>
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
			<c:forEach items="${allStalls}" var="stallion">
			<tr>
				<td>${stallion.id}</td>
				<td>${stallion.height}</td>
				<td>${stallion.weight}</td>
				<td>${stallion.speed}</td>
				<td>${stallion.gait}</td>
				<td>${stallion.endurance}</td>
				<th><a href="/stallioninfo/${stallion.id}" id="button">More Info</a> | <a href="/stallionfarm/${stallion.id}" id="button">Select</a></th>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>