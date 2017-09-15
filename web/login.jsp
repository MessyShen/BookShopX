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


<html>
<head>
    <title>登录界面</title>
</head>


<body>
<s:form action="doLogin">
    <table>
        <tr>
            <s:textfield name="users.loginId" label="用户名" />
        </tr>
        <tr>
            <s:textfield name="users.loginPwd" label="密码" />
        </tr>
        <tr>
            <s:submit value="登录" />
        </tr>
    </table>
</s:form>

</body>
</html>

