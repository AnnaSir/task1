<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tour info</title>
</head>
<body>
<form action ="/puppet/getTour">
    <input type ="text" name = "tourId"/>
    <input type ="submit"/>
</form>

<c:if test = "${tour!=null}">
    <table border="1">
    <th>Tour Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Location</th>
    <th>Start Date</th>
    <th>End Date</th>
    <th>COUNT LIMIT</th>

        <tr>
            <td>${tour.tourId}</td>
            <td>${tour.name}</td>
            <td>${tour.description}</td>
            <td>${tour.location}</td>
            <td>${tour.startDate}</td>
            <td>${tour.endDate}</td>
            <td>${tour.countLimit}</td>
        </tr>
     </table>
</c:if>




</body>
</html>