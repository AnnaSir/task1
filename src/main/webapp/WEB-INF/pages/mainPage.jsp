<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<html>
<head></head>
<body>
<h1>Что будем делать?</h1>
<p>Смотреть <a href="<c:url value = "/getAllTours"/>">туры</a>!</p>
<p>Смотреть и реактировать <a href="<c:url value = "/getUser"/>">профиль</a>.</p>
<p>Смотреть <a href="<c:url value = "/getUserOrders"/>">заказы</a>.</p>
<p><a href="<c:url value = "/logout"/>">Уходить</a></p>
</body>
</html>