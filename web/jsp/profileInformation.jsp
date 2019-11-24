<%@ page import="dto.MessageDto" %>
<%@ page import="java.util.List" %>
<%@ page import="services.UserService" %>
<%@ page import="models.Lot" %>
<%@ page import="services.BetService" %><%--
  Created by IntelliJ IDEA.
  User: victory
  Date: 24.11.2019
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="messages">
    <%
        List<MessageDto> list = (List<MessageDto>) request.getSession().getAttribute("messages");
        if (list != null) {
            if (!list.isEmpty()) {
                for (MessageDto message : list) {
    %>
    <div class="media d-block d-md-flex mt-4">
        <div class="media-body text-center text-md-left ml-md-3 ml-0">
            <p class="font-weight-bold my-0">
                <%String s = message.getFromUserLogin();%>
                <a href="${pageContext.request.contextPath}/user/<%=s%> "><%=s%>
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
    <%
            }
        }
    %>
</div>

<div id="lots">
    <%
        List<Lot> lotList = (List<Lot>) request.getSession().getAttribute("lots");
        if (list != null) {
            if (!list.isEmpty()) {
                for (Lot lot : lotList) {
    %>
    <div class="media d-block d-md-flex mt-4">
        <div class="media-body text-center text-md-left ml-md-3 ml-0">
            <p class="font-weight-bold my-0">
                <a href="${pageContext.request.contextPath}/lot/<%=lot.getId().hashCode()%> "><%=lot.getProduct().getName()%>
                </a>
            </p>
            <%if (!lot.getTransactionStatus()){%>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#basicExampleModal">
                Оплатить
            </button>
            <%} else {%>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#basicExampleModal" disabled>
                Оплачено
            </button>
            <%}%>
        </div>
    </div>


    <div class="modal fade" id="basicExampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Оплатить покупку</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Цена: <%=new BetService().findLatest(lot.getId()).getBetValue()%>
                    </p>
                </div>
                <div class="modal-footer">
                    <form method="post" action="${pageContext.request.contextPath}/profile">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="text" name="lotId" value="<%=lot.getId()%>" style="width: 0; height: 0">
                        <button type="submit" class="btn btn-primary">Buy</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%
        }
    } else {
    %>
    <p>Нет лотов</p>
    <%
            }
        }
    %>

</div>


</body>
</html>
