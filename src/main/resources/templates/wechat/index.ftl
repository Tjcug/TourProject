<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
</head>

<body>
<div class="page" id="page-jy">

    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="icon icon-me pull-left open-panel"></a>
        <a class="button button-link button-nav pull-right">
            地图
        </a>
        <h1 class="title">及应</h1>
    </header>

    <!-- infinite-scroll为向下滚动，pull-to-refresh-content为下拉刷新-->
    <div class="content infinite-scroll pull-to-refresh-content">
        <!-- 下拉刷新符号 -->
        <div class="pull-to-refresh-layer">
            <div class="preloader"></div>
            <div class="pull-to-refresh-arrow"></div>
        </div>
        <!--正文内容-->
        <!--需求-->
        <div class="jy-list">
        <!--这里插入数据-->
        </div>
        <!-- 加载提示符 -->
        <div class="infinite-scroll-preloader">
            <div class="preloader"></div>
        </div>
    </div>
    <div id="send_jy">
        <a class="button button-link button-fill" href="/wechat/send_jy">
            <p>发布及应(好丑)</p>
        </a>
    </div>
</div>
</div>
<!-- popup, panel 等放在这里 -->
<#include "common/panel.ftl">
</body>
<#include "common/js.ftl">
</html>