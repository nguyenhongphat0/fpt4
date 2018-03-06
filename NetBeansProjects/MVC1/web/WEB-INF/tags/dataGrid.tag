<%-- 
    Document   : dataGrid
    Created on : Mar 1, 2018, 3:15:04 PM
    Author     : nguyenhongphat0
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag dynamic-attributes="da"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="dataSource" required="true"%>
<%@attribute name="sql" required="true" %>
<%@attribute name="params" %>
<%-- any content can be specified here e.g.: --%>
<sql:setDataSource var="con" dataSource="${dataSource}"></sql:setDataSource>
<c:if test="${not empty con}">
    <sql:query var="res" dataSource="${con}">
        ${sql}
        <c:forTokens var="p" delims="|" items="${params}">
            <sql:param value="${p}"></sql:param>
        </c:forTokens>
    </sql:query>
    <c:if test="${res.rowCount gt 0}">
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <c:forEach var="col" items="${res.columnNames}">
                        <th>${col}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${res.rowsByIndex}" varStatus="d">
                    <tr>
                        <td>${d.count}</td>
                        <c:forEach var="cell" items="${row}">
                            <td>${cell}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${res.rowCount eq 0}">
        <font color="red">
            <h2>No record found!!!</h2>
        </font>
    </c:if>
</c:if>