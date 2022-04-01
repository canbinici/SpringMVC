<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Service</title>
<%@ include file="./header.jsp"%>
</head>
<body>
<div class="grid-container" align="center">
	<div  >
		<h1>Customer List</h1>

		<table border="1">
			<th>No</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Blood</th>
			<th>Telephone</th>
			<th>Address</th>

			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${customer.name}</td>
					<td>${customer.surname}</td>
					<td>${customer.blood}</td>
					<td>${customer.phone}</td>
					<td>${customer.adress}</td>
				</tr>
			</c:forEach>
		</table>
				<h3>
			<a href="new">New Customer</a>
		</h3>
	</div>
	</div>
</body>
<%@ include file="./footer.jsp"%>
</html>