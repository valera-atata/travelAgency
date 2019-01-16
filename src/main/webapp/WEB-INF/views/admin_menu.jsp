<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
<head>
    <title>menu</title>
</head>
<body>

<div>   
	
	<table>
			<tr><td>
				<form:form method="POST" action="${contextPath}/create_contract">
					<button type="submit" style="width: 300px;">Create contract</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/my_contracts">
					<button type="submit" style="width: 300px;">My contracts</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/my_clients">
					<button type="submit" style="width: 300px;">My clients</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/admin_all_routes">
					<button type="submit" style="width: 300px;">All routes</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/admin_all_tours">
					<button type="submit" style="width: 300px;">All tours</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/all_contracts">
					<button type="submit" style="width: 300px;">All contracts</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/all_clients">
					<button type="submit" style="width: 300px;">All clients</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/sum_of_contracts">
					<button type="submit" style="width: 300px;">Sum of contracts</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form:form method="POST" action="${contextPath}/statistics_of_agents">
					<button type="submit" style="width: 300px;">Statistics of agents</button>
				</form:form>
			</td></tr>
			<tr><td>
				<form action="${contextPath}/logout" method="POST">
				    <input type="submit" value="Logout" style="width: 300px;" />
				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
				</form>
			</td></tr>
		</table>
</div>
</body>
</html>