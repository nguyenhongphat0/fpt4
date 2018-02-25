<%-- 
    Document   : search
    Created on : Feb 25, 2018, 8:03:29 PM
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
        Welcome, ${login.userId}
        <jsp:useBean id="login" scope="session" class="beans.LoginBean" />
        <jsp:setProperty name="login" property="*" />
        <h1>Search</h1>
        <form action="search.jsp">
            <input type="text" name="search" value="${sessionScope.login.search}" />
            <input type="submit" value="Search" />
        </form>
        <%= login.search() %>
    </body>
</html>
