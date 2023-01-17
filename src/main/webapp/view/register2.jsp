<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<%@include file="components/common_css_js.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid">

		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<%@include file="components/message.jsp"%>
					<div class="card-body px-5">
						<div class="container text-center">
							<img style="max-width: 90px" class="img-fluid rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/1208/1208635.png"
								alt="sign_up" />
						</div>
						<h3 class="text-center my-3">Sign up here!!</h3>
						<form action="./registeruser" method="post" modelAttribute="b">
							<div class="form-group">
								<label for="name">User Name</label> <input name="name"
									type="text" class="form-control" id="name"
									aria-describedby="emailHelp" placeholder="Enter here">
							</div>

							<div class="form-group">
								<label for="email">User Email</label> <input name="email"
									type="email" class="form-control" id="email"
									aria-describedby="emailHelp" placeholder="Enter here">
							</div>
							<div class="form-group">
								<label for="password">User Password</label> <input
									name="password" type="password" class="form-control"
									id="password" aria-describedby="emailHelp"
									placeholder="Enter here">
							</div>
							<div class="form-group">
								<label for="mobile">User Phone</label> <input name="mobile"
									type="mobile" class="form-control" id="mobile"
									aria-describedby="emailHelp" placeholder="Enter here">
							</div>
							<div class="form-group">
								<label for="address">User Address</label>
								<textarea name="address" style="height: 200px"
									class="form-control" id="address" aria-describedby="emailHelp"
									placeholder="Enter here"></textarea>
							</div>

							<div class="container text-center">
								<button class="btn btn-outline-success">Register</button>
								<button class="btn btn-outline-warning">Reset</button>

							</div>
						</form>

					</div>
				</div>

			</div>
		</div>

	</div>

</body>
</html>