<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>User info</title>
</head>
<body>
<h1>Профиль</h1>
<c:if test = "${user!=null}">
    <table >
        <tr>
            <td>Имя/Логин:</td>
            <td>${user.firstName}</td>
            <td>Изменить на </td>
            <td>
            <form action ="/puppet/userUpdate?">
                <input type="hidden" name= "a" value="1"/>
                <input type ="text" name = "s"/>
                <input type ="submit"/>
            </form>
            </td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td>${user.lastName}</td>
            <td>Изменить на</td>
            <td>
            <form action ="/puppet/userUpdate?">
                <input type="hidden" name= "a" value="2"/>
                <input type ="text" name = "s"/>
                <input type ="submit"/>
            </form>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${user.email}</td>
            <td>Изменить на</td>
            <td>
            <form action ="/puppet/userUpdate?">
                <input type="hidden" name= "a" value="3"/>
                <input type ="text" name = "s"/>
                <input type ="submit"/>
            </form>
            </td>
        </tr>
        <tr>
            <td>Статус</td>
            <td>${user.active?"активен":"неактивен"}</td>
        </tr>
     </table>

</c:if>
     <p><a href="<c:url value = "/updatePass"/>">Сменить пароль</a></p>
     <p><a href="<c:url value = "/getMainPage"/>">Вернуться на главную</a></p>
     <p><a href="<c:url value = "/logout"/>">Выйти</a></p>

</body>
</html>