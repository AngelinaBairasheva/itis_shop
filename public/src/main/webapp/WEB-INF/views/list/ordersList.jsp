<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="message" value="List of orders is empty!"/>
<html>
<head>
  <title>List of orders</title>
</head>
<body>
<div style="margin-left:1000px;"><a href="/users_list">Список пользователей</a><a style="margin-left: 10px;" href="/new_order">Создать
  заказ</a></div>

<c:choose>
  <c:when test="${empty orders_list}">
    <div align="center">
      <h3><c:out value="${message}"/></h3>
    </div>
  </c:when>
  <c:otherwise>
    <table style="text-align: center;margin-left:200px;margin-top:100px;" border="1" cellspacing="0"
           cellpadding="12">
      <thead>
      <tr>
        <th>Наименование</th>
        <th>Пользователь</th>
        <th>Цена</th>
        <th colspan="2">Действия</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${orders_list}" var="order">
        <tr>
          <td width="200" height="100"><c:out value="${order.name}"/></td>
          <td><c:out value="${order.user.firstname}"/></td>
          <td><c:out value="${order.price}"/></td>
          <td><a href="edit_order?id=${order.id}">Изменить</a></td>
          <td><a href="delete_order?id=${order.id}">Удалить</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:otherwise>
</c:choose>
<div style="margin-left:1000px;"><a href="/new_order">Создать заказ</a></div>
</body>
</html>
