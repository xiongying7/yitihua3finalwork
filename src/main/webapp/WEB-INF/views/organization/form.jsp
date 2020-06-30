<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>增加页面</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
</head>
<body style="background-color: #393449;">
<div class="container" style="background-color: #e8e8e8; height: 100%;">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">组织机构管理</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx}/homepage">回到首页</a></li>
            </ul>
        </div><!-- /.container-fluid -->
    </nav>
    <div class="page-header">
        <h3>新建机构</h3>
    </div>

    <form id="createFrm" action="${ctx}/organization/create" method="post">
        <p>上级机构为：${porgan.name} <input type="text" name="pId" value="${porgan.id}"> </p>
        <p>机构名称：<input type="text" class="inpu-medium" name="name" value="${porgan.name}"></p>
        <p><button type="submit" class="btn btn-primary">保存</button></p>
    </form>
</div>

<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
