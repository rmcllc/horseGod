<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Stable</title>
<base href="/">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div id="wrapper">
		<div>
			<div id="header">
				<h1>Welcome ${currentUser.fname}</h1>
				<form id="logoutForm" method="POST" action="/logout">
			        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        <input type="submit" class="button_log" value="Logout"/>
			    </form>
			
			</div>

		<div>
	    <a href="/allstallions" class="button">View Available Stallions</a>
	    <a href="/allmares" class="button">View Available Mares</a>
	    <a href="/allstuds" class="button">View Available Studs</a>
	    <a href="/allbroods" class="button">View Available Broodmares</a>
	    <h2>Your Stable</h2>
	    	<h2>Stallions</h2>
	    	<table>
	    		<tr>
	    			<th>Stallion</th>
		    		<th>ID</th>
		    		<th>Height</th>
		    		<th>Weight</th>
		    		<th>Speed</th>
		    		<th>Gait</th>
		    		<th>Endurance</th>
	    		</tr>
	    		<c:forEach items="${allStalls}" var="stallion">
	    		<tr>
	    			<td><a href="/stallion/${stallion.id}" class="buttonX">More Info</a></td>
	    			<td>${stallion.id}</td>
	    			<td>${stallion.height}</td>
	    			<td>${stallion.weight}</td>
	    			<td>${stallion.speed}</td>
	    			<td>${stallion.gait}</td>
	    			<td>${stallion.endurance}</td>
	    		</tr>
	    		</c:forEach>
	    	</table>
	    	<h2>Mares</h2>
	    	<table>
	    		<tr>
	    			<th>Mare</th>
		    		<th>ID</th>
		    		<th>Height</th>
		    		<th>Weight</th>
		    		<th>Speed</th>
		    		<th>Gait</th>
		    		<th>Endurance</th>
	    		</tr>
	    		<c:forEach items="${allMares}" var="mare">
	    		<tr>
	    			<td><a href="/mareinfo/${mare.id}" class="buttonX">More Info</a></td>
	    			<td>${mare.id}</td>
	    			<td>${mare.height}</td>
	    			<td>${mare.weight}</td>
	    			<td>${mare.speed}</td>
	    			<td>${mare.gait}</td>
	    			<td>${mare.endurance}</td>
	    		</tr>
	    		</c:forEach>
	    	</table>
	    	<h2>Studs</h2>
	    	<table>
	    		<tr>
	    			<th>Stud</th>
		    		<th>ID</th>
		    		<th>Height</th>
		    		<th>Weight</th>
		    		<th>Speed</th>
		    		<th>Gait</th>
		    		<th>Endurance</th>
	    		</tr>
	    		<c:forEach items="${allStuds}" var="stud">
	    		<tr>
	    			<td><a href="/studinfo/${stud.id}" class="buttonX">More Info</a></td>
	    			<td>${stud.id}</td>
	    			<td>${stud.height}</td>
	    			<td>${stud.weight}</td>
	    			<td>${stud.speed}</td>
	    			<td>${stud.gait}</td>
	    			<td>${stud.endurance}</td>
	    		</tr>
	    		</c:forEach>
	    	</table>
	    	<h2>Broodmares</h2>
	    	<table>
	    		<tr>
	    			<th>Broodmare</th>
		    		<th>ID</th>
		    		<th>Height</th>
		    		<th>Weight</th>
		    		<th>Speed</th>
		    		<th>Gait</th>
		    		<th>Endurance</th>
	    		</tr>
	    		<c:forEach items="${allBroods}" var="brood">
	    		<tr>
	    			<td><a href="/broodinfo/${brood.id}" class="buttonX">More Info</a></td>
	    			<td>${brood.id}</td>
	    			<td>${brood.height}</td>
	    			<td>${brood.weight}</td>
	    			<td>${brood.speed}</td>
	    			<td>${brood.gait}</td>
	    			<td>${brood.endurance}</td>
	    		</tr>
	    		</c:forEach>
	    	</table>
		</div>
		</div>
	</div>
</body>
</html>