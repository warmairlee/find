<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/zlcaseinfo.css">

<title>信息</title>
</head>

<body>
<%@include file="/head.jsp" %>
<div id="box">
<div id="zltitle"><strong>招&nbsp;领&nbsp;信&nbsp;息</strong></div>
<br>
<table width="700" height="300" border="1" style="border:solid  #ACD6FF;">
  <tbody>
    <tr>
      <td width="300" rowspan="6">
        <div id="imgbox"><img src="${pageContext.request.contextPath }/servlet/CaseImgServlet?imgurl=${zl.imgurl}"><div></td>
      <td width="300" height="40">标题：${zl.title }</td>
    </tr>
    <tr>
      <td height="40">发现时间：${zl.time }</td>
    </tr>
    <tr>
      <td height="40">发现地点：${zl.place }</td>
    </tr>
    <tr>
      <td height="40">发现用户：${zl.phone }</td>
    </tr>
    <tr>
      <td height="40">用户联系方式：${zl.con }</td>
    </tr>
    <tr>
      <td height="96">
        <span>物品描述：</span>
        <textarea rows="10" disabled="disabled" style="background:white; width:400px; height:170px;">${zl.des }</textarea>
      </td>
    </tr>
  </tbody>
</table>
</div>
<%@include file="/foot.jsp" %>
</body>
</html>