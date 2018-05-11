<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/style.css" />">
<title>List authors</title>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Surname</th>
		</tr>
		<c:forEach items="${authors}" var="author">
			<tr>
				<td>${author.id}</td>
				<td>${author.name}</td>
				<td>${author.surname}</td>
				<td><a
					href="<c:url value="/editAuthorXML?authorid=${author.id}" />">Edit</a></td>
				<td><a
					href="<c:url value="/deleteAuthorXML?authorid=${author.id}" />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<a href="<c:url value="/addAuthorXML" />">Add author to XML</a>

</body>
</html>