<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
   table {
    border: 1px solid green;
    margin: auto;
   }
   td {
    text-align: center;
   }
   .wrapper {
    text-align: center;
	}
</style>
</head>
<body>
	<h1 align="center">List of clients</h1>
	<hr />

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Surname</th>
			<th>Name</th>
			<th>Patron</th>
			<th>Passport</th>
			<th>Address</th>
			<th>Phone</th>
		</tr>
		<c:forEach items="${clients}" var="c">
			<tr>
				<td>${c.clientId}</td>
				<td>${c.surname}</td>
				<td>${c.name}</td>
				<td>${c.patron}</td>
				<td>${c.passport}</td>
				<td>${c.address}</td>
				<td>${c.phone}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="wrapper">
    	<form:form method="GET" action="${contextPath}/menu">
		<button type="submit" style="width: 300px;">Back to menu</button>
		</form:form>
	</div>
</body>
</html>