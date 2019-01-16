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
 	width:300px;   
}
</style>

<body>

<div>
	<form:form method="POST" modelAttribute="tourForm">
		<h2>Edit tour</h2>
		
		<table>
			<tr>
				<td><form:label path="organizer">Organizer</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="organizer" placeholder="organizer"/></td>
			</tr>
			<tr>
				<td><form:label path="type">Type</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="type" placeholder="type"/></td>
			</tr>
			<tr>
				<td><form:label path="cost">Cost</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="cost" placeholder="cost"/></td>
			</tr>
			<tr>
			<td><form:label path="route.routeId">Route</form:label></td>
				<td>
					<form:select path="route.routeId" id="drop">    
	        		<option value="-1">Select a type</option>
	       			<c:forEach items="${routes}" var="route">
	        			<option value="${route.routeId}">${route.country} | ${route.route}</option>
	      			</c:forEach>
	     			</form:select>
	     		</td>
			</tr>
			<tr>
				<td colspan="2"><input style="width: 400px;" type="submit" value="Submit" name="submit_tour"></td>
			</tr>
		</table>
	</form:form>

</div>
</body>
</html>