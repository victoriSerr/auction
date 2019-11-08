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
</head>
<body>

<div id="header"></div>

<div class="main_part" style="height: 90%">
    <div class="jumbotron jumbotron-fluid">
        <form class="main_part_sign-in" method="post" style="width: 500px; padding: 105px 15px; margin: auto;">
            <div class="form-group">

                <label for="login">Login</label><input type="text" class="form-control"  id="login" name="login" required>
            </div>
            <div class="form-group">

                <label for="email">Email</label><input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="password1">Пароль</label><input type="password" class="form-control" id="password1"
                                                            name="password1">
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="password2">Повторите пароль</label><input type="password" class="form-control is-invalid"--%>
<%--                                                                      id="password2" name="password2">--%>
<%--            </div>--%>
            <button type="submit" class="btn btn-primary">Регистрация</button>
        </form>
    </div>
</div>



<div id="footer"></div>

</body>
</html>
