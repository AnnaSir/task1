<!DOCTYPE html>
<html>
<head></head>
<body>
   <h1>Login</h1>
   <form name='f' action="login" method='POST'>
      <table>
         <tr>
            <td>User1:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
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