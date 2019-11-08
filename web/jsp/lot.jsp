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
</head>
<body>


<div id="header"></div>

<div class="main_part" style="position: relative; width: 90%; height: 90%; top: 102px; margin: auto">

    <div class="container" style="background: #2332;
    padding-bottom: 15px;
    padding-top: 15px;">
        <div class="row featurette" style="height: 70%; width: 100%; margin: auto">
            <div class="col-md-7 order-md-2">

                <p>Текущая цена:</p>
                <input type="text" name="bet">
                <input type="button" value="Сделать савку">
            </div>

            <div class="col-md-5 order-md-1" style="border-right-style: groove">
                <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner" style="height: 100%; background-color: darkgray">
                        <div class="carousel-item active" data-interval="100000000000000000">
                            <div class="d-block w-100"
                                 style="height: 100%; background: url(<%=request.getContextPath()%>/images/logo1.jpeg) no-repeat center;"></div>
                        </div>

                        <div class="carousel-item "  data-interval="100000000000000000">
                            <div class="d-block w-100"
                                 style="height: 100%; background: url(<%=request.getContextPath()%>/images/logo.png) no-repeat center;"></div>
                        </div>
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

</div>

<div id="footer"></div>

</body>
</html>