<%@ page import="models.Lot" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 06.11.2019
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <title>Auction</title>
        <script type='text/jsp' src="<%=request.getContextPath()%>/jsp/main.jsp"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(function () {
                $("#header").load("<%=request.getContextPath()%>/jsp/main.jsp #main_header");
                $("#footer").load("<%=request.getContextPath()%>/jsp/main.jsp #main_footer");
            });

        </script>
        <%--        <link rel="stylesheet" href="css/style.css">--%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
</head>
<body>
<div id="header"></div>

<div class="main_part" style="position: relative; width: 90%; top: 62px; margin: auto">

    <div class="row" style="margin: 30px 0 30px 0; width: 100%; top: 30px;">

        <% List<Lot> lots = (List<Lot>) request.getSession().getAttribute("lots"); %>
        <%for (Lot lot : lots) {%>


        <div style=" height: 560px;
    padding-bottom: 20px;
    display: inline-block;
    float: none;
    text-align: left;
    margin: 0 2% 0;
    width: 360px;">
            <div class="card" style="position: absolute; height: 503px;width: 360px; background: #f5f5f5;">
                <div class="card-img-top" alt="..." style=" background-size: contain; background: url('<%=request.getContextPath()%>/images/logo1.jpeg') no-repeat center; height: 100%"></div>
                <div class="card-body" style="border: double red;">
                    <h5 class="card-title"
                        style="white-space: nowrap;width: 312px;overflow: hidden;text-overflow: ellipsis;"><%=lot.getProduct().getName()%>
                    </h5>
                    <p class="card-text" style="white-space: nowrap;width: 312px;overflow: hidden;text-overflow: ellipsis;"><%=lot.getProduct().getDescription()%>
                    </p>
                    <% String s = Integer.toString(lot.getProduct().getName().hashCode());%>
                    <a href="${pageContext.request.contextPath}/lot/<%=s%>" class="btn btn-primary"
                       style="border-color: red; background-color: red">Просмотр</a>
                    <div style="display: inline-block; text-align: left; margin-left: 15%; color: red ">Стартовая
                        цена: <%=lot.getProduct().getPrice()%>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </div>

</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="footer"></div>


</body>
</html>
