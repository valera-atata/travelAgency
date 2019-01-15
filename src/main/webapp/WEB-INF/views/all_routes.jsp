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
</style>

</head>
<body>
	<h1 align="center">List of routes</h1>
	<table border="1">
		<tr>
			<th width="300">Id</th>
			<th width="300">Route</th>
			<th width="300">Country</th>
		</tr>
		<c:forEach items="${routes}" var="r">
			<tr>
				<td>${r.routeId}</td>
				<td>${r.route}</td>
				<td>${r.country}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>