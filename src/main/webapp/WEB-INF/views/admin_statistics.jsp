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
	<h1 align="center">Sum of contracts</h1>
	<table border="1">
		<tr>
			<th width="150">Id</th>
			<th width="150">Agent`s surname</th>
			<th width="150">Agent`s name</th>
			<th width="150">Agent`s patronymic</th>
			<th width="150">Number of clients</th>
			<th width="150">Number of contracts</th>
			<th width="150">Earnings</th>
		</tr>
		<c:forEach items="${agents}" var="a">
			<tr>
				<td>${a[0]}</td>
				<td>${a[1]}</td>
				<td>${a[2]}</td>
				<td>${a[3]}</td>
				<td>${a[4]}</td>
				<td>${a[5]}</td>
				<td>${a[6]}</td>
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