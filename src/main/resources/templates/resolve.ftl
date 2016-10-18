<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/base.ftl">

    <style type="text/css">
        .infinite-scroll-preloader {
            margin-top: -20px;
        }
    </style>

</head>

<body>
<div class="page-group">
    <div class="page">
        <!-- 工具栏 -->
        <nav class="bar bar-tab">
            <a class="tab-item external active" href="#">
                <span class="icon icon-home"></span>
                <span class="tab-label">解答</span>
            </a>
            <a class="tab-item external" href="index.ftl" external>
                <span class="icon icon-edit"></span>
                <span class="tab-label">求助</span>
            </a>
            <a class="tab-item external" href="settings.ftl" external>
                <span class="icon icon-settings"></span>
                <span class="tab-label">设置</span>
            </a>
        </nav>

        <!-- 标题栏 -->
        <header class="bar bar-nav">
            <a class="icon icon-me pull-left open-panel"></a>
            <h1 class="title">Travel</h1>
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
            <div class="list-block cards-list">
                <ul class="list-container">
                    <!--在这里插入内容（下拉刷新和上拉滚动）-->
                </ul>
            </div>
            <!-- 加载提示符 -->
            <div class="infinite-scroll-preloader">
                <div class="preloader"></div>
            </div>
        </div>
    </div>
</div>
<!-- popup, panel 等放在这里 -->
<<#include "common/panel.ftl">

<script type="text/javascript">
    $(function () {
        'use strict';

        //在page初始化时调用
        $(document).on("pageInit", "#page-resolve", function (e, id, page) {
            //无限滚动
            //是否正在加载
            var loading = false;
            // 每次加载添加多少条目
            var itemsPerLoad = 2;
            // 最多可加载的条目
            var maxItems = 20;
            var lastIndex = $('.list-container li').length;

            function addItems(number, lastIndex) {
                // 生成新条目的HTML
                var html = '';
                for (var i = lastIndex + 1; i <= lastIndex + number; i++) {

                    //在这里插入数据(悬赏金额、内容、时间等等),最好用ajax更新，更新一次取出少量数据
                    html += '<li class="card facebook-card"><div class="card-header no-border"><div class="facebook-avatar"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"	width="34" height="34"></div><div class="facebook-name">食长</div><div class="facebook-date">纽约ABC大街111号 1月15日 15:47</div></div><div class="card-content"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"	width="100%"></div><div class="card-content"><div class="card-content-inner"><p class="color-gray">悬赏20$</p><p>迷路了，求接送回凯宁宾馆（ACX大街666号）</p></div></div><div class="card-footer no-border"><a href="#" class="link confirm-ok">解答</a> <a href="#"class="link">更多</a></div></li>';
                }
                // 添加新条目
                $('.infinite-scroll .list-container').append(html);
            }

            //预先加载3条
            addItems(3, 0);

            //向下滚动时调用
            $(page).on('infinite', function () {
                // 如果正在加载，则退出
                if (loading)return;
                // 设置flag
                loading = true;
                // 模拟1s的加载过程
                setTimeout(function () {
                    // 重置加载flag
                    loading = false;
                    if (lastIndex >= maxItems) {
                        // 加载完毕，则注销无限加载事件，以防不必要的加载
                        $.detachInfiniteScroll($('.infinite-scroll'));
                        // 删除加载提示符
                        $('.infinite-scroll-preloader').remove();
                        return;
                    }
                    addItems(itemsPerLoad, lastIndex);
                    // 更新最后加载的序号
                    lastIndex = $('.list-container li').length;
                    $.refreshScroller();
                }, 1000);
            });

            //下拉刷新
            var $content = $(page).find(".content").on('refresh', function (e) {
                // 模拟2s的加载过程
                setTimeout(function () {
                    //从这里添加数据
                    var html = '<li class="card facebook-card"><div class="card-header no-border"><div class="facebook-avatar"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"	width="34" height="34"></div><div class="facebook-name">下拉刷新添加的数据</div><div class="facebook-date">纽约ABC大街111号 1月15日 15:47</div></div><div class="card-content"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"	width="100%"></div><div class="card-content"><div class="card-content-inner"><p class="color-gray">悬赏20$</p><p>迷路了，求接送回凯宁宾馆（ACX大街666号）</p></div></div><div class="card-footer no-border"><a href="#" class="link confirm-ok">解答</a> <a href="#"class="link">更多</a></div></li>';
                    $content.find('.list-container').prepend(html);
                    // $(window).scrollTop(0);
                    // 加载完毕需要重置
                    $.pullToRefreshDone($content);
                }, 2000);
            });
        });
        $.init();
    });
</script>
</body>
</html>
