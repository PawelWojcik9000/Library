<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Add book</title>
</head>
<body>

	<form action="addBook" method="POST">
		<table>
			<tr>
				<th colspan="2">Add book</th>
			</tr>
			<tr>
				<td>Book title:</td>
				<td><input type="text" name="book_title"></td>
			</tr>
			<tr>
				<td>Book type:</td>
				<td><input type="text" name="book_type" /></td>
			</tr>
			<tr>
				<td>Book available:</td>
				<td><input type="checkbox" name="book_available" value="true" /></td>
			</tr>
			<tr>
				<td>Rent amount:</td>
				<td><input type="number" name="book_rent_amount" /></td>
			</tr>
			<tr>
				<td>Returned to late:</td>
				<td><input type="number" name="book_returned_to_late" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><input type="text" name="book_isbn" /></td>
			</tr>
			<tr>
				<td>Pages:</td>
				<td><input type="number" name="book_pages" /></td>
			</tr>
			<tr>
				<td>Published:</td>
				<td><input type="date" name="book_published" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>

</body>
</html>