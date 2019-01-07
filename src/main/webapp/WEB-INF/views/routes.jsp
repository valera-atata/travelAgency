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
<h1 align="center">List Routes</h1>
<!-- 	<button onclick="window.location.href = 'showFormForAdd'; return false;">first</button> -->
<!-- 	<button onclick="window.location.href = 'showFormForAdd'; return false;">second</button>  -->
<div>   

	<table border="1">
		<tr>
			<th>${columns[0]}</th>
			<th>${columns[1]}</th>
			<th>${columns[2]}</th>
		</tr>
		<c:forEach items="${routes}" var="r">
<%-- 			<c:url var="updateLink" value="/student/displayUpdateForm.html">
				<c:param name="studentId" value="${s.id}" />
			</c:url>

			<c:url var="deleteLink" value="/student/displayDeleteForm.html">
				<c:param name="studentId" value="${s.id}" />
			</c:url> --%>
			<tr>
				<td>${r.routeId}</td>
				<td>${r.country}</td>
				<td>${r.route}</td>
				<%-- <td><a href="${updateLink}">Update</a> | <a
					href="${deleteLink}"
					onclick="if(!(confirm('Are you sure want to delete this Student permanently?'))) return false">Delete</a></td> --%>
			</tr>
		</c:forEach>
	</table>

<%-- 	<form:form method="POST" modelAttribute="form">
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
	</form:form> --%>
</div>
</body>
</html>