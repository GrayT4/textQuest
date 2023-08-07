<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Поражение</title>
    <link href="static/main.css?$v=1.0" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h2>Поражение!</h2>
<br>
<div>${cookie.name.value}, ${loosingCause}</div>
<br><br>
<div><form action="restart" method="post">
    <input type="submit" value="Начать заново">
</form></div>
</body>
</html>
