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
	<h1 align="center">List of tours</h1>
	<div class="wrapper">
    	<form:form method="POST" action="${contextPath}/add_tour">
			<button type="submit" style="width: 300px;">Add tour</button>
		</form:form>
	</div>
		
	<hr />

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Organizer</th>
			<th>Date</th>
			<th>Type</th>
			<th>Cost</th>
			<th>Country</th>
			<th>Route</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${tours}" var="t">
		
			<c:url var="updateLink" value="/edit_tour">
				<c:param name="tourId" value="${t.tourId}" />
			</c:url>

			<c:url var="deleteLink" value="/delete_tour">
				<c:param name="tourId" value="${t.tourId}" />
			</c:url>
			<tr>
				<td>${t.tourId}</td>
				<td>${t.organizer}</td>
				<td>${t.date}</td>
				<td>${t.type}</td>
				<td>${t.cost}</td>
				<td>${t.route.country}</td>
				<td>${t.route.route}</td>
				
				<td>
					<form:form method="POST" action="${updateLink}">
						<button type="submit" value=>Edit</button>
					</form:form>
				</td>
				<td>
					<form:form method="POST" action="${deleteLink}">
						<button type="submit">Delete</button>
					</form:form>
				</td>
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