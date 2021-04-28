<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available Mares</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Current Available Mares</h1>
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
			<c:forEach items="${allMares}" var="mare">
			<tr>
				<td>${mare.id}</td>
				<td>${mare.height}</td>
				<td>${mare.weight}</td>
				<td>${mare.speed}</td>
				<td>${mare.gait}</td>
				<td>${mare.endurance}</td>
				<th><a href="/mareinfo/${mare.id}" id="button">More Info</a> | <a href="/marefarm/${mare.id}" id="button">Select</a></th>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>