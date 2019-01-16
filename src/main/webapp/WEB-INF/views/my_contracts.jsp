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
	<h1 align="center">List of contracts</h1>
	<hr />

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Date</th>
			<th>Agent's surname</th>
			<th>Agent's name</th>
			<th>Agent's patronymic</th>
			<th>Client's surname</th>
			<th>Client's name</th>
			<th>Client's patronymic</th>
			<th>Tour organizer</th>
			<th>Tour date</th>
			<th>Tour type</th>
			<th>Tour cost</th>
			<th>Country</th>
			<th>Route</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${myContracts}" var="c">
		
			<c:url var="updateLink" value="/user/edit_contract">
				<c:param name="contractId" value="${c.contractId}" />
			</c:url>

			<c:url var="deleteLink" value="/user/delete_contract">
				<c:param name="contractId" value="${c.contractId}" />
			</c:url>
			<tr>
				<td>${c.contractId}</td>
				<td>${c.date}</td>
				<td>${c.agent.surname}</td>
				<td>${c.agent.name}</td>
				<td>${c.agent.patron}</td>
				<td>${c.client.surname}</td>
				<td>${c.client.name}</td>
				<td>${c.client.patron}</td>
				<td>${c.tour.organizer}</td>
				<td>${c.tour.date}</td>
				<td>${c.tour.type}</td>
				<td>${c.tour.cost}</td>
				<td>${c.tour.route.country}</td>
				<td>${c.tour.route.route}</td>
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