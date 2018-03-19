<%-- 
    Document   : search
    Created on : Mar 19, 2018, 8:30:58 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        Welcome, <s:property value="#session.custID"></s:property><br>
        <a href="logout.action">Logout</a>
        <h1>Search Order</h1>
        <s:form action="search" method="get">
            <s:textfield label="From date" name="fromdate"></s:textfield>
            <s:textfield label="To date" name="todate"></s:textfield>
            <s:checkbox label="Delivered" name="isDeliver"></s:checkbox>
            <s:submit value="Search"></s:submit>
            <s:reset value="Reset"></s:reset>
        </s:form>
        <s:if test="list != null">
            <h1>Result</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>OrderDate</th>
                        <th>CustomerID</th>
                        <th>Total</th>
                        <th>Delivered</th>
                        <th>Reason</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator var="order" value="list" status="counter">
                        <s:form action="update" theme="simple">
                            <tr>
                                <td>
                                    <s:property value="#counter.count"></s:property>
                                </td>
                                <td>
                                    <s:property value="orderID"></s:property>                                    <s:hidden ></s:hidden>
                                    <s:hidden name="orderID" value="%{orderID}"></s:hidden>
                                    <s:hidden name="fromdate" value="%{fromdate}"></s:hidden>
                                    <s:hidden name="todate" value="%{todate}"></s:hidden>
                                </td>
                                <td>
                                    <s:textfield name="orderDate" value="%{orderDate}"></s:textfield>
                                </td>
                                <td>
                                    <s:textfield name="custID" value="%{custID}"></s:textfield>
                                </td>
                                <td>
                                    <s:textfield name="total" value="%{total}" type="number"></s:textfield>
                                </td>
                                <td>
                                    <s:checkbox name="isDeliver" value="isDeliver"></s:checkbox>
                                </td>
                                <td>
                                    <s:textfield name="reason" value="%{reason}"></s:textfield>
                                </td>
                                <td>
                                    <s:submit value="Update"></s:submit>
                                </td>
                            </tr>
                        </s:form>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:else>
            <h1>No order founds!</h1>
        </s:else>
    </body>
</html>
