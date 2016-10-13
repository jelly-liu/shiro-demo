<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<title>Shiro MySQL Demo</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/base.css" />

<script type="text/javascript" src="${contextPath}/static/jquery/jquery-1.11.1.min.js"></script>

<script type="text/javascript">
    var contextPath = '${contextPath}';
    var pageSize = 10;
</script>