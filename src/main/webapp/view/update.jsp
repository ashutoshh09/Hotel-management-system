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
		<h3 class="card-header">Update the Guest Details</h3>
		<table class="table table-striped table-bordered" style="width:100px">

			<s:form action="updatedValue" method="post" modelAttribute="b">
				<%-- <tr>
			
				<td>ID</td>
				<td><s:input path="id" value="${id}" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><s:input path="name" value="${name}" /></td>
			</tr>
			<tr>
				<td>Check_in</td>
				<td><s:input type="date" path="check_in" value="${check_in}" /></td>
			</tr>
			<tr>
				<td>Check_out</td>
				<td><s:input type="date" path="check_out" value="${check_out}" /></td>
			</tr>
			<tr>
				<td>Room</td>
				<td><s:input type="number" min="1" max="5" path="Room" value="${room}" /></td>
			</tr>
			<tr>
				<td>No.of Guest</td>
				<td><s:input type="number" min="1" max="10" path="nosguest" value="${nosguest}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr> --%>
				
				<div class="form-group">
				<input type="text" class="form-control" name="id" value="${id}"
						required />
				</div>
				
				<div class="form-group">
					<input type="text" class="form-control" name="name" value="${name}"
						required />
				</div>
				
				<div class="form-group">
					<input type="date" class="form-control" name="check_in"
						value="${check_in}" required />
				</div>
				<div class="form-group">
					<input type="date" class="form-control" name="check_out"
						value="${check_out}" placeholder="Enter Check out" required />
				</div>
				<div class="form-group">
					<input type="number" min="1" max="5" class="form-control"
						name="room" value="${room}" required />
				</div>
				<div class="form-group">
					<input type="number" min="1" max="10" class="form-control"
						name="nosguest" value="${nosguest}" required />
				</div>

				<div class="container text-center">
					<button class="btn btn-outline-success">Update Guest</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>


			</s:form>

		</table>
	</div>
	</div>
</body>
</html>



<%-- <form action="addGuest" method="post" modelAttribute="b">
						<div class="form-group">
							<input type="text" class="form-control" name="id" value="${Id}"
								 required />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="name" value="${name}"
								 required />
						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="check_in" value="${check_in}"
								 required />
						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="check_out" value="${check_out}"
								placeholder="Enter Check out" required />
						</div>
						<div class="form-group">
							<input type="number" min="1" max="5" class="form-control"
								name="room" value="${room}" required />
						</div>
						<div class="form-group">
							<input type="number" min="1" max="10" class="form-control"
								name="nosguest" value="${nosguest}" required />
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Update Guest</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
								</div></form> --%>