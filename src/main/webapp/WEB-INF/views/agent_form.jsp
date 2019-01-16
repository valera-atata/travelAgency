<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent form</title>
</head>

<body>

<div>

	<form:form method="POST" modelAttribute="agentForm">
		<h2>Create your account</h2>
		
		<table>
			<tr>
			<spring:bind path="surname">
				<td><form:label path="surname">Surname</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="surname" placeholder="surname"/></td>
			</spring:bind>
			</tr>
			<tr>
			<spring:bind path="name">
				<td><form:label path="name">Name</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="name" placeholder="name"/></td>
			</spring:bind>
			</tr>
			<tr>
			 <spring:bind path="patron">
				<td><form:label path="patron">Patronymic</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="patron" placeholder="patron"/></td>
			</spring:bind>
			</tr>
			<tr>
			<spring:bind path="passport">
				<td><form:label path="passport">Passport</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="passport" placeholder="passport"/></td>
			</spring:bind>
			</tr>
			<tr>
			<spring:bind path="address">
				<td><form:label path="address">Address</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="address" placeholder="address"/></td>
			</spring:bind>
			</tr>
			<tr>
			<spring:bind path="phone">
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="phone" placeholder="phone"/>
	               	<form:errors style="width: 296px;" path="phone"/>
	            </td>
	        </spring:bind>
            </tr>
            <tr>
            <spring:bind path="login">
				<td><form:label path="login">Login</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="login" placeholder="login"/>
	               	<form:errors style="width: 296px;" path="phone"/>
	            </td>
	        </spring:bind>
            </tr>
            <tr>
            <spring:bind path="password">
				<td><form:label path="password">Password</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="password" placeholder="password"/>
	               	<form:errors style="width: 296px;" path="password"/>
	            </td>
	        </spring:bind>
            </tr>
            <tr>
            <spring:bind path="confirmPassword">
				<td><form:label path="confirmPassword">Confirm password</form:label></td>
				<td><form:input style="width: 296px;" type="text" path="confirmPassword" placeholder="confirmPassword"/>
	               	<form:errors style="width: 296px;" path="confirmPassword"/>
	            </td>
	        </spring:bind>
            </tr>
			<tr>
				<td colspan="2"><input style="width: 400px;" type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>

<%--     <form:form method="POST" modelAttribute="agentForm">
        <p>Create your account</p>
        <spring:bind path="login">
            <div>
                <form:input type="text" path="login" placeholder="login"/>
                <form:errors path="login"/>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div>
                <form:input type="password" path="password" placeholder="Password"/>
                <form:errors path="password"/>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div>
                <form:input type="password" path="confirmPassword"
                            placeholder="Confirm your password"/>
                <form:errors path="confirmPassword"/>
            </div>
        </spring:bind>

        <button type="submit">Submit</button>
    </form:form> --%>


<%-- 
    <form:form method="POST" modelAttribute="agentForm">
        <p>Create your account</p>

        <spring:bind path="surname">
            <div>
                <form:input type="text" path="surname" placeholder="surname"/>
            </div>
        </spring:bind>
        
        <spring:bind path="name">
            <div>
                <form:input type="text" path="name" placeholder="name"/>
            </div>
        </spring:bind>
        
        <spring:bind path="patron">
            <div>
                <form:input type="text" path="patron" placeholder="patron"/>
            </div>
        </spring:bind>
        
        <spring:bind path="passport">
            <div>
                <form:input type="text" path="passport" placeholder="passport"/>
            </div>
        </spring:bind>
        
        <spring:bind path="address">
            <div>
                <form:input type="text" path="address" placeholder="address"/>
            </div>
        </spring:bind>
        
        <spring:bind path="phone">
            <div>
                <form:input type="text" path="phone" placeholder="phone"/>
                 <form:errors path="phone"/>
            </div>
        </spring:bind>
        
        <spring:bind path="login">
            <div>
                <form:input type="text" path="login" placeholder="login"/>
                <form:errors path="login"/>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div>
                <form:input type="password" path="password" placeholder="password"/>
                <form:errors path="password"/>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div>
                <form:input type="password" path="confirmPassword"
                            placeholder="confirm your password"/>
                <form:errors path="confirmPassword"/>
            </div>
        </spring:bind>

        <button type="submit">Submit</button>
    </form:form> --%>
</div>
</body>
</html>