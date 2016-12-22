<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
</head>

<body>

<div class="page" id="page-jy-reply">
    <link rel="stylesheet" href="/css/weui.min.css"/>
    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="button button-link button-nav pull-left back">
            <span class="icon icon-left"></span>返回
        </a>
        <h1 class="title">正在解答...</h1>
    </header>

    <div class="content">
        <!--查看照片gallery-->
        <div class="weui-gallery" id="gallery">
            <span class="weui-gallery__img" id="galleryImg"></span>
            <div class="weui-gallery__opr">
            </div>
        </div>
        <div class="content-block-title">求助信息</div>
        <div class="card facebook-card">
            <div class="card-header no-border">
                <div class="facebook-avatar">
                    <img class="img-head" src="/images/1.jpg" width="34" height="34">
                </div>
                <div class="facebook-name">${userName!''}</div>
                <div class="facebook-date">${place!'地点隐藏'}  ${creatTime!''}</div>
            </div>
            <div class="card-content">
                <div class="card-content-inner">
                    <div class="weui-grids">


                    </div>
                    <p class="color-gray">${reward!''}</p>
                    <p>${content!''}</p>
                </div>
            </div>
        </div>
        <div class="content-block-title">求助者信息</div>
        <div class="list-block">
            <ul>
                <li class="item-content">
                    <div class="item-inner">
                        <div class="item-title">名称</div>
                        <div class="item-after">${userName!''}</div>
                    </div>
                </li>
                <li><a class="item-content item-link external" href="tel:15607113057">
                    <div class="item-inner">
                        <div class="item-title">电话解答</div>
                        <div class="item-after">${phone!''}</div>
                    </div>
                </a></li>
                <li><a class="item-content item-link" href="/wechat/jy_chat">
                    <div class="item-inner">
                        <div class="item-title">图文解答</div>
                    </div>
                </a></li>
            </ul>
        </div>
        <p><a href="javascript:history.back()" class="button button-big button-fill">放弃解答</a></p>
    </div>
</div>
</body>
<#include "common/js.ftl">
</html>
