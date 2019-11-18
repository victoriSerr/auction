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
</head>
<header id="main_header" class="header">
    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark primary-color fixed-top">

        <!-- Collapse button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                aria-controls="basicExampleNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Collapsible content -->
        <div class="collapse navbar-collapse" id="basicExampleNav">

            <!-- Links -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <% if (request.getSession().getAttribute("isSignIn") == null) {%>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Вход</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/registration">Регистрация</a>
                </li>

                <%} else {%>
                <!-- Dropdown -->
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/profile">Мой профиль</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Выйти</a>
                </li>
                <%}%>

            </ul>
            <!-- Links -->

            <form class="form-inline">
                <div class="md-form my-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                </div>
            </form>
        </div>
        <!-- Collapsible content -->

    </nav>
    <!--/.Navbar-->
</header>

<footer id='main_footer' class="page-footer font-small blue pt-4 mt-4">

    <!-- Footer Links -->
    <div class="container-fluid text-center text-md-left">

        <!-- Grid row -->
        <div class="row">

            <!-- Grid column -->
            <div class="col-md-6 mt-md-0 mt-3">

                <!-- Content -->
                <h5 class="text-uppercase">Footer Content</h5>
                <p>Here you can use rows and columns here to organize your footer content.</p>

            </div>
            <!-- Grid column -->

            <hr class="clearfix w-100 d-md-none pb-3">

            <!-- Grid column -->
            <div class="col-md-3 mb-md-0 mb-3">

                <!-- Links -->
                <h5 class="text-uppercase">Links</h5>

                <ul class="list-unstyled">
                    <li>
                        <a href="#!">Link 1</a>
                    </li>
                    <li>
                        <a href="#!">Link 2</a>
                    </li>
                    <li>
                        <a href="#!">Link 3</a>
                    </li>
                    <li>
                        <a href="#!">Link 4</a>
                    </li>
                </ul>

            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-3 mb-md-0 mb-3">

                <!-- Links -->
                <h5 class="text-uppercase">Links</h5>

                <ul class="list-unstyled">
                    <li>
                        <a href="#!">Link 1</a>
                    </li>
                    <li>
                        <a href="#!">Link 2</a>
                    </li>
                    <li>
                        <a href="#!">Link 3</a>
                    </li>
                    <li>
                        <a href="#!">Link 4</a>
                    </li>
                </ul>

            </div>
            <!-- Grid column -->

        </div>
        <!-- Grid row -->

    </div>
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href="https://mdbootstrap.com/education/bootstrap/"> MDBootstrap.com</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer --></html>
