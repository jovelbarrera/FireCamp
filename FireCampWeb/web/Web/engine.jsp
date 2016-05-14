<%-- 
    Document   : engine
    Created on : 26-abr-2016, 18:29:41
    Author     : Manuel
--%>
<%@page import="Config._Security"%>
<%  
    
    if (request.getParameter("view") != null) 
    {
        String view = request.getParameter("view");
        
        if (view.equals("main")) 
            { %><%@include file="main.jsp" %><% }

        else if (view.equals("proyect")) 
            { %><%@include file="proyect.jsp" %><% } 

        else if (view.equals("task")) 
            { %><%@include file="task.jsp" %><% } 

        else if (view.equals("profile")) 
            { %><%@include file="profile.jsp" %><% } 

        else if (view.equals("projectProfile")) 
            { %><%@include file="proyectprofile.jsp" %><% } 


    }
    else if (request.getParameter("process") != null) 
    {
        String process = request.getParameter("process");        

        if (process.equals("login")) 
        { %><%@include file="Process/autentication.jsp" %><% }
        
        else if (process.equals("logoff")) 
        { %><%@include file="Process/logoff.jsp" %><% }   

        else if (process.equals("updateUsername")) 
        { %><%@include file="Process/usuario.jsp" %><% }   

        else    
        {
            //out.println("Neles");
        }
    } 
    else
    {
        %><%@include file="login.jsp" %><%
    }
%>