<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/13
  Time: 下午4:02
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
    <%--<s:action name="list" executeResult="false"/>--%>
    <nav>
        <div class="nav-wrapper blue-grey darken-3">
            <a href="index.jsp" class="brand-logo"></a>
            <%--<div class="input-field">--%>
            <%--<input id="search" type="search" required>--%>
            <%--<label class="label-icon" for="search"><i class="material-icons">search</i></label>--%>
            <%--<i class="material-icons">close</i>--%>
            <%--</div>--%>
            <ul id="nav" class="right hide-on-med-and-down">
                <s:if test="(#session.CURRENT_USER==null)">
                    <li><a href="login.jsp">登录</a></li>
                    <li><a href="reg.jsp">注册</a></li>
                </s:if>
                <s:else>
                    <li><a href="#">${sessionScope.CURRENT_USER.name}</a></li>
                    <li><a href="logOut">退出</a></li>
                    <li><a href="toMyOrderInfo">我的订单</a></li>
                </s:else>

                <li><a href="cart.jsp"><i class="material-icons">shopping_cart</i></a></li>
                <%--<li><a href="#" data-activates="slide-out" class="btn">侧边导航</a></li>--%>
            </ul>
        </div>
    </nav>
    <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="material-icons">menu</i></a></div>
    <ul id="nav-mobile" class="side-nav fixed" style="transform: translateX(0%);">
        <li class="logo">
            <a id="logo-container" href="index.jsp" class="brand-logo">
                <object id="front-page-logo" type="image/svg+xml" data="images/third-wave3.svg">你的浏览器不支持SVG</object>
            </a>
        </li>
        <li class="search">
            <div class="search-wrapper card">
                <input id="search" type="text"><i class="material-icons" onclick="searchBook()">search</i>
                <div class="search-results"></div>
            </div>
        </li>
        <%--<li class="bold "><a href="/about.html" class="waves-effect waves-teal">关于我们</a></li>--%>
        <%--<li class="bold "><a href="/getting-started.html" class="waves-effect waves-teal">开始学习</a></li>--%>
        <li class="no-padding">
            <ul class="collapsible collapsible-accordion">
                <li class="bold active">
                    <a class="collapsible-header waves-effect waves-teal active">分类</a>
                    <div class="collapsible-body">
                        <ul>
                            <s:iterator id="typeItem" value="#request.categoriesList">
                                <%--<s:if test="(#request.cate==${typeItem.id})">--%>
                                <%--<li class><a href="listBookByCates?cate=${typeItem.id}" class="collection-item active">${typeItem.name }</a></li>--%>
                                <%--</s:if>--%>
                                <%--<s:else>--%>
                                <li class><a href="listBookByCates?cate=${typeItem.id}" class="collection-item">${typeItem.name }</a></li>
                                <%--</s:else>--%>
                            </s:iterator>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
</header>
<main>
    <div class="container">
        <div class="row">
            <h2>${requestScope.detailedBook.title}</h2>
        </div>
        <div class="row">
            <div class="col s12 m4">
                <img class="materialboxed z-depth-5" width="300" src="images/BookCovers/${requestScope.detailedBook.isbn}.jpg">
            </div>
            <div class="col s12 m8">
                <p>书名：${requestScope.detailedBook.title }</p>
                <p>作者：${requestScope.detailedBook.author }</p>
                <p>出版社：${requestScope.detailedBook.publishers.name }</p>
                <p>ISBN：${requestScope.detailedBook.isbn }</p>
                <h4 class="blue-text">￥${requestScope.detailedBook.unitPrice }</h4>
                <a href="addtoshopcart?booksId=${requestScope.detailedBook.id }"
                   class="waves-effect waves-light btn"><i class="material-icons right">shopping_cart</i>加入购物车</a>
            </div>
        </div>
        <div class="row">

            <div class="col s12 m6">
                <h4>商品简介：</h4>
                 ${requestScope.detailedBook.contentDescription}
            </div>
            <div class="col s12 m6">
                <h4>目录：</h4>
                ${requestScope.detailedBook.toc}
            </div>
        </div>


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
<script> $(".button-collapse").sideNav();</script>
<script type="text/javascript">
    <!--
    function searchBook(){
        var searchDescribe = document.getElementById("search").value;
        location.href="searchBy?"+"searchInfo="+searchDescribe;
    }
    //-->
</script>
</body>
</html>
