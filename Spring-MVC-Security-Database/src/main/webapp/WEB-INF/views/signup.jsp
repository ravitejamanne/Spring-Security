<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Signup here</h1>

	<form:form action="signup-process" method="POST" modelAttribute="signup-pojo">
	Enter username:	<form:input path="username" />	<br><br>
	Enter password:	<form:password path="password" />	<br><br>
		<input type="submit" value="signup"/>	<br><br>
	</form:form>

</body>
</html>