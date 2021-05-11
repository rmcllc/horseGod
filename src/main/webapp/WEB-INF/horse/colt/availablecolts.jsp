<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available Colts</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Currently Available Colts</h1>
	<p><a href="/home" class="button">My Stable</a></p>
	<div>
		<table>
			<c:forEach items="${allColts}" var="colt">
			<tr>
				<th>ID</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<tr>
				<td>${colt.id}</td>
				<td>${colt.height}</td>
				<td>${colt.weight}</td>
				<td>${colt.speed}</td>
				<td>${colt.gait}</td>
				<td>${colt.endurance}</td>
				<td><a href="/colt/${colt.id}" class="buttonX">More Info</a> | <a href="/coltselected/${colt.id}" class="buttonX">Select</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>