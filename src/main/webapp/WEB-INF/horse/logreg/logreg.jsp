<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Horse Login and Registration</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div id="wrapper">
		<div>
	    <h1>Register!</h1>
	    
	    <p><form:errors path="user.*"/></p>
	    
	    <form:form method="POST" action="/registration" modelAttribute="user">
	    	<p>
	    		<form:label path="username">Create a Username:</form:label>
	            <form:input type="username" path="username"/>
	    	</p>
	    	<p>
	    		<form:label path="fname">First Name:</form:label>
	            <form:input type="fname" path="fname"/>
	    	</p>
	    	<p>
	    		<form:label path="lname">Last Name:</form:label>
	            <form:input type="lname" path="lname"/>
	    	</p>
	    	<p>
	    		<form:label path="state">State:</form:label>
	            <form:select path="state" class="select-box">
	            <form:option value="AL" label="Alabama"/>
	            <form:option value="AK" label="Alaska"/>
	            <form:option value="AZ" label="Arizona"/>
	            <form:option value="AR" label="Arkansas"/>
	            <form:option value="CA" label="California"/>
	            <form:option value="CO" label="Colorado"/>
	            <form:option value="CT" label="Connecticut"/>
	            <form:option value="DE" label="Deleware"/>
	            <form:option value="DC" label="District of Columbia"/>
	            <form:option value="FL" label="Florida"/>
	            <form:option value="GA" label="Georgia"/>
	            <form:option value="HI" label="Hawaii"/>
	            <form:option value="ID" label="Idaho"/>
	            <form:option value="IL" label="Illinois"/>
	            <form:option value="IN" label="Indiana"/>
	            <form:option value="IA" label="Iowa"/>
	            <form:option value="KS" label="Kansas"/>
	            <form:option value="KY" label="Kentucky"/>
	            <form:option value="LA" label="Louisianna"/>
	            <form:option value="ME" label="Maine"/>
	            <form:option value="MD" label="Maryland"/>
	            <form:option value="MA" label="Massachusetts"/>
	            <form:option value="MI" label="Michigan"/>
	            <form:option value="MN" label="Minnesota"/>
	            <form:option value="MS" label="Mississippi"/>
	            <form:option value="MO" label="Missouri"/>
	            <form:option value="MT" label="Montana"/>
	            <form:option value="NE" label="Nebraska"/>
	            <form:option value="NV" label="Nevada"/>
	            <form:option value="NH" label="New Hampshire"/>
	            <form:option value="NJ" label="New Jersey"/>
	            <form:option value="NM" label="New Mexico"/>
	            <form:option value="NY" label="New York"/>
	            <form:option value="NC" label="North Carolina"/>
	            <form:option value="ND" label="North Dakata"/>
	            <form:option value="OH" label="Ohio"/>
	            <form:option value="OK" label="Oklahoma"/>
	            <form:option value="OR" label="Oregon"/>
	            <form:option value="PA" label="Pennsylvania"/>
	            <form:option value="RI" label="Rhode Island"/>
	            <form:option value="SC" label="South Carolina"/>
	            <form:option value="SD" label="South Dakota"/>
	            <form:option value="TN" label="Tennessee"/>
	            <form:option value="TX" label="Texas"/>
	            <form:option value="UT" label="Utah"/>
	            <form:option value="VT" label="Vermont"/>
	            <form:option value="VA" label="Virginia"/>
	            <form:option value="WA" label="Washington"/>
	            <form:option value="WV" label="West Virginia"/>
	            <form:option value="WI" label="Wisconsin"/>
	            <form:option value="WY" label="Wyoming"/>
	            </form:select>
	    	</p>
	        <p>
	            <form:label path="zip">Zip Code:</form:label>
	            <form:input type="zip" path="zip"/>
	        </p>
	        <p>
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email"/>
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label>	
	            <form:password path="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation"/>
	        </p>
	        	<input type="submit" value="Register!" id="buttonX"/>
	    </form:form>
    </div>
    <div>
    	<p><form:errors path="user.*"/></p>
    	<c:if test="${logoutMessage != null}">
			<c:out value="${logoutMessage}"></c:out>
		</c:if>
    	<h1>Login!</h1>
    	<c:if test="${errorMessage != null}">
    		<p><c:out value="${errorMessage}"/></p>
    	</c:if>
    	<form method="post" action="/login">
	        <p>
	            <label for="username">Username:</label>
	            <input type="text" id="username" name="username"/>
	        </p>
	        <p>
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Login!" class="buttonX"/>
    	</form>
    </div>
	</div>
</body>
</html>