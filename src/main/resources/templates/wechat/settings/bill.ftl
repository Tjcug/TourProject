<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "../common/head.ftl">
</head>

<body>
<div class="page" id="page-bill">
    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="button button-link button-nav pull-left back">
            <span class="icon icon-left"></span> 返回
        </a>
        <h1 class="title">账单</h1>
    </header>
    <div class="content infinite-scroll">
        <div class="content-block">
            <div class="buttons-row">
                <a href="#tab1" id="tab-link1" class="tab-link active button">支出</a>
                <a href="#tab2" id="tab-link2" class="tab-link button">收入</a>
            </div>
        </div>
        <div class="tabs">
            <#--支出-->
            <div id="tab1" class="tab active">
                <div class="content-block list-bill">
                <!--这里插入数据-->
                </div>
                <div class="infinite-scroll-preloader">
                    <div class="preloader"></div>
                </div>
            </div>
            <#--收入-->
            <div id="tab2" class="tab">
                <div class="content-block list-bill">
                <!--这里插入数据-->
                </div>
                <div class="infinite-scroll-preloader">
                    <div class="preloader"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<#include "../common/js.ftl">
</html>
