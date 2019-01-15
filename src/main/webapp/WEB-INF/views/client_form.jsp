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
	<form:form method="POST" modelAttribute="clientForm">
		<h2>Edit client</h2>
		
		<table>
			<tr>
				<td><form:label path="surname">Surname</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="surname" placeholder="surname"/></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="name" placeholder="name"/></td>
			</tr>
			<tr>
				<td><form:label path="patron">Patronymic</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="patron" placeholder="patron"/></td>
			</tr>
			<tr>
				<td><form:label path="passport">Passport</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="passport" placeholder="passport"/></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="address" placeholder="address"/></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="phone" placeholder="phone"/>
	               	<form:errors style="width: 296px;" path="phone"/>
	            </td>
            </tr>
			<tr>
				<td colspan="2"><input style="width: 400px;" type="submit" value="Submit" name="submit_client"></td>
			</tr>
		</table>
	</form:form>

</div>
</body>
</html>