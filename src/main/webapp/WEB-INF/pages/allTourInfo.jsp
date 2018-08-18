<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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

        </tr>
    </c:forEach>
</table>

</body>
</html>