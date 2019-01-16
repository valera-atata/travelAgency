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
</style>

<body>

<div>
	<form:form method="POST" modelAttribute="routeForm">
		<h2>Edit route</h2>
		
		<table>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="country" placeholder="country"/></td>
			</tr>
			<tr>
				<td><form:label path="route">Route</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="route" placeholder="route"/></td>
			</tr>
			<tr>
				<td colspan="2"><input style="width: 400px;" type="submit" value="Submit" name="submit_route"></td>
			</tr>
		</table>
	</form:form>

</div>
</body>
</html>