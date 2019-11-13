<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 12.11.2019
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
%>

<form method="post" action="add-new-lot" enctype="multipart/form-data">
    <input type="date" name="sdate" value="<%=dateFormat.format(new Date())%>" min="<%=dateFormat.format(new Date())%>">

    <input type="time" name="stime" value="<%=timeFormat.format(new Date())%>">

    <input type="date" name="fdate" value="<%=dateFormat.format(new Date())%>">

    <input type="time" name="ftime" value="<%=timeFormat.format(new Date())%>"> <br>

    <input type="number" name="startPrice">
    <textarea name="description" ></textarea>
    <input type="text" name="name">


    <input type="file" name="file" multiple> <br>
    <input type="submit" value="save">
</form>

<div></div>

</body>
</html>
