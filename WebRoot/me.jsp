<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/css/me.css">
</head>

<body>
<%@include file="/head.jsp" %>
<div id="box">
<table width="700" height="364" border="1">
  <tbody>
    <tr>
      <td height="100" colspan="2"><div id="tbg"></div></td>
    </tr>
    <tr>
      <td width="361" rowspan="6">
        <div id="headp"><img src="${pageContext.request.contextPath }/servlet/CaseImgServlet?imgurl=${loginUser.headp}"></div>
      </td>
    </tr>
    <tr>
      <td width="657" height="50"><font color="#5A5858">绑定手机号码：</font>${loginUser.phone }</td>
    </tr>
    <tr>
      <td height="50"><font color="#5A5858">昵称：</font>${loginUser.nickname }</td>
    </tr>
    <tr>
      <td height="50"><font color="#5A5858">绑定邮箱：</font>${loginUser.email }</td>
    </tr>
    <tr>
      <td><font color="#5A5858">个性签名：</font><br>
        <textarea disabled="disabled" rows="6" style="background:white; width:90%; margin-left:10px;padding-letf:0px;" >${loginUser.autograph }</textarea>
        <span><a href="${pageContext.request.contextPath }/changeme.jsp"><input style="float:right;margin-right:20px;" type="button" value="点击修改基本信息"></a></span>
      </td>
    </tr>
    <tr>
      <td height="50">
        <div id="but">
          <span class="pwd"><a href="${pageContext.request.contextPath }/changepwd.jsp">修改密码</a></span>
          <span class="xw"><a href="${pageContext.request.contextPath }/servlet/myXWCaseListServlet">查看我的寻物</a></span>
          <span class="zl"><a href="${pageContext.request.contextPath }/servlet/myZLCaseListServlet">查看我的招领</a></span>
        </div>
      </td>
    </tr>
    <tr>
      <td height="140" colspan="2"><div id="bbg"><div></td>
    </tr>
  </tbody>
</table>
</div>
<%@include file="/foot.jsp" %>
</body>
</html>
