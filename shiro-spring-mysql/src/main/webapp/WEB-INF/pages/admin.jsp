<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/pages/include/topInc.jsp" %>
<html>
<head>
    <title>Shiro MySQL Demo</title>
    <%@ include file="/WEB-INF/pages/include/topHead.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/pages/include/topLoginOut.jsp" %>

----------------------------------- all resources -----------------------------------<br/>
<a href="${contextPath}/" >index</a><br/>
<a href="${contextPath}/admin" >admin</a><br/>
<a href="${contextPath}/adminSuper" >adminSuper</a><br/>
<a href="${contextPath}/adminList" >adminList</a><br/>
<a href="${contextPath}/adminAdd" >adminAdd</a><br/>
<a href="${contextPath}/adminDelete" >adminDelete</a><br/>
----------------------------------- my resources -----------------------------------<br/>
<c:forEach var="resource" items="${resourceList}">
    <a href="${contextPath}${resource.rePath}" >${resource.reName}</a><br/>
</c:forEach>
----------------------------------- has role -----------------------------------<br/>
<table class="eossFromTable" style="width: 500px; height: 100px;">
    <tr>
        <td >id:</td>
        <td>name</td>
        <td>roleList</td>
        <td>roleAdd</td>
        <td>roleDelete</td>
        <td>roleSuper</td>
    </tr>
    <tr>
        <td>101</td>
        <td><shiro:principal/></td>
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
        <td>
            <shiro:hasRole name="roleSuper">
                <a href="${contextPath}/adminSuper" >adminDelete</a>
            </shiro:hasRole>
            <shiro:lacksRole name="roleSuper">
                <a href="##" >Sorry</a>
            </shiro:lacksRole>
        </td>
    </tr>
</table>
<hr/>
----------------------------------- has hasPermission -----------------------------------<br/>
<table class="eossFromTable" style="width: 500px; height: 100px;">
    <tr>
        <td>id:</td>
        <td>name</td>
        <td>admin:list</td>
        <td>admin:add</td>
        <td>admin:delete</td>
        <td>admin:*</td>
        <td>*</td>
    </tr>
    <tr>
        <td>101</td>
        <td><shiro:principal/></td>
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
        <td>
            <shiro:hasPermission name="admin:*">
                <a href="${contextPath}/adminDelete" >adminDelete</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="admin:*">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
        <td>
            <shiro:hasPermission name="*">
                <a href="${contextPath}/adminDelete" >adminDelete</a>
            </shiro:hasPermission>
            <shiro:lacksPermission name="*">
                <a href="##" >Sorry</a>
            </shiro:lacksPermission>
        </td>
    </tr>
</table>
</body>
</html>
