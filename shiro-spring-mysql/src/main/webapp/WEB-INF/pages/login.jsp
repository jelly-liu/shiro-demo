<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/pages/include/topInc.jsp" %>
<html>
<head>
    <title>Shiro MySQL Demo</title>
    <%@ include file="/WEB-INF/pages/include/topHead.jsp" %>
</head>
<body>
<form action="${contextPath}/login" method="post" class="eossForm">
    <table class="eossFromTable" style="width: 300px; height: 100px;">
        <tr>
            <td align="right">username:</td>
            <td><input name="name" type="text" value="admin"/></td>
        </tr>
        <tr>
            <td align="right">password:</td>
            <td><input name="password" type="text" value="123"/></td>
        </tr>
        <tr>
            <td align="right">rememberMe:</td>
            <td><input name="rememberMe" type="checkbox" /></td>
        </tr>
        <tr>
            <td colspan="99" align="center">
                <input type="submit" value="submit"/>${msg}
            </td>
        </tr>
    </table>
</form>
</body>
</html>
