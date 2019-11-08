<%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 27.10.2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>profile</title>
</head>
<body>

    hi,
<%= request.getSession().getAttribute("login") %>
<form action="${pageContext.request.contextPath}/logout" method="get">
<input type="submit" value="logout" >
</form>
</body>
</html>
