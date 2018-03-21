<%-- 
    Document   : search
    Created on : Mar 20, 2018, 2:30:08 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Search</h1>
        <a href="login.jsp">Logout</a>
        <s:form action="search" method="get" theme="simple">
            Book title: <s:textfield name="bookTitle"></s:textfield>
            <s:submit value="Search"></s:submit>
        </s:form>
            <s:if test="bookTitle != empty">
        <s:if test="list != null">
            <h1>Result</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="list" var="book" status="counter">
                        <tr>
                            <td>
                                <s:property value="#counter.count"></s:property>
                            </td>
                            <td>
                                <s:property value="bookTitle"></s:property>
                            </td>
                            <td>
                                <s:property value="description"></s:property>
                            </td>
                            <td>
                                <s:number name="price"></s:number>
                            </td>
                            <td>
                                <s:url var="atcLink" action="addToCart">
                                    <s:param name="bookId" value="%{bookId}"></s:param>
                                    <s:param name="price" value="%{price}"></s:param>
                                    <s:param name="lastSearchValue" value="%{#parameters.bookTitle}"></s:param>
                                </s:url>
                                <s:a href="%{#atcLink}">Add to cart</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <h1>
                No book founds!
            </h1>
        </s:else>                
            </s:if>
        <s:if test="#session.cart != null">
            <s:url var="checkoutLink" action="checkout">
                <s:param name="lastSearchValue" value="%{#parameters.bookTitle}"></s:param>
            </s:url>
            <s:a href="%{#checkoutLink}">Checkout</s:a>
        </s:if>
    </body>
</html>
