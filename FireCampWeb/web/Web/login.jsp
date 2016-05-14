<%-- 
    Document   : main
    Created on : 08-may-2016, 14:48:02
    Author     : Manuel
--%>

<form action='?process=login' method='post'>
<table style="width:80%; margin-left: 10%">
    <tr>
        <td><h1>Inicio de Sesión</h1><br /><br /></td>        
    </tr>
    <tr>
        <td>
            Usuario: <br /><br />
            <input type='text'  class="form-control" name="username" value='' required="true" /><br /><br />
        </td>
    </tr>
    <tr>
        <td>
            Contraseña:<br /><br />
            <input type='password'  class="form-control" name="password" value='' required="true" /><br /><br />  
        </td>
    </tr>    
    <tr>
        <td><br />
            <input type='submit' name="Enviar" value='Ingresar' class="btn btn-warning btn-large" /><br /><br />  
        </td>
    </tr>            
</table>
</form>
