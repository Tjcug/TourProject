<!DOCTYPE html>
<html>
<head>

    <title>Travel旅游助手</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <!--weui-->
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.0.2/weui.min.css"/>
    <script type="text/javascript" src="/static/js/weuizepto.min.js"></script>

    <!--必须放在weuizepto.js后面-->
<#include "common/base.ftl">

</head>
<body>

<div class="page-gourp">
    <div class="page">
        <#--<!-- 工具栏 &ndash;&gt;
        <nav class="bar bar-tab">
            <a class="tab-item external" href="/wechat/resolve">
                <span class="icon icon-home"></span>
                <span class="tab-label">解答</span>
            </a>
            <a class="tab-item external active" href="#">
                <span class="icon icon-edit"></span>
                <span class="tab-label">求助</span>
            </a>
            <a class="tab-item external" href="/wechat/settings">
                <i class="icon icon-set"></i>
                <span class="tab-label">设置</span>
            </a>
        </nav>-->

        <#--<!-- 标题栏 &ndash;&gt;
        <header class="bar bar-nav">
            <a class="icon icon-me pull-left open-panel"></a>
            <h1 class="title">Travel</h1>
        </header>-->

        <div class="content">
            <!--查看照片gallery-->
            <div class="weui-gallery" id="gallery">
                <span class="weui-gallery__img" id="galleryImg"></span>
                <div class="weui-gallery__opr">
                    <!--删除照片-->
                    <a href="javascript:" id="galleryDel" class="weui-gallery__del"><i
                            class="weui-icon-delete weui-icon_gallery-delete"> </i></a>
                </div>
            </div>
            <form id="form">
                <!--编辑求职内容-->
                <div class="list-block">
                    <ul>
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
                <a href="" id="submit"
                   class="button button-big button-fill button-success">提交</a>
            </div>
        </div>
        <!--BEGIN dialog-->
        <div class="js_dialog" id="dialog" style="display: none;">
            <div class="weui-mask"></div>
            <div class="weui-dialog">
                <div class="weui-dialog__bd">提交成功</div>
                <div class="weui-dialog__ft">
                    <a href="#" class="weui-dialog__btn weui-dialog__btn_primary">确定</a>
                </div>
            </div>
        </div>
        <!--END dialog-->
        <!-- tipToast toast -->
        <div class="js_dialog" id="tipDialog" style="display: none;">
            <div class="weui-mask">
            </div>
            <div class="weui-dialog">
                <div class="weui-dialog__bd">
                    请输入完整信息！
                </div>
                <div class="weui-dialog__ft">
                    <a href="" class="weui-dialog__btn weui-dialog__btn_primary" id="tipOk">确定</a>
                </div>
            </div>
        </div>
        <!--END tipToast toast-->
    </div>
</div>


<!-- popup, panel 等放在这里 -->
<<#include "common/panel.ftl">

<script type="text/javascript">
    //上传照片
    $(function () {
        'use strict';

        var $gallery = $("#gallery");
        var $galleryImg = $("#galleryImg");
        var $uploaderInput = $("#uploaderInput");
        var $uploaderFiles = $("#uploaderFiles");
        var $galleryDel = $("#galleryDel");
        //当前点击的图片的id（gallery显示的图片）
        var currentImage = 0;
        //目前图片总数
        var countImage = 0;
        //图片最大数
        var maxImage = 9;
        //用于储存照片的数组
        var filesArray = [];

        $(".weui-uploader__info").html(countImage + "/" + maxImage);

        $uploaderInput.on("change", function (e) {

            var src, url = window.URL || window.webkitURL || window.mozURL;
            var files = e.target.files;
            var len = files.length;
            if (countImage + len > maxImage) {
                alert("最多只能选择" + maxImage + "张图片");
                return;
            }
            for (var i = 0; i < len; ++i) {
                var tmpl = '<li class="weui-uploader__file" id="image' + countImage + '" style="background-image:url(#url#)"></li>';
                var file = files[i];
                //把图片存在filesArray中（因为FileList为只读类型不可操作）
                filesArray[countImage++] = files[i];
                if (url) {
                    src = url.createObjectURL(file);
                } else {
                    src = e.target.result;
                }

                $uploaderFiles.append($(tmpl.replace('#url#', src)));
            }
            //修改选择图片时在网页显示的数字
            $(".weui-uploader__info").html(countImage + "/" + maxImage);
        });
        //点击图片时，进入gallery显示图片
        $uploaderFiles.on("click", "li", function () {
            $galleryImg.attr("style", this.getAttribute("style"));
            $gallery.fadeIn(100);
            //获取点击图片的id
            currentImage = $(this).attr("id")[5];
        });
        //点击gallery时返回选择图片界面
        $gallery.on("click", function () {
            $gallery.fadeOut(100);
        });
        //删除选择图片
        $galleryDel.on("click", function () {
            $gallery.fadeOut(100);
            //把第imageCurrent个图片从选择界面中删除
            $("#image" + currentImage).remove();
            //把第currentImage个图片从files中删除
            filesArray.splice(currentImage, 1);
            //图片总数减一
            countImage--;
            //把之后的图片id都减1
            for (var i = 1 + parseInt(currentImage); i <= countImage; i++) {
                $("#image" + i).attr("id", "image" + (i - 1));
            }
            $(".weui-uploader__info").html(countImage + "/" + maxImage);
        });

        //提交
        $("#showDialog").on("click", function () {
            if ($("#title").val() !== "" && $("#content").val() !== "") {
                $("#dialog").fadeIn(200);
            } else {
                $("#tipDialog").fadeIn(100);
            }
        });
        //取消提交
        $("#cancel").on("click", function () {
            $("#dialog").fadeOut(200);
        });
        $("#tipOk").on("click", function () {
            $("#tipDialog").fadeOut(100);
        });


        //确认提交
        $("#submit").on("click", function () {

            $("#dialog").fadeOut(0);
            $("#loadingToast").fadeIn(0);
            $("#loadingToastText").html("正在提交");
            setTimeout(function () {
                //构建FormData对象
                var fd = new FormData($('#form')[0]);
                for (var i = 0, j = filesArray.length; i < j; ++i) {
                    fd.append("images", filesArray[i]);
                }
                //由于FileList是只读属性无法修改，所以需要把自定义的filesArray传到后台，不能用form提交，需要用ajax
                /*                $.ajax({
                                    url: "InteractHuiUpload",
                                    type: "POST",
                                    data: fd,
                                    processData: false, // 告诉jQuery不要去处理发送的数据
                                    contentType: false, // 告诉jQuery不要去设置Content-Type请求头
                                    async: false,
                                    success: function (data) {
                                        if (data === "True") {
                                            $("#loadingToastIcon").attr("class", "weui-icon-success-no-circle weui-icon_toast");
                                            $("#loadingToastText").html("提交成功");
                                            setTimeout(function () {
                                                $("#loadingToast").fadeOut(100);
                                                window.location.href = "InteractShykInputList";
                                            }, 1000);
                                        }
                                        else {
                                            $("#loadingToastText").html("请登录后再提交");
                                            setTimeout(function () {
                                                $("#loadingToast").fadeOut(100);
                                            }, 1000);
                                        }
                                    },
                                    error: function () {
                                        $("#loadingToastText").html("提交失败");
                                        setTimeout(function () {
                                            $("#loadingToast").fadeOut(100);
                                        }, 1000);
                                    }

                                });*/
            }, 500);

        });
    });
</script>

</body>
</html>
