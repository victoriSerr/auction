<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 30.10.2019
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<div id="main_header" style="background-color: black; top: 0; left: 0; position: fixed; z-index: 1; right: 0; color: white;">

    <div style="float: left; width: 33%; text-align: center;margin-top: auto; margin-bottom: auto; ">
        <%--        <img src="images/logo.png" alt="logo">--%>
        <h1 ><a href="${pageContext.request.contextPath}/" style="color: red">Auction</a></h1>
    </div>

    <div style="display: inline-block; width: 35%; text-align: center; margin: auto">
        <form>
            <div>
                <label><input type="text" class="form-control"></label>
                <button type="button" class="btn btn-primary" style="width: 40px; height: 40px"><img src="<%=request.getContextPath()%>/images/search.png" alt="search"></button>
            </div>
        </form>
    </div>

    <% if (request.getSession().getAttribute("isSignIn") == null) {%>
    <div style="float: right; width: 20%; text-align: center;margin-top: auto; margin-bottom: auto">
        <form method="get">
            <input type="submit" class="btn btn-outline-success" formaction="${pageContext.request.contextPath}/login"
                   value="Вход"/>
            <input type="submit" class="btn btn-outline-danger"
                   formaction="${pageContext.request.contextPath}/registration" value="Регистрация">
        </form>
    </div>
    <%} else {%>

    <div style="float: right; width: 20%; text-align: center;margin-top: auto; margin-bottom: auto">
        <form method="get">
            <input type="submit" class="btn btn-outline-success" formaction="${pageContext.request.contextPath}/profile"
                   value="Мой профиль"/>
            <input type="submit" class="btn btn-outline-danger"
                   formaction="${pageContext.request.contextPath}/logout" value="Выйти">
        </form>
    </div>
    <%}%>


</div>

<div id="main_footer" style="background-color: black;  position: relative; bottom: 0; left: 0; right: 0;">
    <div>
        <img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" style="display: block; margin-left: auto; margin-right: auto">
    </div>
</div>
</html>
