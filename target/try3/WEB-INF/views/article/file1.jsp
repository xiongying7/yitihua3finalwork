<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>文章管理</title>
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
                <a class="navbar-brand" href="#">文章管理</a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx}/homepage">回到首页</a></li>
            </ul>
        </div><!-- /.container-fluid -->
    </nav>

<h2>文章管理</h2>
<form action="${ctx}/file1/upload" method="post" enctype="multipart/form-data">
    <table class="table">
        <tr>
            <td>上传文章</td>
        </tr>
        <tr>
            <td><input type="file" name="file1" value="点击选择图片/上传资源"> </td>
        </tr>
        <tr>
            <td><input type="submit" value="上传文章"></td>
        </tr>
    </table>
</form>
    <div>
        <textarea cols="177" rows="20"></textarea>
    </div>

</div>
</body>
</html>
