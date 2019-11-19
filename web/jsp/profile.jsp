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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design for Bootstrap</title>
    <!-- MDB icon -->
    <link rel="icon" href="<%=request.getContextPath()%>/img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

    <script>
        function showMessages() {
            $.ajax({
                url: 'messages',
                success: function (responseText) {
                    $('#messages').show();
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
            <a href="${pageContext.request.contextPath}/"><span>Лоты</span></a>
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
        <div class="col-10" id="main_part">
            <div id="messages" style="display: none">
                <%
                    List<Message> list = (List<Message>) request.getSession().getAttribute("messages"); request.getSession().removeAttribute("messages");
                    if (list != null) {
                        for (Message message : list) {
                %>
                <div class="media d-block d-md-flex mt-4">
                    <div class="media-body text-center text-md-left ml-md-3 ml-0">
                        <p class="font-weight-bold my-0">
                            <%=new UserService().findUserById(message.getFromUserId()).getLogin()%>
                            <a href="" class="pull-right ml-1">
                                <i class="fas fa-reply"></i>
                            </a>
                        </p>
                        <%=message.getMessage()%>
                    </div>
                </div>
                <%
                    }
                } else {
                %>
                <p>Нет сообщений</p>
                <%}%>
            </div>

            <%if (request.getSession().getAttribute("currLogin") != null) {%>
            <div id="another_profile">
                <p><%=request.getSession().getAttribute("currLogin")%> <%request.getSession().removeAttribute("currLogin");%>
                </p>
                <form method="post">
                    <textarea name="message"></textarea>
                    <input type="submit" value="Отправить сообщение" <%if (request.getSession().getAttribute("isSignIn") == null) {%>
                           formaction="${pageContext.request.contextPath}/login" <%}%>>
                </form>
            </div>
            <%}%>
        </div>
    </div>

</main>
<div id="footer"></div>


</body>
</html>
