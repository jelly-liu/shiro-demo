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
<a href="${contextPath}/" >index</a>&nbsp;&nbsp;
<a href="${contextPath}/admin" >admin</a>&nbsp;&nbsp;
<a href="${contextPath}/adminSuper" >adminSuper</a>&nbsp;&nbsp;
<a href="${contextPath}/adminList" >adminList</a>&nbsp;&nbsp;
<a href="${contextPath}/adminAdd" >adminAdd</a>&nbsp;&nbsp;
<a href="${contextPath}/adminDelete" >adminDelete</a>&nbsp;&nbsp;
<a href="${contextPath}/tomList" >tomList</a>&nbsp;&nbsp;
<a href="${contextPath}/tomAdd" >tomAdd</a>&nbsp;&nbsp;
<a href="${contextPath}/tomDelete" >tomDelete</a>&nbsp;&nbsp;
<a href="${contextPath}/tomUpdate" >tomUpdate</a>&nbsp;&nbsp;
<br>----------------------------------- my resources -----------------------------------<br/>
<c:forEach var="resource" items="${subject_resources}">
    <a href="${contextPath}${resource.rePath}" >${resource.reName}</a>&nbsp;&nbsp;
</c:forEach>
<br>----------------------------------- my roles -----------------------------------<br/>
<c:forEach var="role" items="${subject_roles}">
    ${role.roName}&nbsp;&nbsp;
</c:forEach>
<br>----------------------------------- my perms -----------------------------------<br/>
<c:forEach var="perm" items="${subject_perms}">
    ${perm.peName}&nbsp;&nbsp;
</c:forEach>
<br>----------------------------------- has role -----------------------------------<br/>
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
        <td>${subject_user.id}</td>
        <td>${subject_user.username}</td>
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
<br>----------------------------------- has hasPer -----------------------------------<br/>
<table class="eossDataTable" style="width: 500px; height: 100px;">
    <tr class="datagrid-header">
        <td>id:</td>
        <td>name</td>
        <td>admin:list</td>
        <td>admin:add</td>
        <td>admin:delete</td>
        <td>admin:*</td>
        <td>*</td>
    </tr>
    <tr>
        <td>${subject_user.id}</td>
        <td>${subject_user.username}</td>
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
