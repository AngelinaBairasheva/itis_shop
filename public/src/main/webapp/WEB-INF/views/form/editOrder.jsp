<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Edit Order</title>
  <style>
    .error {
      color: red;
    }
  </style>
  <link rel="stylesheet" type="text/css" href="../../../resources/css/demo.css"/>
  <link rel="stylesheet" type="text/css" href="../../../resources/css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../../../resources/css/animate-custom.css"/>
</head>
<body>
<div class="container">
  <header>
    <h1><span>Edit Order</span>  </h1>
  </header>
  <section>
    <div id="container_demo" >
      <div id="wrapper">
        <div id="login" class="animate form">
          <form:form  action="/edit_order" modelAttribute="order" method="post" autocomplete="on">
            <form:hidden path="id" value="${cur_order.id}"/>
            <p>
              <label for="orders" >Product name</label>
              <form:input id="orders" path="name" type="text" value="${cur_order.name}" />
              <form:errors path="name" cssClass="error"/>
            </p>
            <form:hidden path="id" value="${order.id}"/>
            <p>
              <label>Username</label>
              <form:select path="user.id">

                <form:options items="${usersList}" itemLabel="firstname" itemValue="id"/>

              </form:select>
            </p>
            <p>
              <label for="prices"  >Price</label>
              <form:input id="prices" path="price" type="number" value="${cur_order.price}" />
              <form:errors path="price" cssClass="error"/>
            </p>

            <p class="signin button">
              <input type="submit" value="Сохранить"/>
            </p>
            <p class="change_link">

              <a href="/orders_list" class="to_register">  Отмена </a>
            </p>
          </form:form>
        </div>

      </div>

    </div>
  </section>
</div>
</body>
</html>
