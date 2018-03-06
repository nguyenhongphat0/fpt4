<%-- 
    Document   : register.jsp
    Created on : Feb 6, 2018, 8:55:54 AM
    Author     : nguyenhongphat0
--%>

<%@page import="users.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Create new account</h1>
        
        <form action="register" method="POST">
            <c:set var="errors" value="${requestScope.INSERTERROR}"></c:set>
            Username* <input type="text" name="txtUsername">(6 - 30 chars)<br>
            <c:if test="${not empty errors.usernameLengthError}">
                <font color="red">
                    ${errors.usernameLengthError}
                </font>
                <br>
            </c:if>
            Password* <input type="text" name="txtPassword">(6 - 20 chars)<br>
            <c:if test="${not empty errors.passwordLengthError}">
                <font color="red">
                    ${errors.passwordLengthError}
                </font>
                <br>
            </c:if>
            Confirm* <input type="text" name="txtConfirm"><br>
            <c:if test="${not empty errors.confirmPasswordNotMatch}">
                <font color="red">
                    ${errors.confirmPasswordNotMatch}
                </font>
                <br>
            </c:if>
            Fullname* <input type="text" name="txtFullname">(2 - 50 chars)<br>
            <c:if test="${not empty errors.fullnameLengthError}">
                <font color="red">
                    ${errors.fullnameLengthError}
                </font>
                <br>
            </c:if>
            <input type="submit" value="Register" name="btnAction" />
        </form>
        <c:if test="${not empty errors.usernameIsExisted}">
            <font color="red">
                ${errors.usernameIsExisted}
            </font>
                <br>
        </c:if>
        
        
        <%--<form action="FrontServlet" method="POST">
            <%
                RegistrationInsertError errors = (RegistrationInsertError)request.getAttribute("INSERTERROR");
            %>
            Username* <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername") %>">(6 - 30 chars)<br>
            <%
                if (errors != null) {
                    if (errors.getUsernameLengthError() != null) {
            %>
                        <span style="color: red"><%= errors.getUsernameLengthError() %></span><br>
            <%
                    }
                }
            %>
            Password* <input type="text" name="txtPassword">(6 - 20 chars)<br>
            <%
                if (errors != null) {
                    if (errors.getPasswordLengthError() != null) {
            %>
                        <span style="color: red"><%= errors.getPasswordLengthError() %></span><br>
            <%
                    }
                }
            %>
            Confirm* <input type="text" name="txtConfirm"><br>
            <%
                if (errors != null) {
                    if (errors.getConfirmPasswordNotMatch()!= null) {
            %>
                        <span style="color: red"><%= errors.getConfirmPasswordNotMatch()%></span><br>
            <%
                    }
                }
            %>
            Fullname* <input type="text" name="txtFullname" value="<%= request.getParameter("txtFullname") %>">(2 - 50 chars)<br>
            <%
                if (errors != null) {
                    if (errors.getFullnameLengthError() != null) {
            %>
                        <span style="color: red"><%= errors.getFullnameLengthError() %></span><br>
            <%
                    }
                }
            %>
            <input type="submit" value="Register" name="btnAction" />
        </form><br>
        
            <%
                if (errors != null) {
                    if (errors.getUsernameIsExisted()!= null) {
            %>
                        <span style="color: red"><%= errors.getUsernameIsExisted()%></span><br>
            <%
                    }
                }
            %>--%>
    </body>
</html>
