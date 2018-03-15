<%-- 
    Document   : shoping
    Created on : Mar 14, 2018, 9:55:50 AM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoping</title>
    </head>
    <body>
        <h1>Shoping Page!</h1>
        <c:set var="res" value="${requestScope.RES}"></c:set>
        <c:if test="${not empty res}">
            <h2>Books</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${res}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${book.bookID}</td>
                            <td>${book.title}</td>
                            <td>${book.price}</td>
                            <td>${book.quantity}</td>
                            <c:url var="atcLink" value="AddBookToCart.do">
                                <c:param name="bookID" value="${book.bookID}"></c:param>
                                <c:param name="title" value="${book.title}"></c:param>
                                <c:param name="price" value="${book.price}"></c:param>
                            </c:url>
                            <td><a href="${atcLink}">Add to cart</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:set var="cart" value="${sessionScope.CART}"></c:set>
        <c:set var="cust" value="${sessionScope.CUST}"></c:set>
        <c:set var="custName" value="${cust.fullName}"></c:set>
        <c:if test="${not empty custName}">
            <c:set var="custName" value="${cust.custID}"></c:set>
        </c:if>
        <c:if test="${not empty cart}">
            <h2>${custName}'s Cart</h2>
            <c:set var="cartItems" value="${cart.detailList}"></c:set>
            <c:if test="${not empty cartItems}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Product ID</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cartItems}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${item.productID}</td>
                                <td>${item.quantity}</td>
                                <fmt:formatNumber var="unitPrice" value="${item.unitPrice}" type="number"></fmt:formatNumber>
                                <td>${unitPrice}</td>
                                <fmt:formatNumber var="total" value="${item.total}" type="number"></fmt:formatNumber>
                                <td>${total}</td>
                            </tr>
                        </c:forEach>               
                    </tbody>
                </table>
                <a href="SubmitCart.do">Order Now!</a>
            </c:if>
        </c:if>
    </body>
</html>
