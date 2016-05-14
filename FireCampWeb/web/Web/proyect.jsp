<%-- 
    Document   : proyect
    Created on : 08-may-2016, 19:41:12
    Author     : Manuel
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Config._Net"%>
<%@page import="Config._Security"%>
<%@include file="Template/menu.jsp" %>
<table style="width:80%; margin-left: 10%">
    <tr>
        <td>
            <h1>Mis Proyectos </h1>
        </td>
    </tr>
    <tr>
        <td>
          <%
            _Security security = new _Security();                
            _Net net = new _Net();
            String type = (String) session.getAttribute("type");
            
            if (type.equals("Cliente")) 
            {
                String str = "select * from project as p "
                        + "inner join user as u on p.id = u.id "
                        + "where p.clientId = " + (String) session.getAttribute("id");

                Class.forName(net.getDriver());
                Connection con = DriverManager.getConnection(net.getNet(),net.getUserDb(),net.getPassWordDb());
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(str);
                 
                while(rs.next())            
                {
                    out.print("<table class='project'>"
                            + "<tr><td style='width: 20%'><b>Proyecto: </td><td style='width: 70%'>" + rs.getString("name") + "</b></td>"
                            + "<td rowspan='3'>"
                            + "<form action='?view=projectProfile' method='post'>"
                            + "<input type='hidden' name='idp' value='" +rs.getString("p.id") +"' />"
                            + "<input type='submit' name='Enviar' value='Ver Detalles' class='btn btn-warning btn-large' />"
                            + "</form>"
                            + "</td></tr>"
                            + "<tr><td>Descripción: </td><td>" + rs.getString("description") + "</b></td></tr>"
                            + "<tr><td>Proyect Manager: </td><td>" + rs.getString("firstname") + " " + rs.getString("lastname") + "</b></td></tr>"
                            + "</table>");
                }                    
            }
          %>
        </td>
    </tr>
</table>
<div style="height: 100px"></div>
