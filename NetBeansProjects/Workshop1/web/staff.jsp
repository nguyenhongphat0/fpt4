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
        <title>Staff Page</title>
    </head>
    <body>
        Welcome ${sessionScope.USER.fullName} (Staff)
        <h2>Search</h2>
        <form action="Search.do">
            Search device with ID: 
            <input type="text" name="mobileId" value="${param.mobileId}" />
            <input type="submit" value="Search"/>
        </form>
        <form action="Search.do">
            Search device with Name:
            <input type="text" name="mobileName" value="${param.mobileName}" />
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
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="mobile" items="${requestScope.RES}" varStatus="counter">
                        <c:url var="deleteLink" value="Delete.do">
                            <c:param name="mobileId" value="${mobile.mobileId}"></c:param>
                            <c:param name="lastSearchId" value="${param.mobileId}"></c:param>
                            <c:param name="lastSearchName" value="${param.mobileName}"></c:param>
                        </c:url>
                    <form action="Update.do" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${mobile.mobileId}</td>
                            <td><input type="text" name="description" value="${mobile.description}" /></td>
                            <td><input type="text" name="price" value="${mobile.price}" /></td>
                            <td>${mobile.mobileName}</td>
                            <td>${mobile.yearOfProduction}</td>
                            <td><input type="text" name="quantity" value="${mobile.quantity}" /></td>
                            <td>
                                <input type="checkbox" name="notSale" value="ON" <c:if test="${not mobile.notSale}">checked="checked"</c:if> />
                            </td>
                            <td>
                                <input type="hidden" name="mobileId" value="${mobile.mobileId}" />
                                <input type="hidden" name="lastSearchId" value="${param.mobileId}" />
                                <input type="hidden" name="lastSearchName" value="${param.mobileName}" />
                                <input type="submit" value="Update" />
                            </td>
                            <td><a href="${deleteLink}">Delete</a></td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <h2>Add</h2>
    <form action="AddMobile.do" method="POST">
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Name</th>
                    <th>Production Year</th>
                    <th>Quantity</th>
                    <th>Saled</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <input type="text" name="newMobileId" value="${param.newMobileId}" />
                    </td>
                    <td>
                        <input type="text" name="description" value="${param.description}" />
                    </td>
                    <td>
                        <input type="text" name="price" value="${param.price}" />
                    </td>
                    <td>
                        <input type="text" name="newMobileName" value="${param.newMobileName}" />
                    </td>
                    <td>
                        <input type="text" name="yearOfProduction" value="${param.yearOfProduction}" />
                    </td>
                    <td>
                        <input type="text" name="quantity" value="${param.quantity}" />
                    </td>
                    <td>
                        <input type="checkbox" name="notSale" value="ON" <c:if test="${not empty param.notSale}">checked="checked"</c:if> />
                    </td>
                </tr>
                <c:if test="${not empty errors}">
                    <tr style="color: red">
                    <td>${errors.idLength}${errors.pk}</td>
                    <td>${errors.descriptionLength}</td>
                    <td>${errors.priceFormat}</td>
                    <td>${errors.nameLength}</td>
                    <td>${errors.yearFormat}</td>
                    <td>${errors.quantityFormat}</td>
                    <td></td>
                </tr>
                </c:if>
            </tbody>
        </table>
        <input type="submit" value="Add this mobile" />
    </form>

</body>
</html>
