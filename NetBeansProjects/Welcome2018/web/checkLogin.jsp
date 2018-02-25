<%-- 
    Document   : login
    Created on : Feb 24, 2018, 3:55:19 PM
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
        <jsp:useBean id="login" scope="session" class="beans.LoginBean"></jsp:useBean>
        <jsp:setProperty name="login" property="*"></jsp:setProperty>
        <% if (login.checkLogin()) { %>
            <h1>Welcome <%= login.getUserId() %></h1>
        <% } else { %>
            <h1>Login</h1>
            <p style="color: red">Incorrect ID or password</p>
            <form action="checkLogin.jsp" method="POST">
                <input type="text" name="userId" value="${sessionScope.login.userId}" placeholder="ID" />
                <input type="password" name="password" value="" placeholder="Password" />
                <input type="submit" value="Login" />
            </form>
        <% } %>
    </body>
</html>
