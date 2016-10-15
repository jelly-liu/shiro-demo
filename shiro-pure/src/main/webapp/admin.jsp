<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/topInc.jsp" %>
<html>
<head>
    <title>Shiro MySQL Demo</title>
    <%@ include file="/include/topHead.jsp" %>
</head>
<body>
<%@ include file="/include/topLoginOut.jsp" %>
<hr/>
<h2> shiro tag demo, try to access url </h2>
<a href="/" >index</a><br/>
<a href="/admin" >admin</a><br/>
<a href="/adminSuper" >adminSuper</a><br/>
<a href="/adminList" >adminList</a><br/>
<a href="/adminAdd" >adminAdd</a><br/>
<a href="/adminDelete" >adminDelete</a><br/>
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
                <a href="/adminList" >adminList</a>
            </shiro:hasRole>
            <shiro:lacksRole name="roleList">
                <a href="##" >Sorry</a>
            </shiro:lacksRole>
        </td>
        <td>
            <shiro:hasRole name="roleAdd">
                <a href="/adminAdd" >adminAdd</a>
            </shiro:hasRole>
            <shiro:lacksRole name="roleAdd">
                <a href="##" >Sorry</a>
            </shiro:lacksRole>
        </td>
        <td>
            <shiro:hasRole name="roleDelete">
                <a href="/adminDelete" >adminDelete</a>
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
                <a href="/adminList" >adminList</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:list">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
        <td>
            <shiro:hasPermission name="admin:add">
                <a href="/adminAdd" >adminAdd</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:add">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
        <td>
            <shiro:hasPermission name="admin:delete">
                <a href="/adminDelete" >adminDelete</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:delete">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
    </tr>
</table>
</body>
</html>
