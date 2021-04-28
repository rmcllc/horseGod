<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Market Root</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div>
    	<p><form:errors path="user.*"/></p>
    	<c:if test="${errorMessage != null}">
    		<p><c:out value="${errorMessage}"/></p>
    	</c:if>
    	<form:form method="POST" action="/registration" modelAttribute="user">
	        <p>
	            <form:label path="username">Username</form:label>
	            <form:input path="username" name="username"/>
	        </p>
	        <p>
	            <form:label path="password">Password</form:label>
	            <form:input path="password" name="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation</form:label>
	            <form:input path="passwordConfirmation" name="passwordConfirmation"/>
	        </p>
	        <input type="submit" value="Register"/>
    	</form:form>
    </div>
</body>
</html>