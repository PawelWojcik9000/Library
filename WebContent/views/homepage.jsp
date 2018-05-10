<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Library Home</title>
</head>
<body>

	<h1>Library</h1>

	<table>
		<tr>
			<td><a href="<c:url value="/addAuthor" />">Add new author</a></td>
			<td><a href="<c:url value="/listAuthors" />">Show authors</a><br></td>
		</tr>
		<tr>
			<td><a href="<c:url value="/addBook" />">Add new book</a></td>
			<td><a href="<c:url value="/listBooks" />">Show books</a><br></td>
		</tr>
		<tr>
			<td><a href="<c:url value="/addLibraryMember" />">Add new
					library member</a></td>
			<td><a href="<c:url value="/listLibraryMembers" />">Show
					library members</a><br></td>
		</tr>
	</table>

</body>
</html>