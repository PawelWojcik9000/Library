<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Add Author</title>
</head>
<body>

	<form action="editBook" method="POST">
		<table>
			<tr>
				<th colspan="2">Edit book</th>
			</tr>
			<tr>
				<td>Book title:</td>
				<td><input type="text" name="book_title" value="${book.title}" /></td>
			</tr>
			<tr>
				<td>Book type:</td>
				<td><input type="text" name="book_type" value="${book.type}" /></td>
			</tr>
			<tr>
				<td>Book available:</td>
				<td><input type="checkbox" name="book_available" value="true" /></td>
			</tr>
			<tr>
				<td>Rent amount:</td>
				<td><input type="number" name="book_rent_amount"
					value="${book.rentAmount}" /></td>
			</tr>
			<tr>
				<td>Returned to late:</td>
				<td><input type="number" name="book_returned_to_late"
					value="${book.returnedToLate}" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><input type="text" name="book_isbn" value="${book.ISBN}" /></td>
			</tr>
			<tr>
				<td>Pages:</td>
				<td><input type="number" name="book_pages"
					value="${book.pages}" /></td>
			</tr>
			<tr>
				<td>Published:</td>
				<td><input type="date" name="book_published"
					value="${book.published}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>