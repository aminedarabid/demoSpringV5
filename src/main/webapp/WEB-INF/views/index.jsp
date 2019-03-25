<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lourd</title>
</head>
<body>

    <h1>TEST</h1>
	<a href="form.html">formulaire</a>
    <c:forEach items="${formationList}" var="form">
        <p>${form.theme}</p>
    </c:forEach>
</body>
</html>
