<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
</head>

<body>
<div class="page" id="page-jy">
    <!-- infinite-scroll为向下滚动，pull-to-refresh-content为下拉刷新-->
    <div class="content infinite-scroll pull-to-refresh-content" data-distance="100" data-ptr-distance="55">
        <!-- 下拉刷新符 -->
        <div class="pull-to-refresh-layer">
            <div class="preloader"></div>
            <div class="pull-to-refresh-arrow"></div>
        </div>
        <div class="jy-list">
        <!--这里插入数据-->
        </div>
        <!-- 加载提示符 -->
        <div class="infinite-scroll-preloader">
            <div class="preloader"></div>
        </div>
    </div>
</div>
<!-- popup, panel 等放在这里 -->
<#include "common/panel.ftl">
</body>
<#include "common/js.ftl">
</html>