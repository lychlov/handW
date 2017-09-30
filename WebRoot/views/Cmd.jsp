<%@ page language="java" import="java.util.*, com.boco.handw.model.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String type = (String)request.getAttribute("type");
	List<Cmd402> cmd402List = null;
	List<Cmd602> cmd602List = null;
	if (type.equals("402")) {
	    cmd402List = (List<Cmd402>)request.getAttribute("obj");
	}
	if (type.equals("602")) {
	    cmd602List = (List<Cmd602>)request.getAttribute("obj");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>   
    <title>掌W宝</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--移动端版本兼容 -->
<meta name="viewport" content="width=device-width, target-densityDpi=device-dpi">
<script type="text/javascript">
var phoneWidth = parseInt(window.screen.width);
var phoneScale = (phoneWidth/640);
var viewport = document.querySelector("meta[name=viewport]");if(isWeixin()){
viewport.setAttribute('content', 'width=640, initial-scale = '+phoneScale+', minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi');
}else{
viewport.setAttribute('content', 'width=640');
window.setTimeout(function(){
    viewport.setAttribute('content', 'width=640');
},1000);
}function isWeixin(){
var ua = navigator.userAgent.toLowerCase();
if(ua.match(/MicroMessenger/i)=="micromessenger") {
    return true;
} else {
    return false;
}
}</script>
	<!--移动端版本兼容 end -->
	<meta name="format-detection" content="telephone=no" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<link href="<%= path %>/css/mainstyle.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body style="border:0px; margin:0px">
  	<div class="header_blk"><img src="<%=path%>/images/zwb_logo_01.jpg" /></div>
	<div id='zlsj' class='area_blk'>
	  <div class="area_tit">
	  	<h3>指令数据</h3>
	  	<img src="<%=path%>/images/title_underline.png"/>
	  </div>
	  	  
  	<% if (type.equals("402")) { %>
  	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="infostyle2">
      <tr>
        <th align="center" valign="top" nowrap="nowrap">对象编号</th>
        <th align="center" valign="top" nowrap="nowrap">工作状态</th>
        <th align="center" valign="top" nowrap="nowrap">TRX频点</th>
      </tr>  
    <%if(cmd402List != null) {
		for (Cmd402 bean : cmd402List) { %>
      <tr>
        <td align="center"><%=bean.getObjectId() %></td>
        <td align="center"><%=bean.getWorkStatus() %></td>
        <td align="center"><%=bean.getTxrFrequency() %></td>
      </tr>
  	<%}
	}%>
	</table>
    <%}else if (type.equals("602")) { %>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="infostyle2">
      <tr>
        <th align="center" valign="center" nowrap="nowrap">本地小区标识</th>
        <th align="center" valign="center" nowrap="nowrap">小区的实例状态</th>
        <th align="center" valign="center">最近一次小区状态变化的原因</th>
      </tr>
    <% if(cmd602List != null) {
		for(Cmd602 bean : cmd602List) { %>
      <tr>
        <td align="center"><%=bean.getCellId() %></td>
        <td align="center"><%=bean.getCellStatus() %></td>
        <td align="center"><%=bean.getLatelyStaChangeReason() %></td>
      </tr>
    <%}
	}%>
  	</table>
 	<%} %>
	</div>
  </body>
</html>
