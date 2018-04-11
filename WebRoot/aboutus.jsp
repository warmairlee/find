<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>关于我们</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/aboutus.css">
</head>

<body>
<%@include file="/head.jsp" %>
<div style="margin-right:auto; margin-left:auto; width:775px; height:600px">
<table width="755" height="530" border="1">
  <tbody>
    <tr>
      <td width="177" align="center">
         <div class="gywm">
            <a href="${pageContext.request.contextPath }/gywm.html" target="win"></a>
         </div>
          <br>
          <div class="lxwm">
            <a href="${pageContext.request.contextPath }/lxwm.jsp" target="win"></a>
         </div>
      </td>
      <td width="562">
          <iframe name="win" width="100%" height="100%" src="${pageContext.request.contextPath }/gywm.html"></iframe>
      </td>
    </tr>
  </tbody>
</table>
</div>
<%@include file="/foot.jsp" %>
</body>
</html>
