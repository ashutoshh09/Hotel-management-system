<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${name} Page</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
<%@include file="components/userbar.jsp" %>
<h2>Welcome ${name}</h2>
<a href="add"><button class="btn btn-warning">Book A Stay</button></a>

</body>
</html>