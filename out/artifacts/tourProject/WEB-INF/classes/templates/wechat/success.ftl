<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
    <title>及应</title>
</head>

<body>
<div class="page">
    <!--weui-->
    <link rel="stylesheet" href="/css/weui.min.css"/>

    <div class="content">
        <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
        <div class="weui-msg__text-area">
            <h2 class="weui-msg__title">支付成功</h2>
        </div>
        <div class="content-block-title">评价服务</div>
        <div class="list-block">
            <ul>
                <li class="item-content">
                    <div class="item-inner">
                        <div class="item-title">解答人</div>
                        <div class="item-after">潘俊冰</div>
                    </div>
                </li>
                <li class="item-content">
                    <div class="item-inner">
                        <div class="item-title">评分</div>
                        <div class="item-after item-input">
                            <select>
                                <option>1分</option>
                                <option>2分</option>
                                <option>3分</option>
                                <option>4分</option>
                                <option>5分</option>
                            </select>
                        </div>
                    </div>
                </li>
                <li class="align-top">
                    <div class="item-content">
                        <div class="item-inner">
                            <div class="item-title">评价</div>
                            <div class="item-after item-input">
                                <textarea></textarea>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="content-block">
            <a href="/wechat/index" id="submit" class="button button-big button-fill button-success">提交</a>
            <a href="/wechat/setting/seggestion" class="button button-big button-fill">反馈</a>
        </div>
    </div>
</div>


</body>
<#include "common/js.ftl">
</html>