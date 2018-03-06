<%-- 
    Document   : search
    Created on : Mar 6, 2018, 4:57:46 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        Welcome ${sessionScope.LoginStrutsActionForm.username}
        <h2>Search</h2>
        <form action="search.do">
            <input type="text" name="searchvalue" value="" />
            <input type="submit" value="Search" />
        </form>
    </body>
</html>
