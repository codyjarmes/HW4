

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ClevelandIndians"%>
<% ClevelandIndians player = (ClevelandIndians) request.getAttribute ("player"); %>

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Player</title>
        <link rel="stylesheet" type="text/css" href="./style.css" />
    </head>
    <body>
        <h1>Update A Player Record</h1>
        
        <form name="updateForm" action="updatePlayer" method="get">
        
          
            <table class="update"> 
            
            <tr>
                <td class="right"> Player ID: </td>
                <td><input type="text" name="PlayerID" value="<%=player.getPlayerID() %>" readonly/></td>
            </tr>
                
            <tr>
                <td class="right"> Player Name: </td>
                <td><input type="text" name="PlayerName" value="<%=player.getPlayerName() %>"/></td>
            </tr>
            
            <tr>
                <td class="right"> College: </td>
                <td><input type="text" name="College" value="<%=player.getCollege() %>"/></td>
            </tr>

            <tr>
                <td class="right"> Age: </td>
                <td><input type="text" name="Age" value="<%=player.getAge() %>"/></td>
            </tr>
            
            <tr>
                <td class="right"> Hometown: </td>
                <td><input type="text" name="Hometown" value="<%=player.getHometown() %>"/></td>
            </tr>
        </table>
        <br>
          
            
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>
    
        </form>
    
    </body>
    
</html>
