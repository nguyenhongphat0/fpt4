<%-- 
    Document   : login
    Created on : Mar 6, 2018, 6:30:49 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Welcome User, enter your username and password to login!</h1>
        <form action="Login.do" method="POST">
            Username <input type="text" name="username" value="" /><br>
            Password <input type="password" name="password" value="" /><br>
            <input type="submit" value="Login" /><br>
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
