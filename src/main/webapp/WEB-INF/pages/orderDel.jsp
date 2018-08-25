<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head></head>
<body>
<h1>Заказ удален.</h1>
    <p><a href="<c:url value = "/getUserOrders"/>">Посмотреть заказы</a></p>
    <p><a href="<c:url value = "/getAllTours"/>">Вернуться к списку туров</a></p>
</body>
</html>