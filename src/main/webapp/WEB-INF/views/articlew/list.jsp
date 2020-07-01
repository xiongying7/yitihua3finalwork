<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文章维护页面</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"/>
    <script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
<%--    <script src="${ctx}/static/commons.js"></script>--%>
    <script>

        function fillcity() {
            var province = document.getElementById("province").value;
            switch (province) {
                case "美食":
                    var cities = ["小吃", "特色", "地方", "海外"];
                    break;
                case "宠物":
                    var cities = ["猫", "狗", "鱼", "爬宠"];
                    break;
                case "情感":
                    var cities = ["爱情", "友情", "亲情", "陪伴"];
                    break;
                case "生活":
                    var cities = ["娱乐", "感悟", "感情", "心情"];
                    break;
            }

            for (var i=0; i<cities.length; i++) {
                var city = document.getElementById("city");
                city.options[i] = new Option(cities[i], cities[i]);
            };
        }
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
                <a class="navbar-brand" href="#">文章维护页</a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx}/homepage">回到首页</a></li>
            </ul>
        </div><!-- /.container-fluid -->
    </nav>

    <%--    <tags:nav/>--%>
    <div class="page-header">
        <h3>文章维护</h3>
    </div>

<div>
        <table class="table">
            <tr>
                <td>文章类型1</td>
            <td>
            <select id="province" onchange="fillcity()" style="width: 200px; height: 30px;" >
                <option value="空值" selected="selected">请选择</option>
                <option value="美食">美食</option>
                <option value="宠物">宠物</option>
                <option value="情感">情感</option>
                <option value="生活">生活</option>
            </select>
            </td>
            </tr>
            <tr>
            <td>文章类型2</td>
            <td><select id="city" style="width: 200px; height: 30px;"></select> </td>
            </tr>
            <tr>
                <td>文章名称</td>
                <td><input type="text" > </td>
            </tr>
            <tr>
                <td>
                    <a href="${ctx}/articlew/form" style="outline: none;border: 1px #26bbdb solid;">保存</a>
                </td>
            </tr>

        </table>
<%--    <a href="${ctx}/articlew/form"></a>--%>
<%--    <button href="">点击保存</button>--%>
</div>

</div>


<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>文章类型1</td>--%>
<%--                <td><select id="province" οnchange="changeProvince()"></select></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>文章类型1</td>--%>
<%--                <td><select id="city" οnchange="changeCity()">--%>
<%--                    <option value="-1">--请选择城市--</option>--%>
<%--                </select></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>文章类型1</td>--%>
<%--                <td><select id="countrySide">--%>
<%--                    <option value="-1">--请选择乡镇--</option>--%>
<%--                </select></td>--%>
<%--            </tr>--%>

<%--        </table>--%>



<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>文章类型1</td>--%>
<%--                <td>--%>
<%--                <div class="col-lg-6">--%>
<%--                    <div class="input-group">--%>
<%--                        <div class="input-group-btn">--%>
<%--                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">--%>
<%--                                <span class="caret"></span>--%>
<%--                            </button>--%>
<%--                            <ul class="dropdown-menu">--%>
<%--                                <li><a href="#">生活</a></li>--%>
<%--                                <li><a href="#">情感</a></li>--%>
<%--                                <li><a href="#">宠物</a></li>--%>
<%--                                <li><a href="#">美妆</a></li>--%>
<%--                                <li><a href="#">美食</a></li>--%>
<%--                            </ul>--%>
<%--                        </div><!-- /btn-group -->--%>
<%--                        <input type="text" class="form-control">--%>
<%--                    </div><!-- /input-group -->--%>
<%--                </div><!-- /.col-lg-6 -->--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>文章类型1</td>--%>
<%--                <td>--%>
<%--                    <div class="col-lg-6">--%>
<%--                        <div class="input-group">--%>
<%--                            <div class="input-group-btn">--%>
<%--                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">--%>
<%--                                    <span class="caret"></span>--%>
<%--                                </button>--%>
<%--                                <ul class="dropdown-menu">--%>
<%--                                    <li><a href="#">生活</a></li>--%>
<%--                                    <li><a href="#">情感</a></li>--%>
<%--                                    <li><a href="#">宠物</a></li>--%>
<%--                                    <li><a href="#">美妆</a></li>--%>
<%--                                    <li><a href="#">美食</a></li>--%>
<%--                                </ul>--%>
<%--                            </div><!-- /btn-group -->--%>
<%--                            <input type="text" class="form-control">--%>
<%--                        </div><!-- /input-group -->--%>
<%--                    </div><!-- /.col-lg-6 -->--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>文章类型1</td>--%>
<%--                <td>--%>
<%--                    <div class="col-lg-6">--%>
<%--                        <div class="input-group">--%>
<%--                            <div class="input-group-btn">--%>
<%--                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">--%>
<%--                                    <span class="caret"></span>--%>
<%--                                </button>--%>
<%--                                <ul class="dropdown-menu">--%>
<%--                                    <li><a href="#">生活</a></li>--%>
<%--                                    <li><a href="#">情感</a></li>--%>
<%--                                    <li><a href="#">宠物</a></li>--%>
<%--                                    <li><a href="#">美妆</a></li>--%>
<%--                                    <li><a href="#">美食</a></li>--%>
<%--                                </ul>--%>
<%--                            </div><!-- /btn-group -->--%>
<%--                            <input type="text" class="form-control">--%>
<%--                        </div><!-- /input-group -->--%>
<%--                    </div><!-- /.col-lg-6 -->--%>
<%--                </td>--%>

<%--            </tr>--%>
<%--        </table>--%>

    </div>
</div>

<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>

</body>
</html>
