<%-- 
    Document   : menu
    Created on : 08-may-2016, 17:17:21
    Author     : Manuel
--%>

<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
}

li {
    float: left;
}

li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #ddd;
}

li a.active {
    color: white;
    background-color: #F89A13;
}
</style>

<% 
    try
    {
        String Validation = (String) session.getAttribute("access");  
        
        if(Validation.equals("Null"))
            out.println("<script language='javascript'>window.location='"+request.getContextPath()+"?error=1'</script>");                    
    }
    catch(NullPointerException ex)
    {
        out.println("<script language='javascript'>window.location='"+request.getContextPath()+"?error=1'</script>");                    
    }
%>

<ul>
  <li><a class="active" href="?view=main">Inicio</a></li>
  <li><a href="?view=proyect">Proyectos</a></li>
  <li><a href="?view=task">Mis Tareas</a></li>  
  <li style="float:right" class="active"><a href="?process=logoff">Cerrar Sesión</a></li>
  <li style="float:right" class="active"><a href="?view=profile"><%= (String) session.getAttribute("user")%></a></li>
</ul>
<br /><br />
