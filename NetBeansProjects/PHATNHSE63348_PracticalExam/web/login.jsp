<%-- 
    Document   : login
    Created on : Mar 20, 2018, 2:16:03 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <s:head></s:head>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="login" method="post">
            <s:textfield label="ID" name="id"></s:textfield>
            <s:password label="Password" name="password"></s:password>
            <s:submit value="Login"></s:submit>
        </s:form>
    </body>
</html>
