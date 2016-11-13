<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>注册</title>
<#include "common/base.ftl">

</head>

<body>
<div class="page-group">
    <div class="page">
        <header class="bar bar-nav">
            <h1 class='title'>注册</h1>
        </header>
        <div class="content">
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">昵称</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" pattern="[0-9]*"
                               placeholder="请输入昵称"/>
                    </div>
                </div>
                <div class="weui-cell weui-cell_vcode">
                    <div class="weui-cell__hd">
                        <label class="weui-label">手机号</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number" placeholder="请输入手机号">
                    </div>
                    <div class="weui-cell__ft">
                        <a href="javascript:;" class="weui-vcode-btn">获取验证码</a>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">验证码</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number" placeholder="请输入验证码"/>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">密码</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" pattern="[0-9]*"
                               placeholder="请输入密码"/>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">确认</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" pattern="[0-9]*"
                               placeholder="请再次输入密码"/>
                    </div>
                </div>
            </div>
            <label for="weuiAgree" class="weui-agree"> <input
                    id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
                <span class="weui-agree__text"> 阅读并同意<a href="clause.jsp">《相关条款》</a>
			</span>
            </label>

            <div class="content-block">
                <a href="/wechat/index" class="button button-fill button-success open-indicator">提交</a>
            </div>
        </div>
    </div>
</div>


</body>
</html>
