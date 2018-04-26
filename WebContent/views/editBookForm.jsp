<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author</title>
</head>
<body>

	<form action = "editBook" method = "POST">
         New Book title: <input type = "text" name = "book_title"><br>
         New Book type: <input type = "text" name = "book_type" /><br>
         New Book available <input type = "checkbox" name = "book_available" value="true" /><br>
         New Rent amount <input type = "number" name = "book_rent_amount" /><br>
         New Returned to late <input type = "number" name = "book_returned_to_late" /><br>
         New ISBN: <input type = "text" name = "book_isbn" /><br>
         New Pages: <input type = "number" name = "book_pages" /><br>
         New Published: <input type = "date" name = "book_published" /><br><br>
         <input type = "submit" value = "Edit" />
      </form>

</body>
</html>