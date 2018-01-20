<%-- 
    Document   : jsp.jsp
    Created on : Jan 9, 2018, 10:36:35 PM
    Author     : nguyenhongphat0
--%>

<%@page import="java.util.Date"%>
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
            out.write(new Date().toString());
            %>
    </body>
</html>
