<%-- 
    Document   : logoff
    Created on : 08-may-2016, 19:18:27
    Author     : Manuel
--%>
<%@page import="javax.jms.Session"%>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/?error=3");
%>