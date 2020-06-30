<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户管理新增</title>
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
                <a class="navbar-brand" href="#">用户管理</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx}/homepage">回到首页</a></li>
            </ul>
        </div><!-- /.container-fluid -->
    </nav>

    <div class="page-header">
        <h3>用户管理</h3>
    </div>
    <form method="post" action="${ctx}/user/">

        <input type="hidden" name="id" value="${user.id}">
        <p>用户名：<input type="text" class="inpu-medium" name="username" value="${user.username}"></p>
        <p>密码：<input type="text" class="input-medium" name="password" value="${user.password}"></p>
        <p>电话：<input type="text" class="input-medium" name="phone" value="${user.phone}"></p>
        <p>邮箱：<input type="text" class="input-medium" name="email" value="${user.email}"></p>
        <p>创建时间：<input type="text" class="input-medium" name="creatTime" value="${user.createTime}"></p>
        <p>状态：<input type="text" class="input-medium" name="status" value="${user.status}"></p>

        <p><button type="submit" class="btn btn-primary">保存</button></p>
    </form>
</div>

<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
