<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>寻物</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/xw.css">
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

  <div id="searchbar">
    <form action="${pageContext.request.contextPath }/servlet/XWCaseListServlet" method="post">
      标题：<input type="text" name="title" value="${ title}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      地点：<input type="text" name="place" value="${place }"><br>     
      丢失时间：<select name="year1">
              <option value="2014">2014年</option>
              <option value="2015">2015年</option>
              <option value="2016">2016年</option>
              <option value="2017">2017年</option>
              <option value="2018">2018年</option>
            </select>
            
            <select name="month1">
              <option value="1">1月</option>
              <option value="2">2月</option>
              <option value="3">3月</option>
              <option value="4">4月</option>
              <option value="5">5月</option>
              <option value="6">6月</option>
              <option value="7">7月</option>
              <option value="8">8月</option>
              <option value="9">9月</option>
              <option value="10">10月</option>
              <option value="11">11月</option>
              <option value="12">12月</option>
            </select>
            
            <select name="day1" value=>
              <option value="1">1日</option>
              <option value="2">2日</option>
              <option value="3">3日</option>
              <option value="4">4日</option>
              <option value="5">5日</option>
              <option value="6">6日</option>
              <option value="7">7日</option>
              <option value="8">8日</option>
              <option value="9">9日</option>
              <option value="10">10日</option>
              <option value="11">11日</option>
              <option value="12">12日</option>
              <option value="13">13日</option>
              <option value="14">14日</option>
              <option value="15">15日</option>
              <option value="16">16日</option>
              <option value="17">17日</option>
              <option value="18">18日</option>
              <option value="19">19日</option>
              <option value="20">20日</option>
              <option value="21">21日</option>
              <option value="22">22日</option>
              <option value="23">23日</option>
              <option value="24">24日</option>
              <option value="25">25日</option>
              <option value="26">26日</option>
              <option value="27">27日</option>
              <option value="28">28日</option>
              <option value="29">29日</option>
              <option value="30">30日</option>
              <option value="31">31日</option>
            </select>
            -
            <select name="year2">
              <option value="2014">2014年</option>
              <option value="2015">2015年</option>
              <option value="2016">2016年</option>
              <option value="2017">2017年</option>
              <option selected="selected" value="2018">2018年</option>>
            </select>
            
            <select name="month2">
              <option value="1">1月</option>
              <option value="2">2月</option>
              <option value="3">3月</option>
              <option value="4">4月</option>
              <option value="5">5月</option>
              <option value="6">6月</option>
              <option value="7">7月</option>
              <option value="8">8月</option>
              <option value="9">9月</option>
              <option value="10">10月</option>
              <option value="11">11月</option>
              <option selected="selected" value="12">12月</option>
            </select>
            
            <select name="day2">
              <option value="1">1日</option>
              <option value="2">2日</option>
              <option value="3">3日</option>
              <option value="4">4日</option>
              <option value="5">5日</option>
              <option value="6">6日</option>
              <option value="7">7日</option>
              <option value="8">8日</option>
              <option value="9">9日</option>
              <option value="10">10日</option>
              <option value="11">11日</option>
              <option value="12">12日</option>
              <option value="13">13日</option>
              <option value="14">14日</option>
              <option value="15">15日</option>
              <option value="16">16日</option>
              <option value="17">17日</option>
              <option value="18">18日</option>
              <option value="19">19日</option>
              <option value="20">20日</option>
              <option value="21">21日</option>
              <option value="22">22日</option>
              <option value="23">23日</option>
              <option value="24">24日</option>
              <option value="25">25日</option>
              <option value="26">26日</option>
              <option value="27">27日</option>
              <option value="28">28日</option>
              <option value="29">29日</option>
              <option value="30">30日</option>
              <option selected="selected value="31">31日</option>
            </select>
      <input type="submit" value="搜索">
    </form>
    <font color="grey">当前搜索时间为：<font color="#ff5809"><strong>${time1 }</strong></font>&nbsp;至&nbsp;<font color="#ff5809"><strong>${time2 }</strong></font></font>
    <div id="fb"><a href="${pageContext.request.contextPath }/servlet/IsLoginXWServlet"></a></div>
  </div>


<div style="clear:both;"></div>

<div id="contentbox">
<c:forEach items="${list}" var="xw">
  <div id="xw">
  <a href="${pageContext.request.contextPath }/servlet/XWCaseInfoServlet?num=${xw.num}">
    <div id="xw_img"><img src="${pageContext.request.contextPath }/servlet/CaseImgServlet?imgurl=${xw.imgurl}"></img></div>
    </a>
    <div id="xw_title">标题：
      <div id="content">
         <a href="${pageContext.request.contextPath }/servlet/XWCaseInfoServlet?num=${xw.num}">${xw.title }</a>
      </div>
    </div>
    <div id="xw_time">丢失时间：
      <div id="content">${xw.time }</div>
    </div>
    <div id="xw_place">丢失地点：
      <div id="content">${xw.place }</div>
    </div>
    <div id="xw_des"><textarea disabled="disabled" rows="7" style="height:100px; font-size:16px; background:white; width:190px;">${xw.des }</textarea></div>
  </div>
</c:forEach>
</div>
<div style="clear:both;"></div>
<div id="page">
<div style="float:left;">
<a href="${pageContext.request.contextPath }/servlet/XWCaseListServlet?curPage=1">首页</a>&nbsp;
<a href="${pageContext.request.contextPath }/servlet/XWCaseListServlet?curPage=${curPage - point }">上一页</a>&nbsp;
<font color="#ff5809">当前第${curPage }页&nbsp;</font>
<a href="${pageContext.request.contextPath }/servlet/XWCaseListServlet?curPage=${curPage + point }">下一页</a>&nbsp;
<a href="${pageContext.request.contextPath }/servlet/XWCaseListServlet?curPage=${pageCount}">尾页</a>
</div>
<div style="float:right;">
<font color="#ff5809">共${pageCount}页</font>
</div>
</div>
<%@include file="/foot.jsp" %>
</body>
</html>
