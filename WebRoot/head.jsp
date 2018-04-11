<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>head</title>
<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/head.css" type="text/css" >
</head>

<body>
<div class="tbg">
  <div class="log1"></div>
  <div class="log2"></div>
  <div class="log3"></div>
  <div id="sth">
		<div id="userinfo">
		  <c:if test="${loginUser!=null}">
			欢迎:&nbsp;${loginUser.nickname}&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
		  </c:if>
		  <c:if test="${loginUser==null}">
			<a href="${pageContext.request.contextPath }/login.jsp">登录</a>&nbsp;|&nbsp;
			<a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
		  </c:if>
		</div>
	</div>
</div>

<div class="bbg">
  <div class="daohang">
    <ul>
      <li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
      <li><a href="${pageContext.request.contextPath }/servlet/MeServlet">我的找找</li>
      <li><a href="${pageContext.request.contextPath }/servlet/XWCaseListServlet">寻物</a></li>
      <li><a href="${pageContext.request.contextPath }/servlet/ZLCaseListServlet">招领</a></li>
      <li><a href="${pageContext.request.contextPath }/feedback.jsp">留言反馈</a></li>
      <li><a href="${pageContext.request.contextPath }/aboutus.jsp">关于我们</a></li>
    </ul>
    </div>
</div>
</body>
</html>