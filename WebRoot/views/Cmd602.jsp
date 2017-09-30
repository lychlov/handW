<%@ page language="java" import="java.util.*, com.boco.handw.model.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	List<Cmd602> cmd602List = (List<Cmd602>)request.getAttribute("obj");
	
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
    
  <body>
	<div class="header_blk"><img src="<%=path%>/images/zwb_logo_01.jpg" /></div>
	<!--头部-->
	<!--内容1告警数据开始-->
	<div id="zlsj" class="area_blk">
	  	<div class="area_tit">
		  	<h3>指令数据</h3>
		  	<img src="<%=path%>/images/title_underline.png"/>
	  	</div>

	<%   
  		if(cmd602List != null && cmd602List.size() > 0){
  			int count = 1;
			for(Cmd602 bean:cmd602List){
  
   	%>
	  <table border="0" cellpadding="0" cellspacing="0" class="infostyle2">
	    <tr>
	      <th width="25%" align="left" valign="top" nowrap="value">本地小区标识</th>
	      <td width="75%" align="left" valign="top" ><%=bean.getCellId() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap" >小区的实例状态</th>
	      <td align="left"><%=bean.getCellStatus() %></td>
	    </tr>
	    <tr>
	      <th align="left" >最近一次小区状态变化的原因</th>
	      <td align="left"><%=bean.getLatelyStaChangeReason() %></td>
	    </tr>
	    <%
	    if(bean.getBsic()!=null){
	    %>
	    <tr>
	      <th align="left" nowrap="nowrap">基站标识</th>
	      <td align="left" ><%=bean.getBsic() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">射频单元信息</th>
	      <td align="left"><%=bean.getRFUnitInfo() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">发射通道号</th>
	      <td align="left"><%=bean.getTransChan() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap" >接收通道号</th>
	      <td align="left"><%=bean.getReceiveChan() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">服务基带处理板信息</th>
	      <td align="left"><%=bean.getBaseband() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">工作状态</th>
	      <td align="left" ><%=bean.getWorkStatus() %></td>
	    </tr>
	    <%
	    }
	    %>
	  </table>
 	<%  
       		}
		}
	%>
	</div>
	<!--  <div align="center"><input type="button" value="返回" onclick="javascript:window.close();" /></div>-->
	 <div class="ctrl_page"><span onclick="javascript:WeixinJSBridge.call('closeWindow');" ><a href="#"> 返回 </a></span></div>
	<br/>
  </body>
</html>