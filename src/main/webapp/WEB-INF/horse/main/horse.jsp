<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Horse Maker</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div id="wrapper">
		<div>
	    <h1>Horse Frame</h1>
	    <a href="/allstuds" class="button">View Available Studs</a>
	    <p><form:errors path="stud.*"/></p>
	    
	    <form:form method="PUT" action="/studify" modelAttribute="stud">
	    <h2>Stud Statistics</h2>
	    	<p>
	    		<form:label path="height">Height:</form:label>
	            
	            <form:input type="text" path="height"/>

	    	<p>
	    		<form:label path="weight">Weight:</form:label>

	            <form:input type="text" path="weight"/>
	    	</p>
	    	<p>
	    		<form:label path="speed">Speed:</form:label>

	            <form:input type="text" path="speed" />
	    	</p>
	        <p>
	            <form:label path="gait">Gait:</form:label>

	            <form:input type="text" path="gait"/>
	        </p>
	        <p>
	            <form:label path="endurance">Endurance:</form:label>
	
	            <form:input type="text" path="endurance"/>
	        </p>
	        <p></p>
	        	<input type="submit" value="create">
	    </form:form>
	    <p><form:errors path="broodmare.*"/></p>
	    
	    <form:form method="PUT" action="/marenheir" modelAttribute="broodmare">
	    <h2>Broodmare Statistics</h2>
	    	<p>
	    		<form:label path="height">Height:</form:label>
	    		
	            <form:input type="text" path="height"/>
	    	</p>
	    	<p>
	    		<form:label path="weight">Weight:</form:label>

	            <form:input type="text" path="weight"/>
	    	</p>
	    	<p>
	    		<form:label path="speed">Speed:</form:label>

	            <form:input type="text" path="speed"/>
	    	</p>
	        <p>
	            <form:label path="gait">Gait:</form:label>

	            <form:input type="text" path="gait"/>
	        </p>
	        <p>
	            <form:label path="endurance">Endurance:</form:label>
	
	            <form:input type="text" path="endurance"/>
	        </p>
	        <p></p>
	        	<input type="submit" value="create">
	        
	    </form:form>
	    </div>
	</div>
</body>
</html>