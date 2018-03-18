<%-- 
    Document   : usersearch
    Created on : Mar 17, 2018, 5:31:30 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Search Page</title>
        <s:head></s:head>
    </head>
    <body>
        <h1>Search Price</h1>
        <s:form action="searchPrice" method="get">
            <s:textfield name="min" label="From" type="number"></s:textfield>
            <s:textfield name="max" label="To" type="number"></s:textfield>
            <s:submit value="Search"></s:submit>
        </s:form>
        <s:if test="min != 0 || max != 0">
            <s:if test="list != null">
                
                <h1>Result</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Mobile ID</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Mobile Name</th>
                            <th>Production Year</th>
                            <th>Quantity</th>
                            <th>Not sale?</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="list" status="counter">
                            <s:form action="update" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="#counter.count"></s:property>
                                    </td>
                                    <td>
                                        <s:property value="mobileId"></s:property>
                                        <s:hidden name="mobileId" value="%{mobileId}"></s:hidden>
                                    </td>
                                    <td>
                                        <s:textfield name="description" value="%{description}"></s:textfield>
                                    </td>
                                    <td>
                                        <s:textfield name="price" value="%{price}" type="number"></s:textfield>
                                    </td>
                                    <td>
                                        <s:property value="mobileName"></s:property>
                                    </td>
                                    <td><s:property value="yearOfProduction"></s:property></td>
                                    <td>
                                        <s:textfield name="quantity" value="%{quantity}" type="input"></s:textfield>
                                    </td>
                                    <td>
                                        <s:checkbox name="notSale" value="%{notSale}"></s:checkbox>
                                    </td>
                                    <td>
                                        <s:url var="atcLink" action="addToCart">
                                            <s:param name="mobileId" value="mobileId"></s:param>
                                            <s:param name="min" value="min"></s:param>
                                            <s:param name="max" value="max"></s:param>
                                        </s:url>
                                        <s:a href="%{atcLink}">Add to cart</s:a>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <h1>No mobiles found!!!</h1>
            </s:else>
        </s:if>
    <s:set var="cart" value="#session.cart"></s:set>
    <s:if test="!#cart.items.isEmpty">
        <h1>Carts</h1>
        <s:url var="checkOutLink" action="checkout">
            <s:param name="min" value="min"></s:param>
            <s:param name="max" value="max"></s:param>
        </s:url>
        <s:a href="%{checkOutLink}">Checkout</s:a>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Mobile ID</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator var="mobile" value="#cart.items" status="counter">
                    <tr>
                        <td><s:property value="#counter.count"></s:property></td>
                        <td><s:property value="key"></s:property></td>
                        <td><s:property value="value"></s:property></td>
                        <s:url var="dfcLink" action="dropFromCart">
                            <s:param name="mobileId" value="key"></s:param>
                            <s:param name="min" value="min"></s:param>
                            <s:param name="max" value="max"></s:param>
                        </s:url>
                        <td><s:a href="%{dfcLink}">Remove</s:a></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </s:if>
    </body>
</html>
