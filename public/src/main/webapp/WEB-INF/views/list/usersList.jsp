<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="message" value="List of users is empty!"/>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<div style="margin-left:1000px;"><a href="/orders_list">Список заказов</a><a style="margin-left: 10px;" href="/new_order">Создать
    заказ</a></div>

<c:choose>
    <c:when test="${empty users_list}">
        <div align="center">
            <h3><c:out value="${message}"/></h3>
        </div>
    </c:when>
    <c:otherwise>
        <table style="text-align: center;margin-left:200px;margin-top:100px;" border="1" cellspacing="0"
               cellpadding="12">
            <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th colspan="2">Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users_list}" var="user">
                <tr>
                    <td width="200" height="100"><c:out value="${user.firstname}"/></td>
                    <td><c:out value="${user.lastname}"/></td>
                    <td><c:out value="${user.age}"/></td>
                    <td><a href="edit_user?id=${user.id}">Изменить</a></td>
                    <td><a href="delete_user?id=${user.id}">Удалить</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
<div style="margin-left:1000px;"><a href="/new_user">Создать пользователя</a></div>
</body>
</html>
