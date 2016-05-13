<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Edit User</title>
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
    <h1><span>Edit User</span>  </h1>
  </header>
  <section>
    <div id="container_demo" >
      <div id="wrapper">
        <div id="login" class="animate form">
          <form:form  action="/edit_user" modelAttribute="user" method="post" autocomplete="on">
            <p>
              <label for="usernames"  data-icon="u">Your firstname</label>
              <form:input id="usernames" path="firstname"  type="text" value="${cur_user.firstname}" />
              <form:errors path="firstname" cssClass="error"/>
            </p>
            <form:hidden path="id" value="${cur_user.id}"/>
            <p>
              <label for="lastnames" data-icon="u">Your lastname</label>
              <form:input id="lastnames" path="lastname" type="text" value="${cur_user.lastname}" />
              <form:errors path="lastname" cssClass="error"/>
            </p>
            <p>
              <label for="ages"  >Your age</label>
              <form:input id="ages" path="age" type="number" value="${cur_user.age}" />
              <form:errors path="age" cssClass="error"/>
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
