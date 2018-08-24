<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head></head>
<body>
<table border="1">
<tr>
<th>Tour Id</th>
<th>Name</th>
<th>Description</th>
<th>Location</th>
<th>Start Date</th>
<th>End Date</th>
<th>Count Limit</th>
<th>Add tour</th>
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
            <td><a href="<c:url value = "/addOrder?tourId=${tour.tourId}"/>">here</a></td>
        </tr>
    </c:forEach>
</table>

<p>Click <a href="<c:url value = "/getMainPage"/>">here</a> to return</p>
<p>Click <a href="<c:url value = "/logout"/>">here</a> to logout</p>

</body>
</html>