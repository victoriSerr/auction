<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 12.11.2019
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>addLot</title>
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

</head>
<body>
<div id="header"></div>

<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
%>


<main>
    <div class="jumbotron-fluid">
        <div class=" container-fluidjumbotron-fluid" style="padding: 3%">
            <h2>Добавить лот</h2>
            <br>
            <form id="form" method="post">
                <div>
                    <label for="lot-name">Название</label>
                    <input type="text" class="form-control" id="lot-name" name="name" required>
                    <br>
                    <label for="lot-description">Описание</label>
                    <textarea name="description" class="form-control" id="lot-description"></textarea>
                </div>
                <label>
                    Фотографии
                    <input type="file" id="files" class="form-control-file" name="file" value="Загрузить" multiple required>
                    <br>
                </label>
                <br>
                <label>
                    Дата начала лота
                    <input type="date" name="sdate" class="form-control" value="<%=dateFormat.format(new Date())%>"
                           min="<%=dateFormat.format(new Date())%>">
                </label>
                <br>
                <label>
                    Время начала лота
                    <input type="time" class="form-control" name="stime" value="<%=timeFormat.format(new Date())%>">
                </label>
                <br>
                <label>
                    Дата конца лота
                    <input type="date" name="fdate" class="form-control" value="<%=dateFormat.format(new Date())%>">
                </label>
                <br>
                <label>
                    Время конца лота
                    <input type="time" name="ftime" class="form-control" value="<%=timeFormat.format(new Date())%>">
                </label>
                <br>
                <label for="startPrice">Начальная цена</label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">&#8381;</span>
                    </div>
                    <input type="number" class="form-control" name="startPrice" id="startPrice" min="1" required>
                </div>
                <br>
                <input type="submit" value="save" class="btn btn-outline-primary waves-effect"
                       formenctype="multipart/form-data">
            </form>
        </div>
    </div>
</main>
<div id="footer"></div>

</body>
</html>
