<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find a Mare</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Confirm Your Selection</h1>
	<div id="wrapper">
		<div>
		<form:errors path="stud.*"/>
			<h2>Your Stud</h2>
			<table class="selected">
				<tr>
					<th>ID</th>
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
	
			<h2>Broodmare</h2>
			<table class="selected">
				<tr>
					<th>ID</th>
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
					<th><a href="/findmare/${stud.id}" class="buttonX">CHANGE</a></th>
				</tr>
			</table>
	
			<form:form action="/hayroll/${studId}/${broodId}" method="post">
				<p>Confirmed Stud ID: ${studId}</p>
				<p>Confirmed Broodmare ID: ${broodId}</p>
				<button type="submit" value="Make Baby Horse" class="buttonX">Make Baby Horse</button>
			</form:form>
		</div>
	</div>
</body>
</html>