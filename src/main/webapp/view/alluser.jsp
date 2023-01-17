<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<!-- <h1>Below List Of Users Available!!!</h1> -->
	<%@include file="components/generalbar.jsp" %>
	<!-- <a href="home"><button class="btn btn-primary ">Home</button></a>
	<a href="view"><button class="btn btn-success">Refresh</button></a>
 -->
	<!-- <div style="width: 1000px"> -->
	
	<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>The user has been deleted : ${msg}</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
	
	<div class="container mt-3">
		<table class="table table-striped table-bordered" style="width: 100%">
			<tr>
				<th>ID</th>
				<th>User Name</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Password</th>
				<th>Address</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${b}" var="user">
				<tr>
					<td>${user.getId()}</td>
					<td>${user.getName()}</td>
					<td>${user.getMobile()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getPassword()}</td>
					<td>${user.getAddress()}</td>
<%-- 					<td>${user.getTimestamp()}</td>
 --%>					<td><a
						href="updateuser?id=${user.getId()}&name=${user.getName()}&mobile=${user.getMobile()}&email=${user.getEmail()}&password=${user.getPassword()}&address=${user.getAddress()}"><button
								type="button" class="btn btn-outline-primary">Update</button></a></td>
					<td><a href="deleteuser?id=${user.getId()}"><button
								type="button" class="btn btn-outline-danger">Delete</button></a></td>


				</tr>


			</c:forEach>



		</table>
	</div>
	<!-- 	</div> -->

</body>
</html>