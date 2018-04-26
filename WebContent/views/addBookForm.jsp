<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author</title>
</head>
<body>

	<form action = "addBook" method = "POST">
         Book title: <input type = "text" name = "book_title"><br>
         Book type: <input type = "text" name = "book_type" /><br>
         Book available <input type = "checkbox" name = "book_available" value="true" /><br>
         Rent amount <input type = "number" name = "book_rent_amount" /><br>
         Returned to late <input type = "number" name = "book_returned_to_late" /><br>
         ISBN: <input type = "text" name = "book_isbn" /><br>
         Pages: <input type = "number" name = "book_pages" /><br>
         Published: <input type = "date" name = "book_published" /><br><br>
         <input type = "submit" value = "Add" />
      </form>

</body>
</html>