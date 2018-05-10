<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Add library member</title>
</head>
<body>

	<form action="editLibraryMember" method="POST">
		<table>
			<tr>
				<th colspan="2">Add library members</th>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"
					value="${libraryMember.name}" /></td>
			</tr>
			<tr>
				<td>Surname:</td>
				<td><input type="text" name="surname"
					value="${libraryMember.surName}" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="${libraryMember.address}" /></td>
			</tr>
			<tr>
				<td>Phone number:</td>
				<td><input type="text" name="phone_number"
					value="${libraryMember.phoneNumber}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>