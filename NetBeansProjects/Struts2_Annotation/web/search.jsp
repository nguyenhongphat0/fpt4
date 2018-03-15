<%-- 
    Document   : search
    Created on : Mar 13, 2018, 3:03:44 PM
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
        <span style="color: red">
            Welcome, <s:property value="username"></s:property>
            EL Welcome, ${sessionScope.USERNAME}
            Struts Welcome, <s:property value="%{#session.USERNAME}"></s:property>
        </span>
        <h1>Search Page</h1>
        <s:form action="searchLastName">
            <s:textfield name="searchValue" label="Search Value"></s:textfield>
            <s:submit value="Search"></s:submit>
        </s:form>
        
        <s:if test="%{!searchValue.isEmpty()}">
            <s:if test="%{usersList != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="user" value="usersList" status="counter">
                            <s:form action="update" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"></s:property>
                                    </td>
                                    <td>
                                        <s:property value="%{#user.username}"></s:property>
                                        <s:hidden name="username" value="%{username}"></s:hidden>
                                    </td>
                                    <td>
                                        <s:textfield name="password" value="%{password}"></s:textfield>
                                    </td>
                                    <td>
                                        <s:property value="lastname"></s:property>
                                    </td>
                                    <td>
                                        <s:checkbox name="role" value="%{role}"></s:checkbox>
                                    </td>
                                    <td>
                                        <s:url id="deleteLink" action="delete">
                                            <s:param name="pk" value="username"></s:param>
                                            <s:param name="lastSearchValue" value="%{searchValue}"></s:param>
                                        </s:url>
                                        <s:a href="%{deleteLink}">Delete</s:a>
                                    </td>
                                    <td>
                                        <s:submit value="Update"></s:submit>
                                        <s:hidden name="lastSearchValue" value="%{searchValue}"></s:hidden>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                <h2>No record is matched!!!</h2>
            </s:else>
        </s:if>
    </body>
</html>
