<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/17
  Time: 下午7:26
  .     .
     ^ 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addBookTest" enctype="multipart/form-data" method="post">
    <table>
        <tr><input name="pic" type="file"></tr>
        <tr><input name="picFileName" label="ISBN"></tr>
        <tr><input type="submit" value="上传"></tr>
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

</body>
</html>
