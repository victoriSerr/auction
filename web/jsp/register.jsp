<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 24.10.2019
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <script type='text/jsp' src="<%=request.getContextPath()%>/jsp/main.jsp"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function () {
            $("#header").load("<%=request.getContextPath()%>/jsp/main.jsp #main_header");
            $("#footer").load("<%=request.getContextPath()%>/jsp/main.jsp #main_footer");
        });
    </script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design for Bootstrap</title>
    <!-- MDB icon -->
    <link rel="icon" href="../img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="../css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div id="header"></div>

<main>
    <div class="jumbotron jumbotron-fluid" align="center">
        <form method="post">
            <h1 style="text-align: center">Registration</h1>
            <div class="form-group">

                <label for="login">Login</label>
                <input type="text" class="form-control col-lg-4 col-lg-offset-4" id="login" name="login"
                       placeholder="Login"
                       required>
            </div>
            <div class="form-group">

                <label for="email">Email</label>
                <input type="email" class="form-control col-lg-4 col-lg-offset-4" id="email" name="email"
                       placeholder="Email">
            </div>
            <div class="form-group">
                <label for="password1">Password</label>
                <input type="password" class="form-control col-lg-4 col-lg-offset-4" id="password1"
                       placeholder="Password"
                       name="password1">
            </div>
            <%--            <div class="form-group">--%>
            <%--                <label for="password2">Повторите пароль</label><input type="password" class="form-control is-invalid"--%>
            <%--                                                                      id="password2" name="password2">--%>
            <%--            </div>--%>
            <button type="submit" class="btn btn-primary">Регистрация</button>
        </form>
    </div>
</main>


<div id="footer"></div>

</body>
</html>
