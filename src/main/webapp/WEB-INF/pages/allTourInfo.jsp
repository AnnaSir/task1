<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<html>
<head></head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>Название тура</th>
<th>Описание</th>
<th>Место</th>
<th>Дата начала</th>
<th>Дата завершения</th>
<th>Осталось</th>
</tr>
    <c:forEach var="tour" items="${tours}" >
        <tr>
            <td>${tour.tourId}</td>
            <td>${tour.name}</td>
            <td>${tour.description}</td>
            <td>${tour.location}</td>
            <td>${tour.startDate}</td>
            <td>${tour.endDate}</td>
            <td>${tour.countLimit}</td>
            <td><a href="<c:url value = "/addOrder?tourId=${tour.tourId}"/>">Хочу забронировать</a></td>
        </tr>
    </c:forEach>
</table>

<p><a href="<c:url value = "/getMainPage"/>">Вернуться на главную</a></p>
<p><a href="<c:url value = "/logout"/>">Выйти</a></p>

</body>
</html>