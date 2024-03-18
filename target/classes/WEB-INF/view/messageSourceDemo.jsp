<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p> ${testMsg} </p>
<a href="?lang=en"><button><spring:message code="change.lang.btn.en"/></button></a>
<a href="?lang=fr"><button><spring:message code="change.lang.btn.fr"/></button></a>

</body>
</html>