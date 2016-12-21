<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
    <title>及应</title>
</head>

<body>
<div class="page" id="page-jy-chat">
    <header class="bar bar-nav">
        <a class="button button-link button-nav pull-left back">
            <span class="icon icon-left"></span>返回
        </a>
        <h1 class='title'>阿莉</h1>
    </header>
    <div class="content">
        <div class="content-block">
            <div class="chat__messages">
                <div class="chat__msgRow">
                    <div class="chat__message mine">我在XXX大街，马上过去接你</div>
                </div>
                <div class="chat__msgRow">
                    <div class="chat__message notMine">好</div>
                </div>
                <div class="chat__msgRow">
                    <div class="chat__message mine">等下电话联系</div>
                </div>
            </div>
        </div>
    </div>
    <div type="text" class="chat__input">
        <input id="text" type="text">
        <img id="photo" src="/images/photo.png" alt="照片">
    </div>

</div>

</body>
<#include "common/js.ftl">
</html>