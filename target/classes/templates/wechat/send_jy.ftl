<!DOCTYPE html>
<html>
<head>
    <!--weui-->
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.0.2/weui.min.css"/>
<#include "common/head.ftl">

</head>
<body>
<div class="page" id="page-send-jy">
    <!-- 标题栏 -->
    <header class="bar bar-nav">
        <a class="button button-link button-nav pull-left back">
            <span class="icon icon-left"></span> 查看及应
        </a>
        <h1 class="title">发布及应</h1>
    </header>

    <div class="content">
        <!--查看照片gallery-->
        <div class="weui-gallery" id="gallery">
            <span class="weui-gallery__img" id="galleryImg"></span>
            <div class="weui-gallery__opr">
                <!--删除照片-->
                <a href="javascript:" id="galleryDel" class="weui-gallery__del">
                    <i class="weui-icon-delete weui-icon_gallery-delete"></i>
                </a>
            </div>
        </div>
        <form id="form">
            <!--编辑求职内容-->
            <div class="list-block">
                <ul>
                    <!--求助内容-->
                    <li class="align-top">
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-input">
                                    <textarea name="content" placeholder="请输入求助内容"></textarea>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--悬赏金额 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-input">
                                    <input type="text" name="money" placeholder="请输入悬赏金额($)">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li><a href="#" class="item-link item-content">
                        <div class="item-inner">
                            <div class="item-title">选择定位</div>
                            <div class="item-aftre" name="location">
                                ABC大街256号
                            </div>
                        </div>
                    </a></li>
                </ul>
            </div>
            <!--照片上传-->
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <div class="weui-uploader">
                            <div class="weui-uploader__hd">
                                <p class="weui-uploader__title">图片上传</p>
                                <div class="weui-uploader__info">0/9</div>
                            </div>
                            <div class="weui-uploader__bd">
                                <ul class="weui-uploader__files" id="uploaderFiles">
                                    <!--插入照片的位置-->
                                </ul>
                                <div class="weui-uploader__input-box">
                                    <input id="uploaderInput" class="weui-uploader__input"
                                           type="file" accept="image/*" multiple/>
                                    <!--accept可以限制选择照片类型-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="content-block">
            <a href="" id="submit" class="button button-fill button-success">提交</a>
        </div>
    </div>
</div>
<!-- popup, panel 等放在这里 -->
<<#include "common/panel.ftl">
</body>
<#include "common/js.ftl">
</html>
