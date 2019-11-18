<%@ page import="models.Lot" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 07.11.2019
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Lot</title>
    <script type='text/jsp' src="<%=request.getContextPath()%>/jsp/main.jsp"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../js/jquery.downCount.js" type="text/javascript"></script>

    <script>
        $(function () {
            $("#header").load("<%=request.getContextPath()%>/jsp/main.jsp #main_header");
            $("#footer").load("<%=request.getContextPath()%>/jsp/main.jsp #main_footer");
        });
    </script>
    <link rel="stylesheet" href="../css/style.css">
    <%--    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
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

    <% Lot lot = (Lot) request.getSession().getAttribute("lot");%>
    <script type="text/javascript">
        // здесь нужная дата в формате гггг-мм-дд чч:мм:сс
        var deadline = '<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lot.getFinishDate())%>';
        // var deadline = '2020-08-20 00:00:00';

    </script>
</head>
<body>
<div id="header"></div>

<main>
    <div class="container" style="background: #2332;
    padding-bottom: 15px;
    padding-top: 15px;">
        <div class="row featurette" style="height: 70%; width: 100%; margin: auto">
            <div class="col-md-7 order-md-2">

                <div id="lot_name" style="text-align: center">
                    <span><%=lot.getProduct().getName()%></span>
                    <hr>
                </div>

                <%String s = request.getSession().getAttribute("currentPrice") != null ? request.getSession().getAttribute("currentPrice").toString() : lot.getProduct().getPrice().toString();%>
                <p>Текущая цена:<%=s%> &#8381;
                </p>

                <form method="get">
                    <label for="bet_input">Минимальная ставка : </label>

                    <input id='bet_input' type="number" name="bet" required value="<%=Long.parseLong(s) + 1%>"
                           min="<%=Long.parseLong(s) + 1%>">
                    <button type="submit"
                            class="btn btn-orange" <%if (request.getSession().getAttribute("isSignIn") == null) {%>
                            formaction="${pageContext.request.contextPath}/login" <%} else {%>
                            onClick="window.location.reload()"<%}%>>Сделать ставку
                    </button>
                </form>
                <hr>
                <div style="text-align: center;">
                    <span id="lot_description">
                        <%=lot.getProduct().getDescription()%>
                     </span>
                </div>
                <hr>
                <div>
                    <span> крайняя ставка от <%=request.getSession().getAttribute("userWithLatestBet")%> <%request.getSession().removeAttribute("userWithLatestBet");%>
                            <span style="color: red">
                                <div class="countdown">
                                    <span class="days">00</span>
                                    <span> days </span>
                                    <span class="hours">00</span>
                                    <span> h </span>
                                    <span class="minutes">00</span>
                                    <span> m </span>
                                    <span class="seconds"></span>
                                    <span> s </span>
                                </div>
                                    <script type="text/javascript">
                                    $('.countdown').downCount({
                                            date: deadline,
                                        },
                                        function () {
                                            /* действие после завершения таймера */
                                            alert("Время истекло!");
                                        });
                                    </script>
                            </span>(<%=lot.getFinishDate()%>)
                    </span>
                </div>
            </div>
            <div class="col-md-5 order-md-1" style="border-right-style: groove">
                <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner" style="height: 100%; background-color: darkgray">

                        <%--                        <% Lot lot = (Lot) request.getSession().getAttribute("lot");%>--%>

                        <div class="carousel-item active" data-interval="100000000000000000">
                            <div class="d-block w-100"
                                 style="height: 100%; background: url('<%=request.getContextPath()%>/uploads/<%=lot.getProduct().getImages().get(0)%>') no-repeat center; background-size: contain"></div>
                        </div>

                        <%for (String fileName : lot.getProduct().getImages().subList(1, lot.getProduct().getImages().size())) {%>
                        <div class="carousel-item " data-interval="100000000000000000">
                            <div class="d-block w-100"
                                 style="height: 100%; background: url('<%=request.getContextPath()%>/uploads/<%=fileName%>') no-repeat center; background-size: contain"></div>
                        </div>
                        <%}%>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>

        </div>
    </div>

</main>

<div id="footer"></div>

</body>
</html>