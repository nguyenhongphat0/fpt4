<%-- 
    Document   : search
    Created on : Jan 30, 2018, 7:11:16 AM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="users.UsersDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER}
        </font>
        
        <h1>Search Page</h1>
        <form action="FrontServlet">
            Search Value <input type="text" name="txtSearchValue" value="" /><br>
            <input type="submit" value="Search" name="btnAction" />
        </form>
        <br>
        <c:set var="searchValue" value="${param.txtSearchValue}"></c:set>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"></c:set>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <form action="FrontServlet" method="POST">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="txtUsername" value="${dto.username}" />
                                    </td>
                                    <td><input type="text" name="txtPassword" value="${dto.password}" /></td>
                                    <td>${dto.lastname}</td>
                                    <td>
                                        ${dto.role}
                                        <input type="checkbox" name="chkAdmin" value="ON"
                                            <c:if test="${dto.role}">
                                                checked="checked"
                                            </c:if>
                                        />
                                    </td>
                                    <td>
                                        <c:url var="deleteLink" value="FrontServlet">
                                            <c:param name="btnAction" value="Delete"></c:param>
                                            <c:param name="pk" value="${dto.username}"></c:param>
                                            <c:param name="lastSearchValue" value="${searchValue}"></c:param>
                                        </c:url>
                                        <a href="${deleteLink}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="btnAction" />
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
        </c:if>
        <%--
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<UsersDTO> result  = (List<UsersDTO>)request.getAttribute("SEARCHRESULT");
                if (result != null) {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Lastname</th>
                                <th>Role</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 0;
                                for (UsersDTO dto : result) {
                                    String deleteUrl = "FrontServlet"
                                            + "?btnAction=Delete"
                                            + "&pk="
                                            + dto.getUsername()
                                            + "&lastSearchValue="
                                            + searchValue;
                            %>
                        <form action="FrontServlet">
                            <tr>
                                <td>
                                    <%= ++count %>
                                </td>
                                <td>
                                    <%= dto.getUsername() %>
                                    <input type="hidden" name="txtUsername" value="<%= dto.getUsername() %>" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="<%= dto.getPassword() %>" />
                                </td>
                                <td>
                                    <%= dto.getLastname() %>
                                </td>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON"
                                        <%
                                            if (dto.isRoles()) {
                                        %>
                                                checked="checked"
                                        <%
                                            }
                                        %>
                                           />
                                </td>
                                <td>
                                    <a href="<%= deleteUrl %>">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" />
                                    <input type="hidden" name="lastSearchValue" value="<%= searchValue %>" />
                                </td>
                            </tr>
                        </form>
                            <%
                                }
                            %>
                        </tbody>
                    </table>

                    <%
                } else {
                    %>
                    <h2>No record is matched</h2>
                    <%
                }
            }
        --%>
        <a href="shoppingOnline.html">Buy some books</a>
    </body>
</html>
