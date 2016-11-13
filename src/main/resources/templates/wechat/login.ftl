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
            <form action="" type="POST">
                <ul class="list-block">
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-input">
                                    <input type="text" placeholder="请输入手机号/邮箱/账号" name="user">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-input">
                                    <input type="password" placeholder="请输入密码" name="password">
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </form>
            <div class="content-block">
                <a href="/wechat/index" class="button button-fill button-success open-indicator">提交</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
