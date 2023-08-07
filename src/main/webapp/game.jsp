<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>Дорога домой</title>
</head>
<body>

<c:if test="${question == null}">
    <h2>Ты оказался в странном месте. Твоя задача - найти дорогу домой и пройти все испытания.</h2>
    <div>
        <form action="play" method="post">
            <label>Пожалуйста представься:</label>
            <br><br>
            <label>Твое имя:</label>
            <input type="text" title="Введите ваше имя кириллицей (от 2 до 16 символов)"
                   name="name" pattern="[А-Яа-я]{2,16}" placeholder="Введите ваше имя" id="name" required>
            <br><br>
            <label>Твой возраст:</label>
            <input type="number" title="Введите ваш возраст"
                   name="age" min=5 max=100 placeholder="Введите ваш возраст" id="age" required>
            <br><br>
            <label>Твой пол:
            <input type="radio" name="gender" value="мужской" checked required/>Мужчина
            <input type="radio" name="gender" value="женский" checked/>Женщина
            </label>
            <br><br>
            <button type="submit">Продолжить</button>
        </form>
    </div>
</c:if>

<c:if test="${question != null}">
    <br>
    <div>${question.text}</div>
    <br><br>
    <div>
        <form action="play" method="post">
            <label>Выбери следующее действие:</label>
            <br><br>
            <c:forEach items="${answers}" var="answer" varStatus="loop">
                <input type="radio" name="answerId" value="${answer.id}"
                       <c:if test="${loop.index == 0}">checked required</c:if>
                >${answer.text}
                <br><br>
            </c:forEach>
            <c:if test="${stoppingCause != null}">${stoppingCause} Может попробуешь что-нибудь еще?<br><br></c:if>
            <button type="submit">Продолжить</button>
            <br>
        </form>
    </div>
</c:if>
<br><br>
<div>
Играет игрок: ${cookie.name.value}<br>
Возраст - ${cookie.age.value}, пол - ${cookie.gender.value}<br>
IP-address: <%= request.getRemoteAddr()%><br>
<br>
Общая статистика для игроков:<br>
Общее количество игр: ${cookie.counter.value}<br>
Общее количество побед: ${cookie.counterWins.value}<br>
Общее количество поражений: ${cookie.counterLoses.value}<br>
</div>
</body>
</html>