<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Tour info</title>
</head>
<body>
    <h1> ${result}</h1>
    <p><a href="<c:url value = "/getUserOrders"/>">Посмотреть заказы</a></p>
    <p><a href="<c:url value = "/getAllTours"/>">Вернуться к списку туров</a></p>
</body>
</html>