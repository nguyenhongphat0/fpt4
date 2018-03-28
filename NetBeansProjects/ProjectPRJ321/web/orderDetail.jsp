<%-- 
    Document   : orderDetail
    Created on : Mar 26, 2018, 9:22:49 PM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page errorPage="errorPage.jsp" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Detail</title>
    </head>
    <body>
        <h1>Order Details</h1>
        <c:set var="customer" value="${requestScope.CUST}"></c:set>
        <c:set var="details" value="${requestScope.DETAIL}"></c:set>
        <table>
            <tr>
                <td>OrderId: ${param.orderID}</td>
                <td>Date: ${param.orderDate}</td>
            </tr>
            <tr>
                <td>Customer: ${customer.fullName}</td>
                <td>Phone: ${customer.phone}</td>
            </tr>
            <tr>
                <td colspan="2">Address: ${customer.address}</td>
            </tr>
        </table>
        Details
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
        <c:url var="backLink" value="SearchOrder.do">
            <c:param name="fromdate" value="${param.fromdate}"></c:param>
            <c:param name="todate" value="${param.todate}"></c:param>
            <c:if test="${not empty param.delivered}">
                <c:param name="delivered" value="true"></c:param>
            </c:if>
        </c:url>
        Total: ${param.total}
        <br>
        <a href="${backLink}">Back to search result</a>
        <c:import url="reference.html"></c:import>
    </body>
</html>
