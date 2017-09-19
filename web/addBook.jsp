<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/17
  Time: 下午7:26
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
<div class="container">
    <div class="row">
        <div class="col s12 m3"></div>
        <div class="col s12 m6">
            <div class="card-panel valign-wrapper">
                <%--<div class="row">--%>
                <div class="container">
                    <h4 class="header2">添加图书</h4>
                    <form action="addBook" enctype="multipart/form-data" method="post">
                        <table>


                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="bk.title" name="bk.title" type="text" class="validate">
                                    <label for="bk.title">书名</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="bk.author" name="bk.author" type="text" class="validate">
                                    <label for="bk.author">作者</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="bk.isbn" name="bk.isbn" type="text" class="validate">
                                    <label for="bk.isbn">ISBN</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="bk.unitPrice" name="bk.unitPrice" type="number" class="validate">
                                    <label for="bk.unitPrice">单价</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <select name="bk.publisherId">
                                        <option value="" disabled selected>选择出版社</option>
                                        <option value="72">安徽文艺出版社</option>
                                        <option value="16">北京交通大学出版社</option>
                                        <option value="13">北京大学出版社</option>
                                    </select>
                                    <label>出版社</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <select name="bk.categoryId">
                                        <option value="" disabled selected>选择类别</option>
                                        <option value="1">C#</option>
                                        <option value="2">J2EE</option>
                                        <option value="4">CSS Div</option>
                                    </select>
                                    <label>图书类别</label>
                                </div>
                            </div>

                            <s:file name="pic" label="上传封面" />

                            <div class="row">
                                <div class="file-field input-field col s12">
                                    <%--<div class="btn">--%>
                                        <%--<span>封面</span>--%>
                                        <%--<input name="pic" type="file">--%>
                                    <%--</div>--%>
                                    <%--<div class="file-path-wrapper">--%>
                                        <%--<input class="file-path validate" type="text">--%>
                                    <%--</div>--%>
                                        <%--<s:file name="pic" label="上传封面" />--%>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="bk.publishDate">出版日期</label>
                                 <input type="date" id="bk.publishDate" name="bk.publishDate" class="datepicker validate">
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea id="textarea1" name="bk.contentDescription"class="materialize-textarea" length="200"></textarea>
                                    <label for="textarea1">描述</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea id="textarea2" name="bk.toc" class="materialize-textarea" length="1000"></textarea>
                                    <label for="textarea2">目录</label>
                                </div>
                            </div>



                            <button class="btn waves-effect waves-light" type="submit" name="action">确认添加
                                <i class="material-icons right">send</i>
                            </button>



                            <%--<tr><input name="bk.title" type="text" lable="书名"></tr>--%>
                            <%--<tr><input name="bk.author" type="text" lable="作者"></tr>--%>
                            <%--<tr><input name="pic" type="file"></tr>--%>
                            <%--<tr><input name="pi.author" type="text" lable="作者"></tr>--%>
                            <%--<tr><input type="submit" value="上传"></tr>--%>
                            <%--<tr>--%>
                            <%--<s:textfield name="bk.title" label="书名" />--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<s:textfield name="bk.isbn" label="ISBN" />--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<s:textfield name="bk.author" label="作者" />--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<s:textfield name="bk.publisherId" label="出版编号" />--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<s:textfield name="bk.publisherId" label="出版编号" />--%>
                            <%--</tr>--%>

                            <%--<tr>--%>
                            <%--<s:submit value="登录" />--%>
                            <%--</tr>--%>
                        </table>
                    </form>


                    <%--</div>--%>
                </div>
            </div>
            <div class="col s12 m3"></div>
        </div>
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

<script type="text/javascript">
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 40 // Creates a dropdown of 15 years to control year
    });
</script>
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>
</body>
</html>
