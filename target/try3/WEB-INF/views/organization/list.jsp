<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>机构信息管理</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/static/commons.js"></script>
    <script>
        $(document).ready(function(){
            $("#btn_Create").bind("click",function () {
                let pId =$("#pId").val();
                window.location.href="${ctx}/organization/create?pId="+pId;
            })
        });
    </script>
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
        <h3>组织机构管理</h3>
    </div>
    <div class="row">
        <div class="col-md-12">
            <button type="button" class="btn btn-default" id="btn_Create">创建</button>
            <button type="button" class="btn btn-danger" id="btn_Delete">批量删除</button>
        </div>
    </div>
    <input type="hidden" id="pId" name="pId" value="${pId}">
    <table  id="contentTable" class="table table-striped table-hover">
        <thead><tr>
            <th><input type="checkbox" id="chkAll"></th>
            <th>序号</th>
            <th>机构名称</th>
            <th>四位一体编码</th>
            <th>排序</th>
            <th>操作</th>
        </tr></thead>
        <tbody>
        <c:forEach items="${list}" var="organization" varStatus="idxStatus">
            <tr>
                <td><input type="checkbox" name="chkIds" value="${organization.id}"></td>
                <td>${idxStatus.index+1}</td>
                <td><a href="${ctx}/organization?pId=${organization.id}">${organization.name}</a></td>
                <td>${organization.autoCode}</td>
                <td>${organization.sort}</td>
                <td>
                    <input type="button" name="edit" value="编辑">
                    <input type="button" name="delete" value="删除">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<%--    <tags:pagination page="${organizations}" paginationSize="${PAGE_SIZE}"/>--%>
</div>

<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
