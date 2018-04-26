<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Home</title>
</head>
<body>

	<h1>Library</h1>
	
	<a href="<c:url value="/addAuthor" />">Add new author</a>
	<a href="<c:url value="/listAuthors" />">Show authors</a><br>
	<a href="<c:url value="/addBook" />">Add new book</a>
	<a href="<c:url value="/listBooks" />">Show books</a>

</body>
</html>