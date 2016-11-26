/**
 * Created by panpan on 2016/11/9.
 */

$(function () {
    "use strict";

    //在主页的page（及应列表）
    $(document).on("pageInit", "#page-jy", function () {
        //是否正在加载
        var loading = false;
        // 每次加载添加多少条及应
        var itemsPerLoad = 2;
        // 最多可加载的及应数量
        var maxItems = 20;
        //上次加载的数量
        var lastIndex = $(".card").length;
        // 判断是否停止加载事件
        function del() {
            if (lastIndex >= maxItems) {
                // 加载完毕，则注销无限加载事件，以防不必要的加载
                //$.detachInfiniteScroll($('#infinite-scroll'));
                //隐藏加载提示符
                $('.infinite-scroll-preloader').hide();
                return true;
            }
            else {
                $('.infinite-scroll-preloader').show();
            }
            return false;
        }

        //添加新的及应
        function addItems(itemsPerLoad) {
            var html = '';
            for (var i = lastIndex + 1; i <= lastIndex + itemsPerLoad; i++) {
                //在这里插入数据(悬赏金额、内容、时间等等),最好用ajax更新，更新一次取出少量数据
                html += '<div class="card facebook-card"><div class="card-header no-border"><div class="facebook-avatar">' +
                    '<img class="img-head" src="/images/' + i + '.jpg" width="34" height="34"></div><div class="facebook-name">食长' +
                    '</div><div class="facebook-date">纽约ABC大街111号 1月15日 15:47</div></div><div class="card-content img-padded">' +
                    '<img src="/images/' + i + '.jpg" width="100%"></div><div class="card-content"><div class="card-content-inner">' +
                    '<p class="color-gray">悬赏20$</p><p>迷路了，求接送回凯宁宾馆（ACX大街666号）' +
                    '</p></div></div><div class="card-footer no-border"><a href="#" class="link confirm-ok">' +
                    '解答</a> <a href="/wechat/jy_detail" class="link">更多</a></div></div>';
            }
            // 添加新条目
            $(".jy-list").append(html);
            lastIndex = $(".card").length;
            if (del()) {
                $.toast("加载完毕！");
            }
        }

        //刷新及应列表
        function refreshItems(itemsPerLoad) {
            var html = '';
            for (var i = lastIndex + 1; i <= lastIndex + itemsPerLoad; i++) {
                html += '<div class="card facebook-card"><div class="card-header no-border"><div class="facebook-avatar">' +
                    '<img class="img-head" src="/images/' + i + '.jpg" width="34" height="34"></div><div class="facebook-name">食长' +
                    '</div><div class="facebook-date">纽约ABC大街111号 1月15日 15:47</div></div><div class="card-content img-padded">' +
                    '<img src="/images/' + i + '.jpg"></div><div class="card-content"><div class="card-content-inner">' +
                    '<p class="color-gray">悬赏20$</p><p>迷路了，求接送回凯宁宾馆（ACX大街666号）' +
                    '</p></div></div><div class="card-footer no-border"><a href="#" class="link confirm-ok">' +
                    '解答</a> <a href="/wechat/jy_detail" class="link">更多</a></div></div>';
            }
            // 添加新条目
            $(".jy-list").html(html);
            lastIndex = $(".card").length;
            del();
        }

        //向下滚动时调用
        $(document).on("infinite",".infinite-scroll", function () {
            // 如果正在加载，则退出
            if (loading) return;
            // 如果停止加载则退出
            if (del()) return;
            // 设置flag
            loading = true;
            //更新前最后加载符号
            lastIndex = $(".card").length;
            addItems(itemsPerLoad);
            setTimeout(function () {
                addItems();
                loading = false;
            }, 1000);
        });

        //下拉刷新时调用
        $(document).on("refresh", ".pull-to-refresh-content", function () {
            setTimeout(function () {
                refreshItems(5);
                $.pullToRefreshDone(".pull-to-refresh-content");
            }, 1000);
        });
        //预先加载5条
        addItems(5);
    });


    //发送及应page
    $(document).on("pageInit", "#page-send-jy", function () {
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
        //显示已上传照片数量
        $(".weui-uploader__info").html(countImage + "/" + maxImage);
        //上传照片操作
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
        $("#submit").on("click", function () {
            $.confirm('确认提交么?', function () {
                $.showPreloader("正在上传");
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
                 if (data) {
                 $.toast("发布成功");
                 setTimeout(function () {
                 history.back();
                 $.hidePreloader();
                 }, 500);
                 }
                 else {
                 $.toast("上传失败");
                 }
                 }
                 else {
                 $("#loadingToastText").html("请登录后再提交");
                 setTimeout(function () {
                 $("#loadingToast").fadeOut(100);
                 }, 1000);
                 }
                 },
                 error: function () {
                 $.toast("上传失败");
                 }

                 });*/
            });
        });
    });

    //我的账单page
    $(document).on("pageInit", "#page-bill", function () {
        //$.closePanel();
    });

    //使用说明page
    $(document).on("pageInit", "#page-explain", function () {
    });

    //选择语言page
    $(document).on("pageInit", "#page-language", function () {
    });

    //分享我们page
    $(document).on("pageInit", "#page-share", function () {
    });

    //关于我们page
    $(document).on("pageInit", "#page-about", function () {
    });

    $.init();
});