<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h1>Homepage</h1>

        <security:authorize access="hasAnyRole('USER', 'MANAGER')">
            Welcome!
            Name: <c:out value="${username}" />
            Role: <c:out value="${role}" />
        </security:authorize>

        <security:authorize access="hasRole('MANAGER')">
            <a href="<c:url value='/manager/managerpage.html' />">Manager Page</a>
        </security:authorize>

        <a href="<c:url value='/perform_logout' />">Logout</a>

    </body>
</html>