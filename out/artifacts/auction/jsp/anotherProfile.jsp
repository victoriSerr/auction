<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 20.11.2019
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=request.getSession().getAttribute("currLogin")%></title>
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
    <link rel="icon" href="<%=request.getContextPath()%>/images/logo.png" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

    <script>
        $('#message').blur(function()          //whenever you click off an input element
        {
            if( !$(this).val() ) {                      //if it is blank.
                $('#button').attr("disabled", 'disabled');
            }
        });
    </script>
</head>
<body>
<div id="header"></div>

<main>

    <div class="col-10" >
        <div id="another_profile">
            <H1><%=request.getSession().getAttribute("currLogin")%> <%request.getSession().removeAttribute("currLogin");%>
            </H1>
            <form method="post">
                <label for="message">Сообщение</label>
                    <textarea name="message" class="form-control" id="message" required></textarea>
                <br>
                <input type="submit" value="Отправить сообщение" id="button" class="btn btn-outline-primary waves-effect"
                    <%if (request.getSession().getAttribute("isSignIn") == null) {%>
                       formaction="${pageContext.request.contextPath}/login" <%}%>>
            </form>
        </div>
    </div>
</main>
<div id="footer"></div>

</body>
</html>
