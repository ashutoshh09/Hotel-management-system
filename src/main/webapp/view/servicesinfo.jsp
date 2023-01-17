<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%@include file="components/generalbar.jsp" %>
	<!-- <a href="home"><button class="btn btn-primary ">Home</button></a>
	<a href="view"><button class="btn btn-success">Refresh</button></a>
 -->
	<!-- <div style="width: 1000px"> -->
	
	<div class="container mt-5">
		<table class="table table-striped table-bordered" style="width: 100%">
			<tr>
				<th>ID</th>
				<th>Service</th>
				<th>Description</th>
				<th>Contact</th>
		
			</tr>
			<c:forEach items="${b}" var="service">
				<tr>
					<td>${service.getId()}</td>
					<td>${service.getServicename()}</td>
					<td>${service.getServicedesc()}</td>
					<td>${service.getContact()}</td>
					

				</tr>


			</c:forEach>



		</table>
	</div>
	<!-- 	</div> -->

</body>
</html>