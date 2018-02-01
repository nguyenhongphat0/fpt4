<%-- 
    Document   : search
    Created on : Jan 30, 2018, 7:11:16 AM
    Author     : nguyenhongphat0
--%>

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
            Welcome, 
            <%
                String username = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    username = cookies[cookies.length - 2].getName();
                }
            %>
            <%= username %>
        </font>
        
        <%
            String searchValue = request.getParameter("txtSearchValue");
        %>
        <h1>Search Page</h1>
        <form action="FrontServlet">
            Search Value <input type="text" name="txtSearchValue" value="<%= searchValue == null ? "" : searchValue %>" /><br>
            <input type="submit" value="Search" name="btnAction" />
        </form>
        <br>
        
        <%
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
        %>
        <a href="shoppingOnline.html">Buy some books</a>
    </body>
</html>
