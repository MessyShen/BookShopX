<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/17
  Time: 下午7:27
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
                    <a href="manage.jsp" class="breadcrumb">图书管理</a>
                    <a href="" class="breadcrumb">图书信息管理</a>
                </div>
            </div>
        </div>
    </nav>
    <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="material-icons">menu</i></a></div>
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
                <li class="bold"><a class="collapsible-header  waves-effect waves-teal">用户管理</a>
                    <div class="collapsible-body">
                        <ul>
                            <li class><a href="usersListByPage.action" class="collection-item">用户信息管理</a></li>
                            <li class><a href="userState.jsp" class="collection-item">用户状态管理</a></li>
                        </ul>
                    </div>
                </li>

                <li class="bold"><a class="collapsible-header  waves-effect waves-teal active">图书管理</a>
                    <div class="collapsible-body">
                        <ul>
                            <li class="active"><a href="listBookByPage.action" class="collection-item">图书信息管理</a></li>
                            <li class><a href="listCate2.action" class="collection-item">图书分类管理</a></li>
                            <li class><a href="usersListByPageState" class="collection-item">添加图书</a></li>
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
        <div class="row">
            <form action="searchByCond">
            <div class="input-field col s4">
                <select name="searchCond">
                    <option value="" disabled selected>搜索分类</option>
                    <option value="title">书名</option>
                    <option value="author">作者</option>
                    <option value="isbn">isbn</option>
                </select>
            </div>

            <div class="input-field col s4">
                <input id="searchBar" name="searchInfo" type="text" class="validate">
                <label for="searchBar">搜索内容</label>
            </div>

            <div class="col s4">
                <button class="btn waves-effect waves-light" type="submit">搜索
                    <i class="material-icons right">search</i>
                </button>
            </div>
            </form>
        </div>
        <table>
            <thead>
            <tr>
                <th data-field="id">id</th>
                <th data-field="name">Title</th>
                <th>ISBN</th>
                <th>删除</th>
                <th>修改信息</th>
            </tr>
            </thead>

            <tbody>
            <s:iterator id="biItem" value="#request.BOOKS_LIST">
                <tr>
                    <td>${biItem.id}</td>
                    <td>${biItem.title}</td>
                    <td>${biItem.isbn}</td>
                    <td><a class="waves-effect waves-light btn" href="#modalX${biItem.id}">删除</a></td>
                        <%--<td><a href="deleteById?users.id=${uiItem.id}" class="waves-effect waves-light btn">删除</a></td>--%>
                    <td><a class="waves-effect waves-light btn" href="#modal${biItem.id}">修改</a></td>
                </tr>

                <div id="modalX${biItem.id}" class="modal">
                    <div class="modal-content">
                        <h4>删除确认</h4>
                        <p>确定要删除图书 ${biItem.title} 吗？</p>
                    </div>
                    <div class="modal-footer">
                        <a href="deleteBookById?bkid=${biItem.id}" class="waves-effect waves-light btn">删除</a>
                        <a class=" modal-action modal-close waves-effect waves-green btn-flat">别别别</a>
                    </div>
                </div>

                <div id="modal${biItem.id}" class="modal">
                    <div class="modal-content">
                        <h4>${biItem.title}</h4>
                        <div class="chip">
                            ID:${biItem.id}
                        </div>
                        <div class="chip">
                            ISBN:${biItem.isbn}
                        </div>
                        <div class="chip">
                            ￥${biItem.unitPrice}
                        </div>
                        <p>出版社：${biItem.publishers.name}<p>
                        <p>分类：${biItem.categories.name}</p>
                        <p>作者：${biItem.author}</p>
                        <p>描述：${biItem.contentDescription}</p>
                        ${biItem.toc}
                    </div>
                    <div class="modal-footer">
                        <a href="jumpToModify?bkid=${biItem.id}" class="waves-effect waves-light btn">修改</a>
                        <a class=" modal-action modal-close waves-effect waves-green btn-flat">关闭</a>
                    </div>
                </div>
            </s:iterator>
            </tbody>
        </table>
        <s:if test="(#request.BOOKS_LIST.size()>10)">
        <ul class="pagination">
            <li class="disabled"><a href="listBookByPage?stPage=1"><i class="material-icons">chevron_left</i></a></li>
            <li class="waves-effect"><a href="listBookByPage?stPage=1">1</a></li>
            <li class="waves-effect"><a href="listBookByPage?stPage=2">2</a></li>
            <li class="waves-effect"><a href="listBookByPage?stPage=3">3</a></li>
            <li class="waves-effect"><a href="listBookByPage?stPage=4">4</a></li>
            <li class="waves-effect"><a href="listBookByPage?stPage=5">5</a></li>
            <li class="waves-effect"><a href="listBookByPage?stPage=5"><i class="material-icons">chevron_right</i></a></li>
        </ul>
        </s:if>
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

<script type="text/javascript">
    $('.pagination li').on('click',function () {
        $('.pagination li').removeClass('active');
        $(this).addClass('active');
    });
</script>

<script type="text/javascript">
    function searchBookBy(){
        var searchDescribe = document.getElementById("searchBar").value;
        var searchCond = document.getElementById("searchCondSelect").value;
        location.href="searchByCond?searchCond="+searchCond+"&searchInfo="+searchDescribe;
    }
</script>

<script> $(".button-collapse").sideNav();</script>
<script>
    $(document).ready(function() {
        $('select').material_select();
    });

</script>
</body>
</html>
