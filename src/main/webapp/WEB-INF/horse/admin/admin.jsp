<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
    <h1>Welcome to the Admin Page <c:out value="${currentUser.username}"></c:out></h1>
    <a href="/home" class="button">Go to Dashboard</a>
    <table>
    	<h3>All Users</h3>
    	<tr>
    		<th>Username</th>
    		<th>Created On</th>
    		<th>Updated At</th>
    		<th>Role</th>
    	</tr>
    	<c:forEach items="${allUsers}" var="user">
    	<tr>
    		<td>${user.username}</td>
    		<td>${user.createdAt}</td>
    		<td>${user.updatedAt}</td>
    		<td>${user.roles}</td>
    		<td><form action="/destroy/${user.id}" class="button" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete"/>
			</form></td>
			<td><a href="/edituser/${user.id}" class="button">Edit</a></td>
    	</tr>	
    	</c:forEach>
    	
    </table>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout" />
    </form>
    
</body>
</html>