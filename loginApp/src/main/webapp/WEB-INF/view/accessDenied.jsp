<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Access Denied</title>
    </head>
    <body>
        <h1>Access Denied</h1>
        <h2>Sorry you do not have permission to view this page</h2>

        <a href="<c:url value='/homepage.html' />">Homepage</a>
    </body>
</html>