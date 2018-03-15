<%-- 
    Document   : orderList
    Created on : Mar 11, 2018, 10:44:43 PM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order List</title>
    </head>
    <body>
        <fmt:parseDate var="fromdate" value="${param.fromdate}" pattern="yyyy-MM-dd"></fmt:parseDate>
        <fmt:parseDate var="todate" value="${param.todate}" pattern="yyyy-MM-dd"></fmt:parseDate>
            <h1>Order List</h1>
            From
        <fmt:formatDate value="${fromdate}" pattern="d/M/yyyy"></fmt:formatDate>
            To
        <fmt:formatDate value="${todate}" pattern="d/M/yyyy"></fmt:formatDate>
        <br>
        <font color="red">${requestScope.msg}</font>
        <font color="red">${requestScope.changeStatusMsg}</font>
        <c:set var="res" value="${requestScope.RES}"></c:set>
        <c:if test="${not empty res}">
            Result<br>
            <form action="ChangeDeliveredStatus.do" method="GET">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Customer</th>
                            <th>Action</th>
                            <th>Reason</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${res}" varStatus="counter">
                            <fmt:formatDate var="orderDate" value="${order.orderDate}" pattern="d/M/yyyy"></fmt:formatDate>
                            <c:url var="viewLink" value="GetDetail.do">
                                <c:param name="orderID" value="${order.orderID}"></c:param>
                                <c:param name="custID" value="${order.custID}"></c:param>
                                <c:param name="total" value="${order.total}"></c:param>
                                <c:param name="orderDate" value="${orderDate}"></c:param>
                                <c:param name="fromdate" value="${param.fromdate}"></c:param>
                                <c:param name="todate" value="${param.todate}"></c:param>
                                <c:if test="${not empty param.delivered}">
                                    <c:param name="delivered" value="true"></c:param>
                                </c:if>
                            </c:url>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${orderDate}</td>
                                <td><fmt:formatNumber value="${order.total}" type="number"></fmt:formatNumber></td>
                                <td>${order.custID}</td>
                                <td>
                                    <input type="checkbox" name="orderID" value="${order.orderID}" />
                                </td>
                                <td>
                                    <input type="text" name="${order.orderID}reason" value="${order.reason}" />
                                </td>
                                <td><a href="${viewLink}">View</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type="hidden" name="fromdate" value="${param.fromdate}" />
                <input type="hidden" name="todate" value="${param.todate}" />
                <c:if test="${not empty param.delivered}">
                    <input type="submit" value="UnDelivered" />
                    <input type="hidden" name="delivered" value="true"/>
                </c:if>
                <c:if test="${empty param.delivered}">
                    <input type="submit" value="Delivered" />
                </c:if>
            </form>
        </c:if>
        <jsp:include page="reference.html"></jsp:include>
    </body>
</html>
