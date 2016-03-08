<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Player</title>
    </head>
    <body>
        <h1>Add A New Player</h1>
        
        <form name="addForm" action="addPlayer" method="get">
            
            <label> Player Name: </label>
            <input type="text" name="playername" value="" />
            <br>
            <label> College: </label>
            <input type="text" name="college" value="" />
            <br>
            <label> Player Position: </label>
            <input type="text" name="playerposition" value="" />
            <br>
            <label> Age: </label>
            <input type="text" name="age" value="" />
            <br>
            <label> Hometown: </label>
            <input type="text" name="hometown" value="" />
            <br>
            <input type="submit" name="submit" value="Submit"/>
            
        </form>
    </body>
</html>
