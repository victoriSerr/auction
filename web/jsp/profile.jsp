<%@ page import="models.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="services.UserService" %><%--
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

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mdb.min.js"></script>

    <script>
        function showMessages() {
            $.ajax({
                url: 'profile',
                success: function (responseText) {
                    $('#lots').hide();
                    $('#messages').load("<%=request.getContextPath()%>/jsp/profileInformation.jsp #messages").show();
                }
            })
        }
        function showLots() {
            $.ajax({
                url: 'profile',
                success: function (responseText) {
                    $('#messages').hide();
                    $('#lots').load("<%=request.getContextPath()%>/jsp/profileInformation.jsp #lots").show();
                }
            })
        }


    </script>
</head>

<body>
<div id="header"></div>

<main>
    <div class="jumbotron-fluid row" style="padding: 5%">

        <div class="col-2 ">
            <a href="#" onclick="showLots()"><span>Лоты</span></a>
            <hr>
            <a href="${pageContext.request.contextPath}/"><span>Ставки</span></a>
            <hr>
            <a class="message" href="#" onclick="showMessages()"><span>Сообщения</span></a>
            <hr>
            <a href="${pageContext.request.contextPath}/"><span>Настройки</span></a>
            <hr>
            <form action="${pageContext.request.contextPath}/add-new-lot" style="padding: 5%; bottom: 0;">
                <input type="submit" class="btn btn-outline-primary waves-effect" value="Новый лот">
            </form>
        </div>
        <div class="col-10" >
           <div id="messages"></div>
            <div id="lots"></div>
        </div>
    </div>

</main>
<div id="footer"></div>


</body>
</html>
