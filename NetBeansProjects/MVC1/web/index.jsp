<%-- 
    Document   : index
    Created on : Feb 6, 2018, 10:11:10 AM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            response.sendRedirect("login.html");
        %>
    </body>
</html>
