<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<p>Redirect Demo Example</p>
<p>Attribute from Model during the redirect (request parameters): ${param.testParam}</p>
<p>Attribute from Model during the forwarding (request attributes): ${requestScope.testParam}</p>

</body>
</html>