<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/changepwd.css">
  </head>
  
  <body>
  <%@include file="/head.jsp"%>
  <div id="box">
    <form action="${pageContext.request.contextPath }/servlet/ChangePWDServlet" method="post">
          原密码：<br><input type="password" name="pwd1"><br>
          <font  style="color:red; font-size:15px;float:right;">${msg1 }</font><br>
          新密码：<br><input type="password" name="pwd2"><br>
          <font  style="color:red; font-size:15px;float:right;">${msg2 }</font><br>
          确认新密码：<br><input type="password" name="pwd3"><br><br>
      <div id="but"><input style="width:100px; border-radius:5px; background:#84c1ff; color:white; font-size:17px;" type="submit" value="确认修改"></div>
    </form>
  </div>
    <%@include file="/foot.jsp"%>
  </body>
</html>
