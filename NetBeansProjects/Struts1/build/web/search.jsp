<%-- 
    Document   : search
    Created on : Mar 6, 2018, 4:57:46 PM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        Welcome ${sessionScope.LoginStrutsActionForm.username}
        <h2>Search</h2>
        <form action="search.do">
            <input type="text" name="searchvalue" value="${param.searchvalue}" />
            <input type="submit" value="Search" />
        </form>
            <c:set var="searchvalue" value="${param.searchvalue}"></c:set>
            <c:if test="${not empty searchvalue}">
                <c:set var="result" value="${requestScope.SearchStrutsActionForm.list}"></c:set>
                <c:if test="${not empty result}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Fullname</th>
                                <th>Role</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${result}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                    <td>${user.lastname}</td>
                                    <td>${user.role}</td>
                                    <td>
                                        <c:url var="deleteLink" value="delete.do">
                                            <c:param name="pk" value="${user.username}"></c:param>
                                            <c:param name="searchvalue" value="${searchvalue}"></c:param>
                                        </c:url>
                                        <a href="${deleteLink}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty result}">
                    <h2 style="color: red">No result found!</h2>
                </c:if>
            </c:if>
    </body>
</html>
