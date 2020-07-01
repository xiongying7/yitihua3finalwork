<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%--    引入bootstrap&css&js--%>
    <%--    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>--%>
    <%--    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>--%>
    <link href="${ctx}/static/css/index.css" rel="stylesheet" type="text/css" />

    <title>欢迎页</title>
</head>

<body>

<div class="overlay"></div>
<button id="btn" onclick="window.location.href = '${ctx}/login'">点击进入</button>
<p>Welcome To The</p>
<p>Content Management System</p>

</body>

<script type="text/javascript" language="javascript" src="${ctx}/static/js/index.js"></script>--%>
</html>
