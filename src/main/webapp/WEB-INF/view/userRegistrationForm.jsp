<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <form:form action="create-user" modelAttribute="user" method="POST">  
        <p>First name: <form:input path="firstName" /></p>
        <p>Last name: <form:input path="lastName" /></p>
        <p>Email: <form:input path="email" /></p>
        <p>Password: <form:password path="password" /></p>
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>