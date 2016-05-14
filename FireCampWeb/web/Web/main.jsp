<%-- 
    Document   : main
    Created on : 08-may-2016, 15:14:03
    Author     : Manuel
--%>

<%@include file="Template/menu.jsp" %>
<table style="width:80%; margin-left: 10%">
    <tr>
        <td>
            <h1>Bienvenido <%= (String) session.getAttribute("firstname") + " " + (String) session.getAttribute("lastname")%>!</h1>
        </td>
    </tr>
    <tr>
        <td>
        <%= (String) session.getAttribute("user")%>            
        </td>
    </tr>
</table>
<div style="height: 250px"></div>

