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
			<th>Title</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.type}</td>
				<td><a href="<c:url value="/bookDetails?bookid=${book.id}" />">Book details</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="<c:url value="/home" />">Go to homepage</a>

</body>
</html>