<%-- 
    Document   : staffsearch
    Created on : Mar 17, 2018, 4:37:53 PM
    Author     : nguyenhongphat0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Search Page</title>
        <s:head></s:head>
    </head>
    <body>
        Welcome <s:property value="#session.userId"></s:property><br>
        <s:a action="logout">Logout</s:a>
            <h1>Search</h1>
        <s:form action="searchId" method="get">
            <s:textfield name="mobileId" label="Search by ID"></s:textfield>
            <s:submit value="Search"></s:submit>
        </s:form>
        <s:form action="searchName" method="get">
            <s:textfield name="mobileName" label="Search by name"></s:textfield>
            <s:submit value="Search"></s:submit>
        </s:form>
        <s:if test="mobileId != null">
            <s:set var="lst" value="'Id'"></s:set>
            <s:set var="lsv" value="mobileId"></s:set>
        </s:if>
        <s:if test="mobileName != null">
            <s:set var="lst" value="'Name'"></s:set>
            <s:set var="lsv" value="mobileName"></s:set>
        </s:if>
        <s:if test="#lsv != null">
            <s:if test="%{list != null}">
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
                            <th></th>
                            <th></th>
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
                                    <s:url var="deleteLink" action="delete">
                                        <s:param name="pk" value="mobileId"></s:param>
                                        <s:param name="lst" value="#lst"></s:param>
                                        <%--lst = last search type--%>
                                        <s:param name="lsv" value="#lsv"></s:param>
                                        <%--lsv = last search value--%>
                                    </s:url>
                                    <td><s:a href="%{deleteLink}">Delete</s:a></td>
                                    <td>
                                        <s:hidden name="lst" value="%{#lst}"></s:hidden>
                                        <s:hidden name="lsv" value="%{#lsv}"></s:hidden>
                                        <s:submit value="Update"></s:submit>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <h1>No mobile founds</h1>
            </s:else>
            <s:property value="#parameters.msg"></s:property>
        </s:if>
        <h1>New mobile</h1>
        <s:form action="insert" method="post">
            <s:textfield label="ID" name="mobileId"></s:textfield>
            <s:textfield label="Description" name="description"></s:textfield>
            <s:textfield label="Price" name="price" type="number"></s:textfield>
            <s:textfield label="Name" name="mobileName"></s:textfield>
            <s:textfield label="Production year" name="yearOfProduction" type="number"></s:textfield>
            <s:textfield label="Quantity" name="quantity" type="number"></s:textfield>
            <s:checkbox label="NotSale" name="notSale"></s:checkbox>
            <s:submit value="Add phone"></s:submit>
        </s:form>
        <s:if test="#exception.message.contains('duplicate')">
            <b style="color: red">ID existed, try another</b>
        </s:if>
    </body>
</html>
