<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="components/generalbar.jsp"%>

	
	
	
	<div class="card">


	<div class="container text-center">
		<h3 class="card-header">Update the User Details</h3>
		<table class="table table-striped table-bordered" style="width:100px">

			<s:form action="updatedUserValue" method="post" modelAttribute="b">
			
				
				<div class="form-group">
				<input type="text" class="form-control" name="id" value="${id}"
						required />
				</div>
				
				<div class="form-group">
					<input type="text" class="form-control" name="name" value="${name}"
						required />
				</div>
				
				<div class="form-group">
					<input type="number" class="form-control" name="mobile"
						value="${mobile}" required />
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="email"
						value="${email}" placeholder="Enter Check out" required />
				</div>
				<div class="form-group">
					<input type="text" class="form-control"
						name="password" value="${password}" required />
				</div>
				<div class="form-group">
					<input type="text" min="1" max="10" class="form-control"
						name="address" value="${address}" required />
				</div>

				<div class="container text-center">
					<button class="btn btn-outline-success">Update User</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>


			</s:form>

		</table>
	</div>
	</div>
	<%-- <table>
		<s:form action="updatedUserValue" method="post" modelAttribute="b">
			<tr>
				<td>ID</td>
				<td><s:input path="id" value="${id}" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><s:input path="name" value="${name}" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><s:input path="mobile" value="${mobile}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><s:input  path="email" value="${email}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:input  path="password" value="${password}" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><s:input path="address" value="${address}" /></td>
			</tr>
			<tr>
				<td>Time</td>
				<td><s:input path="timestamp" value="${timestamp}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>



		</s:form>

	</table> --%>
</body>
</html>