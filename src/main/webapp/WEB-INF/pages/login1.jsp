<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head></head>
<body>
   <h1>Представьтесь, пожалуйста</h1>
   <form name='f' action="login" method='POST'>
      <table>
         <tr>
            <td>Имя пользователя:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Пароль:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <input type="hidden"
             name="${_csrf.parameterName}"
             value="${_csrf.token}"/>
         <tr>
            <td><input type="submit" name="submit"/></td>
         </tr>
      </table>
  </form>
</body>
</html>