<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/regist.css">
</head>

<body>
<%@include file="/head.jsp" %>
<div class="box">
 
  <div class="title">注册账号</div>
  
<form id="form1" action="${pageContext.request.contextPath }/servlet/RegistServlet" method="post">
  <div class="phone">手机号*<br>
  <input type="text" style="height:20px; width:250px;" name="phone" value="${phone }">
  <div style="float:right" class="tip">${pmsg }</div>
  </div>
  
  <div class="pwd">密码*<br>
  <input type="password" style="height:20px; width:250px;" name="pwd">
  <div style="float:right" class="tip">${pwdmsg }</div>
  </div>
  
  <div class="pwd2">确认密码*<br>
  <input type="password" style="height:20px; width:250px;" name="pwd2">
  <div style="float:right" class="tip">${pwd2msg }</div>
  </div>
  
  <div class="nickname">昵称*<br>
  <input type="text" style="height:20px; width:250px;" name="nickname" value="${nickname }">
  <div style="float:right" class="tip">${nmsg }</div>
  </div>
  
  <div class="checkcode">验证码*<br>
    <div id="checkcodeboxleft">
      <input type="text" style="height:25px; width:150px;" name="checkcode">
    </div>
    <div id="checkcodeboxright">
      <img height="25px" src="${pageContext.request.contextPath }/servlet/CheckCodeServlet" onclick="self.location.reload();"/>
    </div>
    <div style="float:right; position:relative; top:-20px;" class="tip">${codemsg }</div>
  </div>
</form>

  <div class="submit" >
  <a  href="#" onclick="document.getElementById('form1').submit();"></a>
  </div>
  


  <div class="line"></div>
  <div class="title2">已经有账号？
  </div>
  <div class="login">
  <a href="login.jsp"></a>
  </div>
  
</div>
<%@include file="/foot.jsp" %>
</body>
</html>