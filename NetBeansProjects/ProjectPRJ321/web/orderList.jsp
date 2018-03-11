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
        <c:set var="res" value="${requestScope.RES}"></c:set>
        <c:set var="delivered" value="${param.delivered}"></c:set>
        <c:if test="${empty delivered}">
            <c:set var="delivered" value="false"></c:set>
        </c:if>
        <c:if test="${not empty res}">
            Result<br>
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
                        <c:if test="${order.isDeliver eq delivered}">
                            <tr>
                                <td>${counter.count}</td>
                                <td><fmt:formatDate value="${order.orderDate}" pattern="d/M/yyyy"></fmt:formatDate></td>
                                <td><fmt:formatNumber value="${order.total}" type="number"></fmt:formatNumber></td>
                                <td>${order.custID}</td>
                                <td>
                                    <input type="checkbox" name="delivered" value="true" 
                                           <c:if test="${order.isDeliver}">checked="checked"</c:if>
                                    />
                                </td>
                                <td>${order.reason}</td>
                                <td>View</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <form action="SearchOrder.do">
            <input type="hidden" name="fromdate" value="${param.fromdate}" />
            <input type="hidden" name="todate" value="${param.todate}" />
            <c:if test="${delivered}">
                <input type="submit" value="UnDelivered" />
            </c:if>
            <c:if test="${not delivered}">
                <input type="hidden" name="delivered" value="true"/>
                <input type="submit" value="Delivered" />
            </c:if>
        </form>
        <a href="search.html">Search Order</a><br>
        <a href="login.html">Login Page</a><br>
    </body>
</html>
