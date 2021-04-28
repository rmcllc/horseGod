<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<c:if test="${logoutMessage != null}">
			<c:out value="${logoutMessage}"></c:out>
		</c:if>
    	<h1>Login</h1>
    	<c:if test="${errorMessage != null}">
    		<p><c:out value="${errorMessage}"/></p>
    	</c:if>
    	<form method="POST" action="/login">
	        <p>
	            <label for="username">Username</label>
	            <input type="text" id="username" name="username"/>
	        </p>
	        <p>
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Login!"/>
    	</form>
    </div>
</body>
</html>