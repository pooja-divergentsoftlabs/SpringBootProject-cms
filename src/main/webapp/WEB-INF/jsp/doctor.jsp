<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor</title>


<script src="static/js/bootstrap.min.js"></script>
<link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="doc"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Doctor Add</legend>
								
								

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="fees">Fees</label>
									<div class="col-md-4">
										<input id="fees" name="fees" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>


								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info"
											value="Add Doctor">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
					<legend>Doctor List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">							
							<thead>
								<tr>
									
									<th>Name</th>
									<th>Fees</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allDoctors}" var="doctor">
									<tr>
										
										<td><c:out value="${doctor.name}" /></td>
										<td><c:out value="${doctor.fees}" /></td>
										<td><a href="doc/remove?doctorId=${doctor.id}"
											class="btn btn-danger" type="button">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>