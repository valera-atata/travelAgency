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
<%-- 	<form action="${contextPath}/logout" method="POST">
	    <input type="submit" value="Logout"/>
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form> --%>
	
	<form action="${contextPath}/logout" method="POST">
	    <input type="submit" value="Logout"/>
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
	</form>
	
	<form:form method="GET" modelAttribute="form">
		<table style="margin: center">
		
			<tr><td><input style="width: 300px;" type="submit" value="Создать договор" name="create_contract"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Мои клиенты" name="my_clients"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Сумма договоров по моим турам" name="sum_of_contracts"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Мои договора за период" name="my_contracts_on_period"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Отобразить все маршруты" name="all_routes"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Отобразить все договора" name="all_contracts"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Статистика по агентам" name="statistics_of_agents"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Отобразить всех клиентов" name="all_agents"></td></tr>
			<tr><td><input style="width: 300px;" type="submit" value="Выйти" name="log_out"></td></tr>
			
		</table>
	</form:form>
</div>
</body>
</html>