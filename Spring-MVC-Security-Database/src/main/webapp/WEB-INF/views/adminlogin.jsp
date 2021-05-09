<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin login</title>
</head>
<body>
	<h1> Admin Login </h1>

	<c:if test="${param.error != null}">
	   <i style="color:red"> Invalid Login or Password </i>	
	</c:if>

	<c:if test="${param.logout != null}">
	   <i style="color:red"> Logout successfull | Login again </i>	
	</c:if>

	<form:form><br>
	  Enter Username: <input type="text" name="username"><br><br>
	  Enter Password: <input type="password" name="password"><br><br>
	  			<input type="submit" value="Login">	<br><br>
	</form:form>
	
</body>
</html>