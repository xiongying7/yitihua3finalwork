<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/6/26
  Time: 11:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <link href="${ctx}/static/css/login.css" rel="stylesheet" type="text/css" />
    <title>登陆页</title>



</head>
<body>

<!--<%-- 大背景框--%>-->
<div class="login">
    <!--导航标签-->
    <div class="nav">
        <h1>Welcome to the Content Management System</h1>
    </div>
    <!--<%--用户名--%>-->
    <div class="user">
        <form action="${ctx}/login" method="post">
            <p id="p1">用户名：
                <input type="text" name="username" placeholder="用户登陆请输入：username ，管理员登陆请输入：admin" id="text">
            </p>
            <p id="p2">密码：
                <input type="password" name="password" placeholder="用户登陆请输入：password，管理员登陆请输入：admin" id="pass">
            </p>
            <p>
                <input type="submit" value="登录" id="btn1" onclick="login()">
                <%--                <button type="submit" id="btn1" >用户登录</button>--%>
                <%--                <button type="submit" id="btn2">管理员登录</button>--%>
                <%--                <input type="button" onclick="login()" id="btn2" value="管理员登陆">--%>
            </p>
        </form>
    </div>
</div>

<%--总体背景--%>
<canvas id="" width="100%" height="100%"></canvas>
</body>

<script type="text/javascript" language="javascript" src="${ctx}/static/js/login.js"></script>--%>

</html>




<%--<%@ page contentType="text/html;charset=UTF-8"%>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<c:set var="ctx" value="${pageContext.request.contextPath}"/>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>登录页面</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>用户登录</h1>--%>
<%--    <form action="${ctx}/login" method="post">--%>
<%--        <p>用户名：<input type="text" name="username"></p>--%>
<%--        <p>密码：<input type="password" name="password"></p>--%>
<%--        <p><button type="submit">登录</button></p>--%>
<%--    </form>--%>
<%--</body>--%>
<%--</html>--%>
