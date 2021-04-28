<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filly Info</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Filly Stats</h1>
	<p><a href="/home" id="button">My Stable</a> | <a href="/allfillys" id="button">Available Fillies</a></p>
	<div>
		<h2>Filly ${filly.id} Report:</h2>
		<table>
			<tr>
				<th>Id</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
				<th>Owner</th>
			</tr>
			<tr>
			<form:errors path="filly.*"/>
			<form:form method="post" action="/fillycheckup/${filly.id}">
			<input type="hidden" name="_method" value="post">
				<td>${filly.id}</td>
				<td>${filly.height}</td>
				<input type="hidden" name="height" value="${filly.height}">
				<td>${filly.weight}</td>
				<input type="hidden" name="weight" value="${filly.weight}">
				<td>${filly.speed}</td>
				<input type="hidden" name="speed" value="${filly.speed}">
				<td>${filly.gait}</td>
				<input type="hidden" name="gait" value="${filly.gait}">
				<td>${filly.endurance}</td>
				<input type="hidden" name="endurance" value="${filly.endurance}">
				<td>${filly.user.fname} ${filly.user.lname}</td>
				<th><input type="submit" id="button" value="Make Mare"></th>
			</form:form>
			</tr>
		</table>
	</div>
</body>
</html>