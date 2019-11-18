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
        window.onload = function (ev) {

        }
    </script>

</head>
<body>
<div id="header"></div>

<main>

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
                    <div class="card-img-top" alt="..."
                         style="  background: url('<%=request.getContextPath()%>/uploads/<%=lot.getProduct().getImages().get(0)%>') no-repeat center; height: 100%; background-size: contain; "></div>
                    <div class="card-body" style="border: double red;">
                        <h5 class="card-title"
                            style="white-space: nowrap;width: 312px;overflow: hidden;text-overflow: ellipsis;"><%=lot.getProduct().getName()%>
                        </h5>
                        <p class="card-text"
                           style="white-space: nowrap;width: 312px;overflow: hidden;text-overflow: ellipsis;"><%=lot.getProduct().getDescription()%>
                        </p>
                        <% String s = Integer.toString(lot.getId().hashCode());%>
                        <a href="${pageContext.request.contextPath}/lot/<%=s%>" class="btn btn-primary"
                           style="border-color: red; background-color: red">Просмотр</a>
                        <%if (lot.getStatus()) {%>
                        <div style="display: inline-block; text-align: left; color: red ">Завершен</div>
                        <%} else {%>
                        <div style="display: inline-block; text-align: left; color: red ">Стартовая
                            цена: <%=lot.getProduct().getPrice()%>
                        </div>
                        <%}%>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
</main>
<div id="footer"></div>


</body>
</html>
