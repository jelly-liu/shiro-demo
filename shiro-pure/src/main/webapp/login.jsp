<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/topInc.jsp" %>
<html>
<head>
    <title>Shiro MySQL Demo</title>
    <%@ include file="/include/topHead.jsp" %>
</head>
<body>
<form action="/login" method="post" class="eossForm">
    <table class="eossFromTable" style="width: 300px; height: 100px;">
        <tr>
            <td align="right">username:</td>
            <td><input name="username" type="text" value="admin"/></td>
        </tr>
        <tr>
            <td align="right">password:</td>
            <td><input name="password" type="text" value="123"/></td>
        </tr>
        <tr>
            <td align="right">Remember Me?</td>
            <td><input type="checkbox" name="rememberMe" value="true"/></td>
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
