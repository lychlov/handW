<%@ page language="java" import="java.util.*, com.boco.handw.model.Alarm" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
List<Alarm> alarmList =	(List<Alarm>)request.getAttribute("obj");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>掌W宝</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--移动端版本兼容 -->
	<meta name="viewport" content="width=device-width, target-densityDpi=device-dpi">
	<script type="text/javascript">
		var phoneWidth = parseInt(window.screen.width);
		var phoneScale = (phoneWidth/640);
		var viewport = document.querySelector("meta[name=viewport]");
		if(isWeixin()){
			viewport.setAttribute('content', 'width=640, initial-scale = '+phoneScale+', minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi');
		} else {
			viewport.setAttribute('content', 'width=640');
			window.setTimeout(function(){	
			    viewport.setAttribute('content', 'width=640');
			},1000);
		}
		function isWeixin(){
			var ua = navigator.userAgent.toLowerCase();
			if(ua.match(/MicroMessenger/i)=="micromessenger") {
			    return true;
			} else {
			    return false;
			}
		}
	</script>
	<!--移动端版本兼容 end -->
	<meta name="format-detection" content="telephone=no" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<link href="<%=path%>/css/mainstyle.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
	<div class="header_blk"><img src="<%=path%>/images/zwb_logo_01.jpg" /></div>
	<!--头部-->
	<!--内容1告警数据开始-->
	<div id="zlsj" class="area_blk">
	  	<div class="area_tit">
		  	<h3>告警数据</h3>
		  	<img src="<%=path%>/images/title_underline.png"/>
	  	</div>

	<%   
  		if(alarmList != null && alarmList.size() > 0){
  			int count = 1;
			for(Alarm bean:alarmList){
   	%>
	  <table border="0" cellpadding="0" cellspacing="0" class="infostyle2">
	    <tr>
	      <th width="25%" align="left" valign="top" nowrap="nowrap">序号</th>
	      <td width="75%" align="left" valign="top" ><%=bean.getNum() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap" >网元名称</th>
	      <td align="left"><%=bean.getNeName() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">所属区县</th>
	      <td align="left"><%=bean.getRegion() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">设备厂家</th>
	      <td align="left" ><%=bean.getVender() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">告警发生时间</th>
	      <td align="left"><%=bean.getAlarmTime() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">厂家告警号</th>
	      <td align="left"><%=bean.getAlarmNum() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap" >告警中文名</th>
	      <td align="left"><%=bean.getAlarmTitle() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">告警对象名称</th>
	      <td align="left"><%=bean.getAlarmStation() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">基站编号</th>
	      <td align="left" ><%=bean.getStationNum() %></td>
	    </tr>
	    <tr>
	      <th align="left" nowrap="nowrap">基站名称</th>
	      <td align="left"><%=bean.getStationName() %></td>
	    </tr>
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
