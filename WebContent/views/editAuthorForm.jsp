<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author</title>
</head>
<body>

	<form action = "editAuthor" method = "POST">
         New author Name: <input type = "text" name = "author_name"><br>
         New author Surname: <input type = "text" name = "author_surname" /><br>
         <input type = "submit" value = "Edit" />
      </form>

</body>
</html>