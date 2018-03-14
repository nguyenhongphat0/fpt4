<%-- 
    Document   : orderDetail
    Created on : Mar 12, 2018, 7:44:33 AM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
        <style>
            .cust-info td {
                padding-right: 50px;
            }
        </style>
    </head>
    <body>
        <h1>Order Details</h1>
        <c:set var="customer" value="${requestScope.CUST}"></c:set>
        <c:set var="details" value="${requestScope.DETAIL}"></c:set>
        <c:if test="${not empty customer}">
            <table border="0" class="cust-info">
                <tbody>
                    <tr>
                        <td>OrderID: ${param.orderID}</td>
                        <td>Date: ${param.orderDate}</td>
                    </tr>
                    <tr>
                        <td>Customer: ${customer.fullName}</td>
                        <td>Phone: ${customer.phone}</td>
                    </tr>
                    <tr>
                        <td colspan="2">Address: ${customer.address}</td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${not empty details}">
            Details<br>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="detail" items="${details}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${detail.productID}</td>
                            <td>${detail.quantity}</td>
                            <td>${detail.unitPrice}</td>
                            <td>${detail.total}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            Total: ${param.total}
        </c:if>
        <c:if test="${empty details}">
            No detail to view
        </c:if>
        <br>
        <c:url var="searchLink" value="SearchOrder.do">
            <c:param name="fromdate" value="${param.fromdate}"></c:param>
            <c:param name="todate" value="${param.todate}"></c:param>
            <c:if test="${not empty param.delivered}">
                <c:param name="delivered" value="true"></c:param>
            </c:if>
        </c:url>
        <a href="${searchLink}">Back to search result</a>
        <jsp:include page="reference.html"></jsp:include>
    </body>
</html>
