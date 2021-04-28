<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<div>
		<h1>${user.username}</h1>
		<p><form:errors path="user.*"/></p>
	    
	    <form:form method="put" action="/edit/${user.id}" modelAttribute="user">
	    	<input type="hidden" name="_method" value="put">
	    	<p>
	    		<form:label path="username">Username:</form:label>
	            <form:input path="username" name="username" value="${username}"/>
	        </p>
	    	<p>
	    		<form:label path="password">Password:</form:label>
	            <form:input path="password" name="password" value=""/>
	        </p>
			<p>
				<input type="submit" value="Update"/>
			</p>
	    </form:form>
	    <a href="/admin">---Back</a>
	</div>
</body>
</html>