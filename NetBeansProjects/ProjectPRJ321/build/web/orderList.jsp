<%-- 
    Document   : orderList
    Created on : Mar 26, 2018, 9:37:06 PM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order List</title>
    </head>
    <body>
        <c:set var="result" value="${requestScope.RES}"></c:set>
        <h1>Order List</h1>
        <fmt:parseDate var="fromdate" value="${param.fromdate}" pattern="yyyy-MM-dd"></fmt:parseDate>
        <fmt:parseDate var="todate" value="${param.todate}" pattern="yyyy-MM-dd"></fmt:parseDate>
        From <fmt:formatDate value="${fromdate}" pattern="dd/MM/yyyy"></fmt:formatDate>
        to <fmt:formatDate value="${todate}" pattern="dd/MM/yyyy"></fmt:formatDate>
        <c:if test="${not empty result}">
            <h2>Result</h2>
            <form action="ChangeDeliveredStatus.do">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Customer</th>
                            <th>Action</th>
                            <th>Reason</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${result}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${order.orderDate}</td>
                                <td>
                                    <fmt:formatNumber value="${order.total}"></fmt:formatNumber>
                                </td>
                                <td>${order.custID}</td>
                                <td>
                                    <input type="checkbox" name="orderID" value="${order.orderID}" />
                                </td>
                                <td>
                                    <input type="text" name="${order.orderID}reason" value="${order.reason}" />
                                </td>
                                <td>
                                    <c:url var="viewLink" value="GetDetail.do">
                                        <c:param name="fromdate" value="${param.fromdate}"></c:param>
                                        <c:param name="todate" value="${param.todate}"></c:param>
                                        <c:if test="${not empty param.delivered}">
                                            <c:param name="delivered" value="true"></c:param>
                                        </c:if>
                                        <c:param name="custID" value="${order.custID}"></c:param>
                                        <c:param name="orderID" value="${order.orderID}"></c:param>
                                        <c:param name="total" value="${order.total}"></c:param>
                                        <c:param name="orderDate" value="${order.orderDate}"></c:param>
                                    </c:url>
                                    <a href="${viewLink}">View</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type="hidden" name="fromdate" value="${param.fromdate}" />
                <input type="hidden" name="todate" value="${param.todate}" />
                <c:if test="${empty param.delivered}">
                    <input type="submit" value="Delivered" />
                </c:if>
                <c:if test="${not empty param.delivered}">
                    <input type="submit" value="UnDelivered" />
                    <input type="hidden" name="delivered" value="true" />
                </c:if>
            </form>
        </c:if>
    </body>
</html>
