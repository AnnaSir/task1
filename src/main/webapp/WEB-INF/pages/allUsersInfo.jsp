<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head></head>
<body>
<table border="1">
<tr>
<th>User Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Active</th>
<th>Birthday</th>
</tr>
    <c:forEach var="user" items="${users}" >
        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.active? "1":"0"}</td>
            <td>${user.birthday}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>