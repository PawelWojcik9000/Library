<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Book details</title>
</head>
<body>

	<table>
		<tr>
			<th>Title</th>
			<th>Type</th>
			<th>Authors</th>
			<th>Available</th>
			<th>Rent amount</th>
			<th>Returned to late</th>
			<th>ISBN</th>
			<th>Pages</th>
			<th>Published</th>
			<th>Edit book</th>
			<th>Delete book</th>
		</tr>
		<tr>
			<td>${book.title}</td>
			<td>${book.type}</td>
			<td><c:forEach items="${book.authors}" var="author">
						${author.name}
						${author.surname}
						<a href="<c:url value="/removeAuthorFromBook?bookid=${book.id}&authorid=${author.id}" />">Remove</a><br>
				</c:forEach></td>
			<td>${book.available}</td>
			<td>${book.rentAmount}</td>
			<td>${book.returnedToLate}</td>
			<td>${book.ISBN}</td>
			<td>${book.pages}</td>
			<td>${book.published}</td>
			<td><a href="<c:url value="/editBook?bookid=${book.id}" />">Edit</a></td>
			<td><a href="<c:url value="/deleteBook?bookid=${book.id}" />">Delete</a></td>
		</tr>
	</table><br><br>

	<form action="addBooksAuthors" method="POST">
		<table>
			<tr>
				<th>Add</th>
				<th>Author name</th>
				<th>Author surname</th>
			</tr>
			<c:forEach items="${authors}" var="author">
				<tr>
					<td>
						<input type="checkbox" value="${author.id}" name="author_id" />
						<input type="hidden" value="${book.id}" name="book_id" />
					</td>
					<td>${author.name}</td>
					<td>${author.surname}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form><br><br>



	<a href="<c:url value="/home" />">Go to homepage</a>

</body>
</html>