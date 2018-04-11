<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
</head>

<body>
<%
	String is = (String)request.getAttribute("msg");
	if(is != null) {
%>
	<script type="text/javascript" language="javascript">
		alert("<%=is%>");                                            
	</script>	
<%
	}
%>
<%@include file="/head.jsp" %>
<div class="box">
  <form id="form1" action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
  <div class="title">登录账号
  </div>
  
  <div class="phone">手机号<br>
  <input type="text" style="height:35px; width:250px;" name="phone" value="${phone }">
  <div style="float:right" class="tip">${pmsg }</div>
  </div>
  
  <div class="pwd">密码<br>
  <input type="password" style="height:35px; width:250px;" name="pwd">
  <div style="float:right" class="tip">${pwmsg }</div>
  </div>
  
  <div class="code">验证码<br>
  <div id="codeboxleft">
    <input type="text" style="height:35px; width:150px;" name="checkcode">
  </div>
  <div id="codeboxright">
    <img height="35px" src="${pageContext.request.contextPath }/servlet/CheckCodeServlet" onclick="self.location.reload();"/>
  </div>
  <div style="float:right; position:relative; top:-30px;" class="tip">${codemsg }</div>
  </div>
  
  <div class="title2">
  <input type="radio" value="0">记住账号密码
  <div class="title3">
  <a href="#">忘记密码？</a>
  <a href="regist.jsp">马上注册</a></div>
  </div>
  
  <div class="login">
  <a onclick="document.getElementById('form1').submit();" href="#"></a>
  </div>
</form>
  
</div>
<%@include file="/foot.jsp" %>
</body>
</html>