<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 27.10.2019
  Time: 19:07
  To change this template use File | Settings | File Templates.

</script>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <script type='text/jsp' src="<%=request.getContextPath()%>/jsp/main.jsp"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function () {
            $("#header").load("<%=request.getContextPath()%>/jsp/main.jsp #main_header");
            $("#footer").load("<%=request.getContextPath()%>/jsp/main.jsp #main_footer");
        });

    </script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design for Bootstrap</title>
    <!-- MDB icon -->
    <link rel="icon" href="<%=request.getContextPath()%>/images/logo.png" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<div id="header"></div>
<main>
    <div class="row">
        <div class="rounded col-md-12 background-login" align="center">
            <div class="main_part" style="height: 90%">
                <div class="jumbotron jumbotron-fluid">
                    <form class="main_part_sign-in" method="post">
                        <h1 style="text-align: center">Login</h1>
                        <div class="form-group">

                            <% Cookie[] cookies = request.getCookies();
                                String login = null;
                                int i = 0;
                                if (cookies != null) {
                                    while (i < cookies.length && !cookies[i].getName().equals("login")) {
                                        i++;
                                    }
                                    if (i < cookies.length) {
                                        login = cookies[i].getValue();
                                    }
                                }
                            %>

                            <label for="login">Email address / login</label>
                            <input type="text" class="form-control col-lg-4 col-lg-offset-4" name="login" id="login" <%if (login != null) {%>
                                   value="<%=login%>" <%}%> placeholder="Email / login">
                            <small id="emailHelp" style="color: darkred">
                                <% Object s = request.getSession().getAttribute("wrongLogin");
                                    if (s != null) {%><%=s%>
                                <% request.getSession().removeAttribute("wrongLogin");
                                }%>
                            </small>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control col-lg-4 col-lg-offset-4" id="password" placeholder="Password"
                                   name="password">
                            <small id="emailHelp1" class="form-text text-muted" style="color: darkred">
                                <% Object s1 = request.getSession().getAttribute("wrongPassword");
                                    if (s1 != null) {%><%=s1%>
                                <% request.getSession().removeAttribute("wrongPassword");
                                }%>
                            </small>
                        </div>

                        <label>
                            <input type="checkbox" name="remember_me" value="true">
                        </label> Запомнить меня
                        <p>
                            <button type="submit" class="btn btn-primary" style="display: inline-flex">Войти</button>
                            <button type="submit" class="btn btn-primary"
                                    formaction="${pageContext.request.contextPath}/registration" formmethod="get"
                                    style="background-color: green">Регистрация
                            </button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<div id="footer"></div>

</body>
</html>
