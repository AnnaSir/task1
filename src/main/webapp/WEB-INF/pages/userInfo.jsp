<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User info</title>
</head>
<body>
<form action ="/puppet/getUser">
    <input type ="text" name = "id"/>
    <input type ="submit"/>
</form>

<c:if test = "${user!=null}">
    <table border="1">
    <th>User Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Active</th>
    <th>Birthday</th>

        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.active?"1":"0"}</td>
            <td>${user.birthday}</td>
        </tr>
     </table>
</c:if>

</body>
</html>