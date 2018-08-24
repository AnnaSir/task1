<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head></head>
<body>
<h1>Hello! Nice to see you! What are you going to do today?</h1>
<p>To look all avaible tours click <a href="<c:url value = "/getAllTours"/>">here</a>.</p>
<p>You can look you profile <a href="<c:url value = "/getUser"/>">here</a>.</p>
<p>Your orders <a href="<c:url value = "/getUserOrders"/>">here</a>.</p>
<p>Also you can <a href="<c:url value = "/logout"/>">logout</a>.</p>
</body>
</html>