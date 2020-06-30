<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/6/27
  Time: 11:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>

    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
    <link href="${ctx}/static/css/homepage.css" rel="stylesheet" type="text/css" />
    <title>首页</title>
</head>
<body>

<!--<%--大背景框--%>-->
<div class="login">
    <div class="all">
        <div class='container'>
            <div id='cube'>
                <div class='front'>
<%--                    数据字典管理--%>
                    <div class="word">
                        <a href="${ctx}/dict/">Data dictionary management</a>
                    </div>
                </div>
                <div class='back'>
<%--                    资源存储路径管理--%>
                    <div class="word">
                        <a href="${ctx}/file/index">Resource storage path management</a>
                    </div>
                </div>
                <div class='left'>
<%--                    组织机构管理--%>
                    <div class="word">
                        <a href="${ctx}/organization/">Organization management</a></div>
                </div>
                <div class='right'>
<%--                    授权管理--%>
                    <div class="word"><a href="${ctx}/user/update/1">Authorization management</a></div>
                </div>
                <div class='top'>
<%--                    栏目分类管理--%>
                    <div class="word"><a href="${ctx}/part/">Column classification management</a></div>
                </div>
                <div class='bottom'>
<%--                    文章管理--%>
                    <div class="word"><a href="${ctx}/file1/index">Article management</a></div>
                </div>
            </div>
        </div>
        <div id='pick_a_color'>
            <div class='blue'></div>
            <div class='teal'></div>
            <div class='green'></div>
            <div class='yellow'></div>
            <div class='orange'></div>
            <div class='pink'></div>
        </div>
    </div>

</div>


<%--总体背景--%>
<canvas id="" width="100%" height="100%"></canvas>
</body>

<script type="text/javascript" language="javascript" src="${ctx}/static/js/login.js"></script>--%>
<script type="text/javascript" language="javascript" src="${ctx}/static/js/homepage.js"></script>--%>

</html>
