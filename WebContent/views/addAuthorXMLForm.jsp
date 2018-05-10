<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Add author</title>
</head>
<body>

	<form action="addAuthorXML" method="POST">
		<table>
			<tr>
				<th colspan="2">Add author</th>
			</tr>
			<tr>
				<td>Author Name:</td>
				<td><input type="text" name="author_name"></td>
			</tr>
			<tr>
				<td>Author Surname:</td>
				<td><input type="text" name="author_surname" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>

</body>
</html>