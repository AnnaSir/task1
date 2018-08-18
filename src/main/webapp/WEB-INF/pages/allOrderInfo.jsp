<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
<head></head>
<body>
<table border="1">
<tr>
<th>Order Id</th>
<th>User Id</th>
<th>Tour Id</th>
<th>Confirmed</th>
<th>Time Key</th>
</tr>
    <c:forEach var="order" items="${orders}" >
        <tr>
            <td>${order.orderId}</td>
            <td>${order.userId}</td>
            <td>${order.tourId}</td>
            <td>${order.confirmed?"yes":"no"}</td>
            <td><fmt:formatDate type = "both" dateStyle = "medium" value = "${order.timeKey}" /></td>

        </tr>
    </c:forEach>
</table>

</body>
</html>