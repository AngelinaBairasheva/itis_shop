<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/animate-custom.css"/>
</head>
<body>
<div class="container">
    <header>
        <h1><span>Login Form</span></h1>
    </header>
    <section>
        <div id="container_demo">
            <div id="wrapper">
                <div id="login" class="animate form">
                    <c:if test="${not empty error}">
                        <p style="color: red"><c:out value="${error}"/></p>
                    </c:if>
                    <form action="/authorization" method="post" autocomplete="on">
                        <h1>Log in</h1>

                        <p>
                            <label for="username" class="uname" data-icon="u"> Your e-mail </label>
                            <input id="username" name="login" required="required" type="text"
                                        placeholder="mymail@mail.com"/>
                        </p>

                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
                        </p>

                        <p class="login button">
                            <input type="submit" value="Login"/>
                        </p>
                        <p class="change_link">

                            <a href="/users_list" class="to_register">  Отмена </a>
                        </p>
                    </form>
                </div>

            </div>

        </div>
    </section>
</div>
</body>
</html>