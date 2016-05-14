<%-- 
    Document   : index
    Created on : 26-abr-2016, 18:10:20
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <%@include file="Web/Template/libs.jsp" %>
        </head>        
        <body>
            <%@include file="Web/Template/header.jsp" %>   <br /><br />
            <%@include file="Web/engine.jsp" %>  
            <%@include file="Web/Template/footer.jsp" %>  
        </body>
    </html>
</f:view>
