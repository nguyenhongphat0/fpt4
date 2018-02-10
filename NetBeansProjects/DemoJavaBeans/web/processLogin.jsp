<%-- 
    Document   : processLogin
    Created on : Feb 8, 2018, 7:08:17 AM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="login" class="beans.LoginBean" scope="session" />
    <%-- 
        <jsp:useBean id="login" class="beans.LoginBean" />
        <jsp:setProperty name="login" property="username" value='<%= request.getParameter("username") %>' />
        <jsp:setProperty name="login" property="password" value='<%= request.getParameter("password") %>' />
    --%>
    <%-- 
        <jsp:setProperty name="login" property="username" param="username" />
        <jsp:setProperty name="login" property="password" param="password" />
    --%>
    <%-- 
        <jsp:setProperty name="login" property="username" />
        <jsp:setProperty name="login" property="password" />
    --%>
        <jsp:setProperty name="login" property="*" />
        <%
            if (login.checkLogin()) {
                %>
                <jsp:forward page="search.jsp"></jsp:forward>
        <%
            }
            System.out.println("Chay toi day");
        %>
        <jsp:forward page="invalid.html"/>
        
        Test: <br>
        Username: <jsp:getProperty name="login" property="username" /><br>
        Password: <jsp:getProperty name="login" property="password" /><br>
    </body>
</html>
