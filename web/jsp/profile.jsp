<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 27.10.2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Мой профиль</title>
    <script type='text/jsp' src="<%=request.getContextPath()%>/jsp/main.jsp"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function () {
            $("#header").load("<%=request.getContextPath()%>/jsp/main.jsp #main_header");
            $("#footer").load("<%=request.getContextPath()%>/jsp/main.jsp #main_footer");
        });
    </script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div id="header"></div>

<div class="main_part" style="position: relative; height: 90%; top: 62px; margin: auto">
    hi,
    <%= request.getSession().getAttribute("login") %>
    <form action="${pageContext.request.contextPath}/logout" method="get">


        <input type="submit" value="logout">
    </form>

    <a href="${pageContext.request.contextPath}/add-new-lot">Добавить новый лот</a>


</div>
<div id="footer"></div>
</body>
</html>
