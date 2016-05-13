<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New User</title>
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
        <h1><span>Create new User</span></h1>
    </header>
    <section>
        <div id="container_demo">
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form:form action="/new_user" modelAttribute="user" method="post" autocomplete="on">
                        <p>
                            <label for="usernamesignup" data-icon="u">Your firstname</label>
                            <form:input id="usernamesignup" path="firstname" type="text"
                                        placeholder="mysuperfirstname"/>
                            <form:errors path="firstname" cssClass="error"/>
                        </p>

                        <p>
                            <label for="lastnamesignup" data-icon="u">Your lastname</label>
                            <form:input id="lastnamesignup" path="lastname" type="text" placeholder="mysuperlastname"/>
                            <form:errors path="lastname" cssClass="error"/>
                        </p>

                        <p>
                            <label for="agesignup">Your age</label>
                            <form:input id="agesignup" path="age" type="number"/>
                            <form:errors path="age" cssClass="error"/>
                        </p>

                        <p class="signin button">
                            <input type="submit" value="Создать"/>
                        </p>

                        <p class="change_link">

                            <a href="/users_list" class="to_register"> Отмена </a>
                        </p>
                    </form:form>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
