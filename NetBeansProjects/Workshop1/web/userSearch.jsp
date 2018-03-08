<%-- 
    Document   : staff.jsp
    Created on : Mar 6, 2018, 10:39:55 PM
    Author     : nguyenhongphat0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        Welcome ${sessionScope.USER.fullName} (User)<br>
        <a href="Logout.do">Logout</a>
        <h2>Search</h2>
        <form action="UserSearch.do">
            Search device with price from 
            <input type="text" name="minPrice" value="${param.minPrice}" />
            to
            <input type="text" name="maxPrice" value="${param.maxPrice}" />
            <input type="submit" value="Search"/>
        </form>
        <font color="red">${requestScope.message}</font>
        <c:if test="${not empty requestScope.RES}">
            <h2>Result</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Name</th>
                        <th>Production Year</th>
                        <th>Quantity</th>
                        <th>Saled</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="mobile" items="${requestScope.RES}" varStatus="counter">
                        <c:url var="addToCart" value="UserAddToCart.do">
                            <c:param name="mobileId" value="${mobile.mobileId}"></c:param>
                            <c:param name="minPrice" value="${param.minPrice}"></c:param>
                            <c:param name="maxPrice" value="${param.maxPrice}"></c:param>
                        </c:url>
                        <tr>
                            <td>${counter.count}</td>
                            <td>${mobile.mobileId}</td>
                            <td>${mobile.description}</td>
                            <td>${mobile.price}</td>
                            <td>${mobile.mobileName}</td>
                            <td>${mobile.yearOfProduction}</td>
                            <td>${mobile.quantity}</td>
                            <td>
                                <input type="checkbox" name="notSale" value="ON" <c:if test="${not mobile.notSale}">checked="checked"</c:if> disabled="true" />
                                </td>
                                <td><a href="${addToCart}">Add to cart</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <font color="green">${checkoutinfo}</font>
        <c:set var="cart" value="${sessionScope.CART}"></c:set>
        <c:if test="${not empty cart.items}">
            <h2>Cart</h2>
            <c:url var="checkout" value="UserCheckOutCart.do">
                <c:param name="minPrice" value="${param.minPrice}"></c:param>
                <c:param name="maxPrice" value="${param.maxPrice}"></c:param>
            </c:url>
            <a href="${checkout}">Checkout</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Mobile ID</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart.items}" varStatus="counter">
                        <c:url var="removeItem" value="UserRemoveCartItem.do">
                            <c:param name="mobileId" value="${item.key}"></c:param>
                            <c:param name="minPrice" value="${param.minPrice}"></c:param>
                            <c:param name="maxPrice" value="${param.maxPrice}"></c:param>
                        </c:url>
                        <tr>
                            <td>${counter.count}</td>
                            <td>${item.key}</td>
                            <td>${item.value}</td>
                            <td><a href="${removeItem}">Remove</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
