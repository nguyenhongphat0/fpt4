<%-- 
    Document   : error
    Created on : Mar 20, 2018, 2:30:32 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Sorry, something went wrong!</h1>
        ${param.msg}
    </body>
</html>
