<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2020/12/15
  Time: 5:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Servlet注解的方式--%>
<%--<form action="login2" method="post">--%>
<%--web.xml配置--%>
<form action="login2" method="post">
    xml配置表单登录
    <br/>
    账号：<input type="text" name="userName"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="hidden" name="actiontype" value="login">
    <input type="submit" name="登录">
    <br/>
    <br/>
</form>

<form action="login" method="post">
    注解配置表单登录
    <br/>
    账号：<input type="text" name="userName"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="hidden" name="actiontype" value="login">
    <input type="submit" name="登录">
    <br/>
    <br/>
</form>

<form action="cookietest" method="get">
    <input type="submit" value="cookie测试">
</form>

<form action="dispatcher" method="get">
    <input type="submit" value="请求转发">
</form>
<form action="redirecttest" method="get">
    <input type="submit" value="重定向测试">
</form>
<form action="sessiontest" method="get">
    <input type="submit" value="session测试">
</form>

<button onclick="window.location='register.jsp'">注册</button>
</body>
</html>
