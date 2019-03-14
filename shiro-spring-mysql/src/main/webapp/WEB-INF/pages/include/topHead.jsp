<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/static/bootstrap/css/bootstrap.min.css" />

<script type="text/javascript" src="${contextPath}/static/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${contextPath}/static/popper/popper.min.js"></script>
<script type="text/javascript" src="${contextPath}/static/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
    var contextPath = '${contextPath}';
    var pageSize = 10;
</script>