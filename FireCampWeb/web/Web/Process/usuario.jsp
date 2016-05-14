<%-- 
    Document   : usuario
    Created on : 09-may-2016, 5:23:11
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
    String Enviar = request.getParameter("Enviar"); 
    
    if (Enviar.equals("Actualizar Usuario")) 
    {
        String username = request.getParameter("user");    
        String password = request.getParameter("pass");

        if (!password.equals((String) session.getAttribute("pass"))) 
        {
            out.println("<script language='javascript'>window.location='"+request.getContextPath()+"?view=profile&n=1'</script>");        
        }
        else
        {
            _Net net = new _Net();

            String str = "Update user set username = '" + username + "' where id = " + (String) session.getAttribute("id") ;
            Class.forName(net.getDriver());
            Connection con = DriverManager.getConnection(net.getNet(),net.getUserDb(),net.getPassWordDb());

            try
            {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(str);
                con.close();                

                session.setAttribute("user", username);  
                out.println("<script language='javascript'>window.location='?view=profile&n=2'</script>");        
            }
            catch( Exception ex)
            {
                out.println("Error ocurred");
                out.println("Error: " + ex);
                con.close();
            }
        }
    }
    if (Enviar.equals("Actualizar Contraseña")) 
    {           
        String password = request.getParameter("pass");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        if (!password.equals((String) session.getAttribute("pass"))) 
        {
            out.println("<script language='javascript'>window.location='?view=profile&n=1'</script>");        
            
        }
        else if (!pass1.equals(pass2)) 
        {
            out.println("<script language='javascript'>window.location='?view=profile&n=3'</script>");            
        }
        else
        {       
            _Net net = new _Net();

            String str = "Update user set password = md5('" + pass1 + "') where id = " + (String) session.getAttribute("id") ;
            Class.forName(net.getDriver());
            Connection con = DriverManager.getConnection(net.getNet(),net.getUserDb(),net.getPassWordDb());

            try
            {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(str);
                con.close();                

                session.setAttribute("pass", pass1);  
                out.println("<script language='javascript'>window.location='?view=profile&n=2'</script>");        
            }
            catch( Exception ex)
            {
                out.println("Error ocurred");
                out.println("Error: " + ex);
                con.close();
            }    
        }
    }  
    if (Enviar.equals("Actualizar Datos")) 
    {           
        String password = request.getParameter("pass");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        if (!password.equals((String) session.getAttribute("pass"))) 
        {
            out.println("<script language='javascript'>window.location='?view=profile&n=1'</script>");        
            
        }
        else if (!pass1.equals(pass2)) 
        {
            out.println("<script language='javascript'>window.location='?view=profile&n=3'</script>");            
        }
        else
        {       
            _Net net = new _Net();

            String str = "Update user set password = md5('" + pass1 + "') where id = " + (String) session.getAttribute("id") ;
            Class.forName(net.getDriver());
            Connection con = DriverManager.getConnection(net.getNet(),net.getUserDb(),net.getPassWordDb());

            try
            {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(str);
                con.close();                

                session.setAttribute("pass", pass1);  
                out.println("<script language='javascript'>window.location='?view=profile&n=2'</script>");        
            }
            catch( Exception ex)
            {
                out.println("Error ocurred");
                out.println("Error: " + ex);
                con.close();
            }    
        }
    }  
    
    

%>
        
