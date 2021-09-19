<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>spring boot jsp crud app</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>book id</th>
				<th>book title</th>
				<th>book price</th>
				<th>edit</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td><a href="deletebook?id=<c:out value="${book.id}"/>">delete</a></td>
					<td><a href="updatebook?id=<c:out value="${book.id}"/>">update</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="addbook">add new book</a>
</body>
</html>