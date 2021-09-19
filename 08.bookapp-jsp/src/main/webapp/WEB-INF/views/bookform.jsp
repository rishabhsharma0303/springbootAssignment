<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add new Book</title>
</head>
<body>
<form:form action="addbook" modelAttribute="book">
	<form:hidden path="id" value="0"/><br/>
	Enter title: <form:input path="title"/><br/>
	Enter price: <form:input path="price"/><br/>
	<input type="submit">
</form:form>
</body>
</html>