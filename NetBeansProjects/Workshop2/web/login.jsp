<%-- 
    Document   : login
    Created on : Mar 17, 2018, 4:33:47 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <s:head></s:head>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="login" method="post">
            <s:textfield name="userId" label="User ID"></s:textfield>
            <s:password name="password" label="Password"></s:password>
            <s:submit value="Login"></s:submit>
        </s:form>
    </body>
</html>
