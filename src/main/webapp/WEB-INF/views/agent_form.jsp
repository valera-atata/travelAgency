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

<body>

<div>

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
    </form:form>

</div>
</body>
</html>