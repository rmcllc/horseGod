<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mare Info</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Mare Statistics</h1>
	<p><a href="/home" class="button">My Stable</a></p>
	<div>
		<h2>Mare ${mare.id} Report:</h2>
		<table>
			<tr>
				<th>Id</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<tr>
				<td>${mare.id}</td>
				<td>${mare.height}</td>
				<td>${mare.weight}</td>
				<td>${mare.speed}</td>
				<td>${mare.gait}</td>
				<td>${mare.endurance}</td>
				<th><a href="/broodfarm/${mare.id}" class="button">Retire to Breeding Farm</a></th>
			</tr>
		</table>
	</div>
</body>
</html>