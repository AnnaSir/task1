<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head></head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>TOUR ID</th>
<th>Подтвержден</th>
<th>Время заказа</th>

</tr>
    <c:forEach var="order" items="${orders}" >
        <tr>
            <td>${order.orderId}</td>
            <td>${order.tourId}</td>
            <td>${order.confirmed?"yes":"no"}</td>
            <td><fmt:formatDate type = "both" dateStyle = "medium" value = "${order.timeKey}" /></td>
            <td><a href="<c:url value = "/delOrder?orderId=${order.orderId}"/>">delete</a></td>
        </tr>
    </c:forEach>
</table>

<p><a href="<c:url value = "/getMainPage"/>">Вернуться на главную</a></p>
<p><a href="<c:url value = "/logout"/>">Выйти</a></p>

</body>
</html>