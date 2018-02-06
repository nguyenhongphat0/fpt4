<%-- 
    Document   : viewcart
    Created on : Feb 6, 2018, 7:09:10 AM
    Author     : nguyenhongphat0
--%>

<%@page import="java.util.Map"%>
<%@page import="session.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your cart includes</h1>
        <%
            // 1. Den cho lay gio hang
            if (session != null) {
                // 2. Lay cai gio
                CartObject cart = (CartObject)session.getAttribute("CART");
                if (cart != null) {
                    // 3. Lay hang trong gio
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        %>
                        <a href="FrontServlet?btnAction=Checkout">Check out</a>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <form action="FrontServlet">
                            <tbody>
                                <%
                                    int count = 0;
                                    for (Map.Entry<String, Integer> item : items.entrySet()) {
                                %>
                                <tr>
                                    <td>
                                        <%= ++count %>
                                    </td>
                                    <td>
                                        <%= item.getKey() %>
                                    </td>
                                    <td>
                                        <%= item.getValue() %>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkItem" value="<%= item.getKey() %>" />
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                <tr>
                                    <td colspan="3"><a href="shoppingOnline.html">Add more books to your cart</a></td>
                                    <td><input type="submit" value="Remove" name="btnAction"></td>
                                </tr>
                            </tbody>
                            </form>
                        </table>

        <%
                    return;
                }
            }   
        }
        %>
        <h2>Your cart is not existed!!!!</h2>
    </body>
</html>
