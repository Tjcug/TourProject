<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
    <title>及应</title>
</head>

<body>
<div class="page" id="page-payment">
    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="button button-link button-nav pull-left back">
            <span class="icon icon-left"></span>返回
        </a>
        <h1 class="title">正在支付...</h1>
    </header>

    <div class="content">
        <div class="content-block">
            <div class="content-block-title">支付信息：</div>
            <div class="list-block">
                <ul>
                    <li class="item-content">
                        <div class="item-inner">
                            <div class="item-title">支付金额</div>
                            <div class="item-after">5$</div>
                        </div>
                    </li>
                    <li class="item-content">
                        <div class="item-inner">
                            <div class="item-title">收款人</div>
                            <div class="item-after">食长</div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="content-block-title">支付方式：</div>
            <div class="list-block media-list">
                <ul>
                    <li>
                        <label class="label-checkbox item-content">
                            <input type="radio" name="my-radio">
                            <div class="item-media"><i class="icon icon-form-checkbox"></i></div>
                            <div class="item-inner">
                                <div class="item-subtitle">支付宝支付</div>
                            </div>
                        </label>
                    </li>
                    <li>
                        <label class="label-checkbox item-content">
                            <input type="radio" name="my-radio">
                            <div class="item-media"><i class="icon icon-form-checkbox"></i></div>
                            <div class="item-inner">
                                <div class="item-subtitle">微信支付</div>
                            </div>
                        </label>
                    </li>
                </ul>
            </div>
            <p><a href="/wechat/index" class="button button-big button-fill">确认支付</a></p>
        </div>
    </div>
</div>
</body>
<#include "common/js.ftl">
</html>