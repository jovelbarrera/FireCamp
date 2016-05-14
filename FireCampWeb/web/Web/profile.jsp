<%-- 
    Document   : profile
    Created on : 08-may-2016, 21:54:18
    Author     : Manuel
--%>
<%@include file="Template/menu.jsp" %>
<table style="width:80%; margin-left: 10%">
    <tr><td colspan="2"><h1>Perfil de Usuario</h1></td></tr>
    <tr><td colspan="2"><hr /></td></tr>    
    <tr>
        <td style="width: 50%">
            <form action="?process=updateUsername" method="post">
                <table style="width: 90%">
                <tr>
                    <th colspan="2">Actualización de Nombre de Usuario</th>
                </tr>
                <tr>
                    <td>Nombre actual:</td>
                    <td><%= (String) session.getAttribute("user")%></td>
                </tr>
                <tr>
                    <td>Nuevo nombre de usuario:</td>
                    <td><input type="text" name="user" value="<%= (String) session.getAttribute("user")%>" required="true" /></td>
                </tr>                
                <tr>
                    <td>Confirmación de contraseña:</td>
                    <td><input type="password" name="pass" value="" required="true" /></td>
                </tr>    
                <tr>
                    <td colspan="2">
                        <br /><input name="Enviar" type="submit" class="btn btn-warning btn-large" value="Actualizar Usuario" />
                    </td>
                </tr>
                </table>
            </form>
        </td>
        <td style="width: 50%">
            <form action="?process=updateUsername" method="post">
                <table style="width: 90%">
                <tr>
                    <th colspan="2">Actualización de Contraseña</th>
                </tr>
                <tr>
                    <td>Contraseña actual:</td>
                    <td><input type="password" name="pass" value="" required="true" /></td>
                </tr>
                <tr>
                    <td>Nueva contraseña:</td>
                    <td><input type="password" name="pass1" value="" required="true" /></td>
                </tr>                
                <tr>
                    <td>Confirmación de contraseña:</td>
                    <td><input type="password" name="pass2" value="" required="true" /></td>
                </tr>            
                <tr>
                    <td colspan="2">
                        <br /><input name="Enviar" type="submit" class="btn btn-warning btn-large" value="Actualizar Contraseña" />
                    </td>
                </tr>
                </table>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            
        </td>
    </tr>
</table>
<div style="height: 50px"><br /></div>