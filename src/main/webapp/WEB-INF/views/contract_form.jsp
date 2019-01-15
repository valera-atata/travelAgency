<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div {
	text-align: center;
}
#drop {
 	width:250px;   
}
</style>

<body>

<div>
    <form:form method="POST" modelAttribute="contractForm">
        <h2>Edit contract</h2>
        <table>
			<tr>
				<td><form:label path="client.clientId">Client</form:label></td>
				<td>
					<form:select path="client.clientId" id="drop">    
	        		<option value="-1">Select a type</option>
	       			<c:forEach items="${clients}" var="client">
	        			<option value="${client.clientId}">${client.surname} ${client.name} ${client.patron}</option>
	      			</c:forEach>
	     			</form:select>
	     		</td>
			</tr>
			<tr>
				<td><form:label path="tour.tourId">Tour</form:label></td>
				<td>
					<form:select path="tour.tourId" id="drop">    
	        		<option value="-1">Select a type</option>
	       			<c:forEach items="${tours}" var="tour">
	        			<option value="${tour.tourId}">${tour.organizer} ${tour.date} ${tour.type} ${tour.cost} ${tour.route.country} ${tour.route.route}</option>
	      			</c:forEach>
	     			</form:select>
	     		</td>
			</tr>
			<tr>
				<td colspan="2"><input style="width: 300px;" type="submit" value="Submit" name="submit_contract"></td>
			</tr>
		</table>
    </form:form>

</div>
</body>
</html>