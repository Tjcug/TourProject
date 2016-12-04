<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
</head>

<body>
<div class="page" id="page-register">
    <style type="text/css">
        .weui-agree {
            float: left;
        }
    </style>
    <!--weui-->
    <link rel="stylesheet" href="/css/weui.min.css"/>
    <div class="content">
        <div class="list-block inset text-center">
            <h3>及应</h3>
            <form id="form" method="post">
                <div class="weui-cells">
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__bd">
                            <input id="telephoneNumber" name="telephoneNumber" class="weui-input" type="number"
                                   pattern="[0-9]*" placeholder="请输入手机号">
                        </div>
                        <div class="weui-cell__ft">
                            <a id="getCheckNum" class="weui-vcode-btn" external>获取验证码</a>
                        </div>
                    </div>
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__bd">
                            <input id="checknum" name="checknum" class="weui-input" type="number" pattern="[0-9]*"
                                   placeholder="请输入验证码"/>
                        </div>
                    </div>
                </div>
            </form>
            <label for="weuiAgree" class="weui-agree" style="padding-left: 0">
                <input id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
                <span class="weui-agree__text">
                阅读并同意<a href="">《相关条款》</a>
            </span>
            </label>
        </div>
        <div class="content-block">
            <p><a id="login" type="button" class="button button-big button-fill">登录</a></p>
        </div>
    </div>
</body>
<#include "common/js.ftl">
</html>
