<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/xwcaseinfo.css">

<title>信息</title>
</head>

<body>
<%@include file="/head.jsp" %>
<div id="box">
<div id="xwtitle"><strong>寻&nbsp;物&nbsp;信&nbsp;息</strong></div>
<br>
<table width="700" height="300" border="1" style="border:solid  #ffcbb3;">
  <tbody>
    <tr>
      <td width="300" rowspan="6">
        <div id="imgbox"><img src="${pageContext.request.contextPath }/servlet/CaseImgServlet?imgurl=${xw.imgurl}"><div></td>
      <td width="300" height="40">标题：${xw.title }</td>
    </tr>
    <tr>
      <td height="40">丢失时间：${xw.time }</td>
    </tr>
    <tr>
      <td height="40">丢失地点：${xw.place }</td>
    </tr>
    <tr>
      <td height="40">发起用户：${xw.nickname }</td>
    </tr>
    <tr>
      <td height="40">用户联系方式：${xw.con }</td>
    </tr>
    <tr>
      <td height="96">
        <span>物品描述：</span>
        <textarea rows="10" disabled="disabled" style="background:white; width:400px; height:170px;">${xw.des }</textarea>
      </td>
    </tr>
  </tbody>
</table>
</div>
<%@include file="/foot.jsp" %>
</body>
</html>