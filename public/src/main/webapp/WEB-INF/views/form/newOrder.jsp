<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>New Order</title>
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
    <h1><span>Create new Order</span>  </h1>
  </header>
  <section>
    <div id="container_demo" >
      <div id="wrapper">
        <div id="login" class="animate form">
          <form:form  action="/new_order" modelAttribute="order" method="post" autocomplete="on">
            <p>
              <label for="ordname">Product name</label>
              <form:input id="ordname" path="name" type="text" placeholder="Apple" />
              <form:errors path="name" cssClass="error"/>
            </p>
            <p>
              <label>Username</label>
              <form:select path="user.id">

                <form:options items="${usersList}" itemLabel="firstname" itemValue="id"/>

              </form:select>
            </p>
            <p>
              <label for="prices"  >Price</label>
              <form:input id="prices" path="price" type="number"   />
              <form:errors path="price" cssClass="error"/>
            </p>
            <p class="signin button">
              <input type="submit" value="Создать"/>
            </p>
            <p class="change_link">

              <a href="/users_list" class="to_register">  Отмена </a>
            </p>
          </form:form>
        </div>

      </div>

    </div>
  </section>
</div>
</body>
</html>

