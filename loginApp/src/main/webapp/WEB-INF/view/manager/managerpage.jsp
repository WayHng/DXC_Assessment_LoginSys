<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>Manager Page</title>
    </head>
    <body>
        <h1>Manager Page</h1>

        This is the Manager Page. Only Managers have access.
        
        <a href="<c:url value='/perform_logout' />">Logout</a>
    </body>
</html>