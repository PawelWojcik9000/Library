<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
				<td><a href="<c:url value="/editAuthor?authorid=${author.id}" />">Edit</a></td>
				<td><a href="<c:url value="/deleteAuthor?authorid=${author.id}" />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="<c:url value="/home" />">Go to homepage</a>

</body>
</html>