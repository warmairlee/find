<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎来到“去找找”</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
</head>

<body>
<%
    String is = (String )request.getAttribute("msg");
    if(is != null){
%>
       <script type="text/javascript" language="javascript">
           alert("<%=is%>");
       </script>
<%    
    }
 %>
<%@include file="/head.jsp" %>
<div class="line2">

   <div class="left">
      <div class="top"></div>
      <div class="bottom">专业的寻物平台信息，加入标签定位和搜索
系统，让您的寻物过程更加高效<br><br>
         <div class="start">
         <a href="${pageContext.request.contextPath }/servlet/IsLoginXWServlet"><img src="${pageContext.request.contextPath }/images/index/leftb.png"></a>
         </div>
      </div>
    </div>
   
   <div class="middle"></div>
   
   <div class="right">
      <div class="top"></div>
      <div class="bottom">更加便利的招领平台，让善良的您享受
助人为乐带来的幸福感<br><br>
         <div class="start">
         <a href="${pageContext.request.contextPath }/servlet/IsLoginZLServlet"><img src="${pageContext.request.contextPath }/images/index/rightb.png"></a>
         </div>
      </div>
   </div>
   
</div>
<br>
<div class="line3">

    <div class="top">
      <img style="height:70px; " src="${pageContext.request.contextPath }/images/index/3.png">
      <br>
      <img style="height:250px;" src="${pageContext.request.contextPath }/images/index/adv.png">
    </div>
    <br><br>
    <div class="bottom">
       <img style="height:70px; " src="${pageContext.request.contextPath }/images/index/coo.png">
       <br>
       <img style="float:left;height:50px" src="${pageContext.request.contextPath }/images/index/coo1.png">
       <img style="float:right;height:50px" src="${pageContext.request.contextPath }/images/index/coo2.png">
    </div>
    
</div>
<%@include file="/foot.jsp" %>
</body>
</html>