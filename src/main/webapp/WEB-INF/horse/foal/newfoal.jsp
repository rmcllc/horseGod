<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meet Your New Foal</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div>
	<h1>The Baby Barn</h1>
	<a href="/home" class="button">Visit Stable</a>
		<h2>Your Foal</h2>
		<table id="selected">
			<tr>
				<th>Foal Id</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<tr>
				<th>${foal.id}</th>
				<th>${foal.height}</th>
				<th>${foal.weight}</th>
				<th>${foal.speed}</th>
				<th>${foal.gait}</th>
				<th>${foal.endurance}</th>
			</tr>

		</table>
		<table>
			<tr>
				<th>Sire</th>
			</tr>
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
			</tr>
		</table>
		<table>
			<tr>
				<th>Dam</th>
			</tr>
			<tr>
				<th>Id</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Speed</th>
				<th>Gait</th>
				<th>Endurance</th>
			</tr>
			<tr>
				<td>${brood.id}</td>
				<td>${brood.height}</td>
				<td>${brood.weight}</td>
				<td>${brood.speed}</td>
				<td>${brood.gait}</td>
				<td>${brood.endurance}</td>
			</tr>
		</table>
	</div>
</body>
</html>