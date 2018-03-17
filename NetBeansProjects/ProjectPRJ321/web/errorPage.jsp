<%-- 
    Document   : errorPage
    Created on : Mar 17, 2018, 2:43:21 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Sorry, something went wrong</h1>
        ${msg}
    </body>
</html>
