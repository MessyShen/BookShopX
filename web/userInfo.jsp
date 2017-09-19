<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/17
  Time: 下午6:43
  .     .
     ^
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>第三波书店</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/ghpages-materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
    <%--<link href="css/Layout.css" rel="stylesheet" type="text/css" />--%>
    <SCRIPT type=text/javascript src="js/scrolltop.js"></SCRIPT>
    <SCRIPT type=text/javascript src="js/qq.js"></SCRIPT>

</head>
<body>

<header>
    <nav>
        <div class="container">
        <div class="nav-wrapper">
            <div class="col s12">
                <a href="manage.jsp" class="breadcrumb">第三波书店管理系统</a>
                <a href="" class="breadcrumb">用户管理</a>
                <a href="" class="breadcrumb">用户信息管理</a>
            </div>
        </div>
        </div>
    </nav>
    <div class="container"><a href="" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="material-icons">menu</i></a></div>
    <ul id="nav-mobile" class="side-nav fixed" style="transform: translateX(0%);">
        <li class="logo">
            <a id="logo-container" href="index.html" class="brand-logo">
                <object id="front-page-logo" type="image/svg+xml" data="images/third-wave3.svg">你的浏览器不支持SVG</object>
            </a>
        </li>
        <li class="search">
            <div class="search-wrapper card">
                <input id="search"><i class="material-icons">search</i>
                <div class="search-results"></div>
            </div>
        </li>
        <%--<li class="bold "><a href="/about.html" class="waves-effect waves-teal">关于我们</a></li>--%>
        <%--<li class="bold "><a href="/getting-started.html" class="waves-effect waves-teal">开始学习</a></li>--%>
        <li class="no-padding">
            <ul class="collapsible collapsible-accordion">
                <li class="bold active"><a class="collapsible-header  waves-effect waves-teal">用户管理</a>
                    <div class="collapsible-body">
                        <ul>
                            <li class="active"><a href="usersListByPage.action" class="collection-item">用户信息管理</a></li>
                            <li class><a href="userState.jsp" class="collection-item">用户状态管理</a></li>
                        </ul>
                    </div>
                </li>

                <li class="bold"><a class="collapsible-header  waves-effect waves-teal">图书管理</a>
                    <div class="collapsible-body">
                        <ul>
                            <li class><a href="listBookByPage.action" class="collection-item">图书信息管理</a></li>
                            <li class><a href="bookCate.jsp" class="collection-item">图书分类管理</a></li>
                            <li class><a href="addBook.jsp" class="collection-item">添加图书</a></li>
                        </ul>
                    </div>
                </li>

                <li class="bold"><a href="logOut" class="collapsible-header  waves-effect waves-teal">安全退出</a>
                </li>

            </ul>
        </li>
    </ul>
</header>
<main>
<div class="container">
    <table>
        <thead>
        <tr>
            <th data-field="id">id</th>
            <th data-field="name">姓名</th>
            <th>电话</th>
            <th data-field="price">地址</th>
            <th>删除</th>
            <th>详细信息</th>
        </tr>
        </thead>

        <tbody>
        <s:iterator id="uiItem" value="#session.USERS_LIST">
            <tr>
                <td>${uiItem.id}</td>
                <td>${uiItem.name}</td>
                <td>${uiItem.phone}</td>
                <td>${uiItem.address}</td>
                <td><a class="waves-effect waves-light btn" href="#modalX${uiItem.id}">删除</a></td>
                <%--<td><a href="deleteById?users.id=${uiItem.id}" class="waves-effect waves-light btn">删除</a></td>--%>
                <td><a class="waves-effect waves-light btn" href="#modal${uiItem.id}">详细</a></td>
            </tr>

            <div id="modalX${uiItem.id}" class="modal">
                <div class="modal-content">
                    <h4>确定删除？</h4>
                    <p>确定要删除用户 ${uiItem.name} 吗？</p>
                </div>
                <div class="modal-footer">
                    <a href="deleteById?users.id=${uiItem.id}" class="waves-effect waves-light btn">删除</a>
                    <a class=" modal-action modal-close waves-effect waves-green btn-flat">别别别</a>
                </div>
            </div>

            <div id="modal${uiItem.id}" class="modal">
                <div class="modal-content">
                    <h4>${uiItem.name}</h4>
                    <div class="chip">
                        ID:${uiItem.id}
                    </div>
                    <div class="chip">
                        TEL:${uiItem.phone}
                    </div>
                    <div class="chip">
                        Level:${uiItem.userRoleId}
                    </div>
                    <p>地址：${uiItem.address}</p>
                    <p>邮箱：${uiItem.mail}</p>
                </div>
                <div class="modal-footer">
                    <a class=" modal-action modal-close waves-effect waves-green btn-flat">关闭</a>
                </div>
            </div>
        </s:iterator>
        </tbody>
    </table>

</div>
</main>


<ul id="slide-out" class="side-nav">
    <li><div class="userView">
        <div class="background">
            <img src="images/office.jpg">
        </div>
        <a href="#!user"><img class="circle" src="images/messylogo2.png"></a>
        <a href="#!name"><span class="white-text name">${sessionScope.CURRENT_USER.name}</span></a>
        <a href="#!email"><span class="white-text email">${sessionScope.CURRENT_USER.mail}</span></a>
    </div></li>
    <s:if test="(#session.CURRENT_USER.userRoleId==3)">
        <li><a href="manage.jsp"><i class="material-icons">settings</i>进入管理系统</a></li>
    </s:if>

    <li><a href="cart.jsp"><i class="material-icons">shopping_cart</i>购物车</a></li>
    <li><a href="logOut"><i class="material-icons">power_settings_new</i>退出</a></li>
</ul>

<div class="fixed-action-btn">
    <a data-activates="slide-out"  class="button-collapse btn-floating btn-large red ">
        <i class="large material-icons">add</i>
    </a>
</div>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<%--<script src="js/init.js"></script>--%>
<%--<script src="js/flt_button.js"></script>--%>
<script type="text/javascript">
    $(document).ready(function(){
        $('.modal').modal();
    });
</script>
<script> $(".button-collapse").sideNav();</script>
</body>
</html>
