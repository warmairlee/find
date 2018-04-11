<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>留言反馈</title>
<style>
.submit {
	width: 150px;
	height: 40px;
	position: relative;
	left: 125px;
	top: 20px;
}
.submit a {
	background: url(${pageContext.request.contextPath }/images/feedback/submit.png) no-repeat;
	background-size: contain;
	display: block;
	height: 40px;
}
.tip{
    color:red;
}
</style>
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
<form id="form1" action="${pageContext.request.contextPath }/servlet/FeedbackServlet"  method="post">
  <div style="margin-right:auto; margin-left:auto; height:500px; width:500px">
    <h1>留言板</h1>
    <h2>标题</h2>
    <input type="text" style="width:400px; height:30px;" name="title">
    <div style="float:right" class="tip">${tmsg }</div>
    <h2>内容</h2>
    <textarea rows="10" style="width:400px;" name="des" ></textarea>
    <div style="float:right" class="tip">${dmsg }</div>
    <div class="submit"> <a href="#" onclick="document.getElementById('form1').submit();"></a> </div>
  </div>
</form>
<%@include file="/foot.jsp" %>
</body>
</html>

