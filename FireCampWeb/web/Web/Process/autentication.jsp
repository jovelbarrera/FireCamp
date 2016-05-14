<%-- 
    Document   : autentication
    Created on : 08-may-2016, 15:00:46
    Author     : Manuel
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Config._Security"%>
<%@page import="Config._Net"%>

<% 
    
    _Security security = new _Security();
    
    if (request.getParameter("username") == null || request.getParameter("password") == null ) 
    {
            out.println("<script language='javascript'>window.location='"+request.getContextPath()+"?error=1'</script>");                    
    }
    
    String username = request.getParameter("username");    
    String password = request.getParameter("password");
    _Net net = new _Net();

    String str = "select * from user where username = '" + username + "' and password = md5('" + password + "')";
    Class.forName(net.getDriver());
    Connection con = DriverManager.getConnection(net.getNet(),net.getUserDb(),net.getPassWordDb());

    try
    {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(str);
        if(!rs.next())
        {
            out.println("<script language='javascript'>window.location='"+request.getContextPath()+"?error=2'</script>");        
        }
        
        session.setAttribute("id", rs.getString("id"));
        session.setAttribute("user", rs.getString("username"));
        session.setAttribute("firstname", rs.getString("firstname"));
        session.setAttribute("lastname", rs.getString("lastname"));
        session.setAttribute("organization", rs.getString("organization"));
        session.setAttribute("pass", request.getParameter("password"));
        session.setAttribute("type", rs.getString("position"));
        session.setAttribute("access", "true");

        con.close();
        out.println("<script language='javascript'>window.location='?view=main'</script>");        
    }
    catch( Exception ex)
    {
        out.println("Error ocurred");
        out.println("Error: " + ex);
        con.close();
    }

%>
        