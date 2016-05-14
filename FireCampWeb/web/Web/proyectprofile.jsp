<%-- 
    Document   : proyectprofile
    Created on : 09-may-2016, 22:18:36
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
            
            String idp = request.getParameter("idp"); 
            String type = (String) session.getAttribute("type");
            
            if (type.equals("Cliente")) 
            {
                String str = "select * from project as p "
                        + "inner join user as u on p.id = u.id "
                        + "where p.id = " + idp;

                Class.forName(net.getDriver());
                Connection con = DriverManager.getConnection(net.getNet(),net.getUserDb(),net.getPassWordDb());
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(str);
                 
                while(rs.next())            
                {
                    out.print("<table class='project'>"
                            + "<tr><td style='width: 20%'><b>Proyecto: </td><td style='width: 85%'>" + rs.getString("name") + "</b></td>"
                            + "<tr><td>Descripción: </td><td>" + rs.getString("description") + "</b></td></tr>"
                            + "<tr><td>Proyect Manager: </td><td>" + rs.getString("firstname") + " " + rs.getString("lastname") + "</b></td></tr>"
                            + "<tr><td colspan='2'><hr /></td></tr>"                            
                            + "<tr><td colspan='2'>"
                            + "<table style='width: 100%'>"
                            + "<tr><td style='width: 90%'><h2>Team FireCamp</h2></td><td><input type='submit' value='+' class='btn btn-success' /></td></tr>"
                            + "</table>"
                            + "</td></tr>"
                            + "<tr><td colspan='2'><hr /></td></tr>"                            
                            + "<tr><td colspan='2'>"
                            + "<table style='width: 100%'>"
                            + "<tr><td style='width: 90%'><h2>Fases de Proyecto</h2></td><td><input type='submit' value='+' class='btn btn-success' /></td></tr>"
                            + "</table>"
                            + "</td></tr>"
                            + "<tr><td colspan='2'><hr /></td></tr>"                            
                            + "<tr><td colspan='2'>"
                            + "<table style='width: 100%'>"
                            + "<tr><td style='width: 90%'><h2>FireCamps</h2></td><td><input type='submit' value='+' class='btn btn-success' /></td></tr>"
                            + "</table>"
                            + "</td></tr>"
                            + "</table>");
                }                    
            }
          %>
        </td>
        <div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>
    </tr>
</table>
<div style="height: 100px"></div>
