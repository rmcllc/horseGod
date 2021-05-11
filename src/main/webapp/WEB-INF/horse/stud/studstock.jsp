<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stud Stock</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Our Current Stud Stock</h1>
	<p><a href="/home" class="button">My Stable</a></p>
	<div>
		<table>
			<form:errors path="stud.*"/>
			<tr>
				<th>ID</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<c:forEach items="${allStuds}" var="stud">
			<tr>
				<form:form method="put" action="/findbrood/${stud.id}">
				<input type="hidden" name="_method" value="put">
				<td>${stud.id}</td>
				<td>${stud.height}</td>
				<input type="hidden" name="height" value="${stud.height}">
				<td>${stud.weight}</td>
				<input type="hidden" value="${stud.weight}">
				<td>${stud.speed}</td>
				<input type="hidden" value="${stud.speed}">
				<td>${stud.gait}</td>
				<input type="hidden" value="${stud.gait}">
				<td>${stud.endurance}</td>
				<input type="hidden" value="${stud.endurance}">
				<th><a href="/studinfo/${stud.id}" class="button">More Info</a> | <input type="submit" class="button" value="Select"/></th>
				</form:form>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>