<%-- 
    Document   : login
    Created on : Mar 19, 2018, 8:13:37 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="login" method="post">
            <s:textfield label="Username" name="custID"></s:textfield>
            <s:password label="Password" name="password"></s:password>
            <s:submit value="Login"></s:submit>
            <s:reset value="Reset"></s:reset>
        </s:form>
    </body>
</html>
