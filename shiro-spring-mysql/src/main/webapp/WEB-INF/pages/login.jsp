<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/pages/include/topInc.jsp" %>
<html>
<head>
    <title>Shiro MySQL Demo</title>
    <%@ include file="/WEB-INF/pages/include/topHead.jsp" %>
</head>
<body>
<div class="container">
    <form action="${contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">username</label>
            <input id="username" name="username" value="adminSuper" class="form-control" placeholder="enter username">
        </div>
        <div class="form-group">
            <label for="password">password</label>
            <input id="password" name="password" type="password" value="111111" class="form-control" placeholder="enter password">
        </div>
        <div class="form-group form-check">
            <input id="rememberMe" name="rememberMe" type="checkbox" class="form-check-input">
            <label class="form-check-label" for="rememberMe">rememberMe</label>
        </div>
        <button id="submitBtn" type="submit" class="btn btn-primary">Sign In</button>
    </form>
</div>
</body>
</html>
