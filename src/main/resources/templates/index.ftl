<!DOCTYPE html>
<html>
<head>

<title>Travel旅游助手</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<#include "common/base.ftl">
</head>
<body>

	<!-- page集合的容器，里面放多个平行的.page，其他.page作为内联页面由路由控制展示 -->
	<div class="page-group">
		
		
		<!-- 第一个page求助-->
	<div class="page page-current" id='router1'>

	<#include "help.ftl">
		
	<!--第二个page解决界面-->
	<div class="page" id='router2'><#include "resolve.ftl"></div>
	
	<!--第三个page设置界面-->
	<div class="page" id='router3'><#include "settings.ftl"></div>
	
	</div>
	
	<!-- popup, panel 等放在这里 -->
	<<#include "common/panel.ftl">

</body>
</html>
