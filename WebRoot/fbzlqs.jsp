<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>发布招领启事</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/fbzlqs.css">
</head>

<body>
<%@include file="/head.jsp" %>
<form action="${pageContext.request.contextPath}/servlet/ZhaolingServlet" method="post" enctype="multipart/form-data">
  <table width="600" height="440" border="0" align="center">
    <tbody>
      <tr>
        <td colspan="2" class="title">发布招领启事</td>
      </tr>
      <tr>
        <td width="174">标题*</td>
        <td width="275">
          <input class="text" type="text" value="${title}" name="title" >
         <td class="tip">${timsg}</td>
      </tr>
      <tr>
        <td>发现日期*</td>
        <td>
          <div align="left">
            <select name="year" value="${year }">
              <option value="2014">2014年</option>
              <option value="2015">2015年</option>
              <option value="2016">2016年</option>
              <option value="2017">2017年</option>
              <option value="2018">2018年</option>
            </select>
            
            <select name="month" value="${month }">
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
            
            <select name="day" value="${day }">
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
          </div>
      </tr>
      <tr>
        <td>发现地点*</td>
        <td>
          <input class="text" type="text" value="${place }" name="place">
          <td class="tip">${pmsg}</td>
      </tr>
      <tr>
        <td>物品描述*</td>
        <td>
          <textarea class="text" name="des" rows="6" value="${des }"></textarea>
          <td class="tip">${dmsg}</td>
      </tr>
      <tr>
        <td height="39">联系方式*</td>
        <td>
          <input class="text" type="text" value="${con }" name="con"/>
        <td class="tip">${cmsg}</td>
      </tr>
      <tr>
        <td>图片上传</td>
        <td><input type="file" name="uploadFile"/>
        <td class="tip">${imgmsg}</td>
        </td>
      </tr>
      <tr>
        <td height="39">验证码*</td>
        <td>
          <div id="checkcodeboxleft">
            <input type="text" style="height:25px; width:150px;" name="checkcode">
          </div>
          <div id="checkcodeboxright">
            <img height="25px" src="${pageContext.request.contextPath }/servlet/CheckCodeServlet" onclick="self.location.reload();"/>
          </div>
          <div style="float:right; position:relative; top:-20px;" class="tip">${codemsg }</div>
      </tr>
      <tr>
        <td colspan="2">
          <div align="center">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input style="border-radius:5px; font-size:17px; height:40px; width:100px; background:red; color:white; font-weight:bold;" type="submit" value="确认发布">
           &nbsp;&nbsp;
            <input style="border-radius:5px; font-size:17px; height:40px; width:100px;background:#66b3ff; color:white; font-weight:bold;" type="reset" value="重置">
            </div>
        </td>
      </tr>
    </tbody>
  </table>
 </form>
 <%@include file="/foot.jsp" %>
</body>
</html>