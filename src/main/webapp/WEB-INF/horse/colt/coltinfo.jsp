<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colt Info</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<h1>Colt Stats</h1>
	<p><a href="/home" id="button">My Stable</a> | <a href="/allcolts" id="button">Available Colts</a></p>
	<div>
		<h2>Colt ${colt.id} Report:</h2>
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
			<form:errors path="colt.*"/>
			<form:form method="post" action="/coltcheckup/${colt.id}">
			<input type="hidden" name="_method" value="post">
				<td>${colt.id}</td>
				<td>${colt.height}</td>
				<input type="hidden" name="height" value="${colt.height}">
				<td>${colt.weight}</td>
				<input type="hidden" name="weight" value="${colt.weight}">
				<td>${colt.speed}</td>
				<input type="hidden" name="speed" value="${colt.speed}">
				<td>${colt.gait}</td>
				<input type="hidden" name="gait" value="${colt.gait}">
				<td>${colt.endurance}</td>
				<input type="hidden" name="endurance" value="${colt.endurance}">
				<td>${colt.user.fname} ${colt.user.lname}</td>
				<th><input type="submit" id="button" value="Make Stallion"></th>
			</form:form>
			</tr>
		</table>
	</div>
	<div id="traitBox">
		<c:forEach items="" var="colt">
		<div>
			<table>
				<tr>
					<td>Trait</td>
				</tr>
				<tr>
					<td>Horse Trait Here</td>
				</tr>
			</table>		
		</div>
		</c:forEach>
	</div>
</body>
</html>