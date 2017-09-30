<%@ page language="java" import="java.util.*, com.boco.handw.model.Topo" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	Topo topo =	(Topo)request.getAttribute("obj");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>掌W宝</title>
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
	<!--内容1拓扑数据开始-->
	<div id="zlsj" class="area_blk">
  	<div class="area_tit">
	  	<h3>拓扑数据</h3>
	  	<img src="<%=path%>/images/title_underline.png"/>
  	</div>
	  <ul id="order1" class="infostyle1">
	    <li class="infostyle1_clum1"><span>用户账号</span>=<%=topo.getAccount() %></li>
	    <li class="infostyle1_clum1"><span>开户带宽</span>=<%=topo.getBandwidth() %></li>
	    <li class="infostyle1_clum1"><span>安装地址</span>=<%=topo.getAddress() %></li>
	    <li class="infostyle1_clum1"><span>ONU</span>=<%=topo.getOnu() %></li>
	    <li class="infostyle1_clum1"><span>认证值</span>=<%=topo.getAuthenValue() %></li>
	  </ul>
	</div>
  </body>
</html>
