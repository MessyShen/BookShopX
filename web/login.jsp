<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/13
  Time: 下午5:13
  .     .
     ^ 
--%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*"  language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
<br><br><br><br><br><br><br><br>

<div class="container">
    <div class="row">
    <div class="col s12 m3"></div>
    <div class="col s12 m6">
        <div class="card-panel valign-wrapper">
            <%--<div class="row">--%>
            <div class="container">
            <h4 class="header2">登录</h4>
            <form action="doLogin" class="col s12">
                <div class="row">
                    <div class="input-field col s12">
                        <input id="users.loginId" name="users.loginId" type="text" class="validate">
                        <label for="users.loginId">用户名</label>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <input id="users.loginPwd" name="users.loginPwd" type="password" class="validate">
                        <label for="users.loginPwd">密码</label>
                    </div>
                </div>

                <button class="btn waves-effect waves-light" type="submit" name="action">登录
                    <i class="material-icons right">send</i>
                </button>
            <form>

            <%--</div>--%>
        </div>
    </div>
    <div class="col s12 m3"></div>
    </div>
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

