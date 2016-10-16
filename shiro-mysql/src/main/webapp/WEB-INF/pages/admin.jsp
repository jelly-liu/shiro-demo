<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/pages/include/topInc.jsp" %>
<html>
<head>
    <title>Shiro MySQL Demo</title>
    <%@ include file="/WEB-INF/pages/include/topHead.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/pages/include/topLoginOut.jsp" %>
<hr/>
<h2> shiro tag demo, try to access url </h2>
<a href="${contextPath}/" >index</a><br/>
<a href="${contextPath}/admin" >admin</a><br/>
<a href="${contextPath}/adminSuper" >adminSuper</a><br/>
<a href="${contextPath}/adminList" >adminList</a><br/>
<a href="${contextPath}/adminAdd" >adminAdd</a><br/>
<a href="${contextPath}/adminDelete" >adminDelete</a><br/>
<hr/>
<h2> shiro tag demo, has role </h2>
<table class="eossFromTable" style="width: 500px; height: 100px;">
    <tr>
        <td >id:</td>
        <td>name</td>
        <td>list</td>
        <td>add</td>
        <td>delete</td>
    </tr>
    <tr>
        <td>101</td>
        <td>lion</td>
        <td>
            <shiro:hasRole name="roleList">
                <a href="${contextPath}/adminList" >adminList</a>
            </shiro:hasRole>
            <shiro:lacksRole name="roleList">
                <a href="##" >Sorry</a>
            </shiro:lacksRole>
        </td>
        <td>
            <shiro:hasRole name="roleAdd">
                <a href="${contextPath}/adminAdd" >adminAdd</a>
            </shiro:hasRole>
            <shiro:lacksRole name="roleAdd">
                <a href="##" >Sorry</a>
            </shiro:lacksRole>
        </td>
        <td>
            <shiro:hasRole name="roleDelete">
                <a href="${contextPath}/adminDelete" >adminDelete</a>
            </shiro:hasRole>
            <shiro:lacksRole name="roleDelete">
                <a href="##" >Sorry</a>
            </shiro:lacksRole>
        </td>
    </tr>
</table>
<hr/>
<h2>shiro tag demo, has hasPermission </h2>
<table class="eossFromTable" style="width: 500px; height: 100px;">
    <tr>
        <td>id:</td>
        <td>name</td>
        <td>list</td>
        <td>add</td>
        <td>delete</td>
    </tr>
    <tr>
        <td>101</td>
        <td>lion</td>
        <td>
            <shiro:hasPermission name="admin:list">
                <a href="${contextPath}/adminList" >adminList</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:list">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
        <td>
            <shiro:hasPermission name="admin:add">
                <a href="${contextPath}/adminAdd" >adminAdd</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:add">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
        <td>
            <shiro:hasPermission name="admin:delete">
                <a href="${contextPath}/adminDelete" >adminDelete</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:delete">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
    </tr>
</table>
</body>
</html>
