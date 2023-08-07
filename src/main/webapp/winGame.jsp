<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Победа</title>
  <link href="static/main.css?$v=1.0" rel="stylesheet">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h2>Победа!</h2>
<br>
<div>Поздравляю, ${cookie.name.value}!</div>
<div>Ты успешно прошел все испытания и добрался до дома живым!</div>
<br><br>
<div><form action="restart" method="post">
  <input type="submit" value="Начать заново">
</form></div>
</body>
</html>
