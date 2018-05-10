<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>List authors</title>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Address</th>
			<th>Phone number</th>
		</tr>
		<c:forEach items="${library_members}" var="libmember">
			<tr>
				<td>${libmember.id}</td>
				<td>${libmember.name}</td>
				<td>${libmember.surName}</td>
				<td>${libmember.address}</td>
				<td>${libmember.phoneNumber}</td>
				<td><a
					href="<c:url value="/editLibraryMember?libmemberid=${libmember.id}" />">Edit</a></td>
				<td><a
					href="<c:url value="/deleteLibraryMember?libmemberid=${libmember.id}" />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<a href="<c:url value="/home" />">Go to homepage</a>

</body>
</html>