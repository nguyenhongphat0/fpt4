<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Search</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <span>Welcome, ${sessionScope.login.username}</span>
        <h1>Search page</h1>
        
        Pars: <br>
        ${param.username} <br>
        ${param.password} <br>
        ${param.submit} <br>
        ${param.aparam} <br>
        ${param.anotherparam} <br>
        
        <form action="search.jsp">
            Search value <input type="text" name="searchValue" value="" /><br>
            <input type="submit" value="Search" />
        </form>
        <c:set var="searchValue" value="${param.searchValue}"></c:set>
        <c:if test="${not empty searchValue}">
            <sql:setDataSource var="con" dataSource="Datasource"></sql:setDataSource>
            <c:if test="${not empty con}">
                <sql:query var="res" dataSource="${con}">
                    SELECT username as 'Ten', password as 'Mat khau', fullname as 'Ho va Ten', is_admin as 'Admin' FROM users WHERE fullname LIKE ?
                    <sql:param value="%${searchValue}%"></sql:param>
                </sql:query>
                    <c:if test="${res.rowCount gt 0}">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <c:forEach var="colName" items="${res.columnNames}">
                                        <th>${colName}</th>
                                    </c:forEach>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${res.rowsByIndex}" varStatus="counter">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <c:forEach var="col" items="${row}">
                                            <td>${col}</td>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </c:if>
                    <c:if test="${res.rowCount eq 0}">
                        <h2>No record is matched!!!!</h2>
                    </c:if>
            </c:if>
        </c:if>
    </body>
</html>
