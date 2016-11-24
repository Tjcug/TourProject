<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "../common/head.ftl">
</head>
<body>

<div class="page">
    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="button button-link button-nav pull-left back">
            <span class="icon icon-left"></span> 返回
        </a>
        <h1 class="title">设置</h1>
    </header>
    <div class="content">
        <div class="list-block">
            <ul>
                <li><a class="item-content item-link" href="/wechat/settings/user">
                    <div class="item-inner">
                        <div class="item-after">账号管理</div>
                    </div>
                </a></li>
            </ul>
        </div>
        <div class="list-block">
            <ul>
                <li><a class="item-content item-link" href="/wechat/settings/language">
                    <div class="item-inner">
                        <div class="item-after">语言选择</div>
                    </div>
                </a></li>
            </ul>
        </div>
        <div class="list-block">
            <ul>
                <li><a class="item-content item-link" href="/wechat/settings/suggestion">
                    <div class="item-inner">
                        <div class="item-after">意见反馈</div>
                    </div>
                </a></li>
            </ul>
        </div>
        <p>
            <a href="#" id="exit" class="button button-fill button-danger">退出登录</a>
        </p>
    </div>
</div>
<!-- popup, panel 等放在这里 -->
<<#include "../common/panel.ftl">
</body>
<#include "../common/js.ftl">
</html>
