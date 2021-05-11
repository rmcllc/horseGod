<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find a Broodmare</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Find Your Broodmare</h1>
	<div>
		<h2>Your Stud</h2>
		
		<table class="selected">
			<tr>
				<th>Id</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<tr>
				<td>${stud.id}</td>
				<td>${stud.height}</td>
				<td>${stud.weight}</td>
				<td>${stud.speed}</td>
				<td>${stud.gait}</td>
				<td>${stud.endurance}</td>
				<th><a href="/allstuds" class="buttonX">CANCEL</a></th>
			</tr>
		</table>
	</div>
	<div>
		<h2>Select Your Broodmare</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${allBroods}" var="brood">
			<tr>
				<td>${brood.id}</td>
				<td>${brood.height}</td>
				<td>${brood.weight}</td>
				<td>${brood.speed}</td>
				<td>${brood.gait}</td>
				<td>${brood.endurance}</td>
				<th><a href="/broodmareinfo/${brood.id}" class="button">More Info</a> | <a href="/confirm/${stud.id}/${brood.id}" class="button">Select</a></th>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>