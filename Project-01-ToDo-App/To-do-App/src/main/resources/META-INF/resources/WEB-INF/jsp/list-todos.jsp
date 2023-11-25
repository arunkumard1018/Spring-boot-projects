<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage ToDos</title>
<link rel="stylesheet"	href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">

</head>

<body>
	<div class="container">
		<h2>Hello User youar'e To-Do's are</h2>
		<table class="table">
			<thead class="border border-5">
				<tr>
					<th>Task ID</th>
					<th>Task Description</th>
					<th>Target Date</th>
					<th>Status</th>
				</tr>
			</thead>
			<c:forEach items="${todos}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.description}</td>
					<td>${item.targetDate}</td>
					<td>${item.status}</td>

					<td><a href="delete-todo?id=${item.id}">
							<button type="button" class="btn btn-danger">Delete</button>
					</a></td>

					<td><a href="update-todo?id=${item.id}">
							<button type="button" class="btn btn-success">Update</button>
					</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="add-todo">
		<button type="button" class="btn btn-primary">Add Todo</button></a>
	</div>

	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
</body>

</html>