<%-- 
    Document   : register
    Created on : Mar 13, 2018, 9:34:06 PM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .warning {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>
        <c:set var="errors" value="${requestScope.ERRORS}"></c:set>
        <form action="Register.do" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Customer ID: </td>
                        <td><input type="text" name="custID" value="${param.custID}" /></td>
                        <td class="warning">${errors.idLength}${errors.duplicatePK}</td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" value="" /> </td>
                        <td class="warning">${errors.passwordLength}</td>
                    </tr>
                    <tr>
                        <td>Confirm password: </td>
                        <td><input type="password" name="confirm" value="" /> </td>
                        <td class="warning">${errors.confirmNotMatch}</td>
                    </tr>
                    <tr>
                        <td>Customer Name: </td>
                        <td><input type="text" name="custName" value="${param.custName}" /></td>
                        <td class="warning">${errors.nameLength}</td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="lastName" value="${param.lastName}" /></td>
                        <td class="warning">${errors.lastNameLength}</td>
                    </tr>
                    <tr>
                        <td>Middle Name: </td>
                        <td><input type="text" name="middleName" value="${param.middleName}" /></td>
                        <td class="warning">${errors.middleNameLength}</td>
                    </tr>
                    <tr>
                        <td>Address: </td>
                        <td><input type="text" name="address" value="${param.address}" /></td>
                        <td class="warning">${errors.addressLength}</td>
                    </tr>
                    <tr>
                        <td>Phone: </td>
                        <td><input type="text" name="phone" value="${param.phone}" /></td>
                        <td class="warning">${errors.phoneLength}${errors.phoneFormat}</td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        Click <a href="login.html">here</a> to login!
    </body>
</html>
