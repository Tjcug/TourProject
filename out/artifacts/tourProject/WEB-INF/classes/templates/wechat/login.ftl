<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
</head>

<body>
<div class="page">
    <style type="text/css">
        .weui-agree{
            float: left;
        }
    </style>
    <!--weui-->
    <link rel="stylesheet" href="/css/weui.min.css"/>
    <div class="content">
        <div class="list-block inset text-center">
            <h3>及应</h3>
            <div class="weui-cells">
                <div class="weui-cell weui-cell_vcode">
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入手机号">
                    </div>
                    <div class="weui-cell__ft">
                        <button class="weui-vcode-btn">获取验证码</button>
                    </div>
                </div>
                <div class="weui-cell weui-cell_vcode">
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入验证码"/>
                    </div>
                </div>
            </div>
            <label for="weuiAgree" class="weui-agree" style="padding-left: 0">
                <input id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
                <span class="weui-agree__text">
                阅读并同意<a href="">《相关条款》</a>
            </span>
            </label>
        </div>
        <div class="content-block">
            <p><a class="button button-big button-fill" href="/wechat/index">登录</a></p>
        </div>
    </div>
</body>
<#include "common/js.ftl">
</html>
