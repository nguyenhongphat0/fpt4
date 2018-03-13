<%-- 
    Document   : register
    Created on : Mar 13, 2018, 4:40:57 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Create new account</h1>
        <s:form action="createuser">
            <s:textfield name="username" label="Username"></s:textfield>
            <s:label value="chars: 6 - 20"></s:label>
            <s:textfield name="password" label="Password"></s:textfield>
            <s:label value="chars: 6 - 30"></s:label>
            <s:textfield name="confirm" label="Confirm"></s:textfield>
            <s:textfield name="lastname" label="Lastname"></s:textfield>
            <s:label value="chars: 2 - 50"></s:label>
            <s:submit value="Submit"></s:submit>
        </s:form>
    </body>
</html>
