/**
 * Created by panpan on 2016/11/9.
 */

$(function () {
    "use strict";

    //注册页的page
    $(document).on("pageInit", "#page-register", function () {

        var $getCheckNum = $('#getCheckNum');
        var countdown = 60;
        //是否能获取验证码
        var getCheckNumState = true;

        function settime() {
            if (countdown == 0) {
                $getCheckNum.html("获取验证码");
                countdown = 60;
                getCheckNumState = true;
                return;
            } else {
                $getCheckNum.html("重新发送(" + countdown + ")");
                countdown--;
                getCheckNumState = false;
            }
            setTimeout(function () {
                settime();
            }, 1000)
        }

        $getCheckNum.on('click', function () {
            if(!getCheckNumState)
                return;
            var telephoneNumber = $('#telephoneNumber').val();
            if (telephoneNumber == "") {
                $.toast("请输入正确的手机号！");
                return;
            }
            $.ajax({
                url: "/tuser/getCheckNum/" + telephoneNumber + "/register",
                type: "get",
                data: "json",
                success: function (data) {
                    var result = eval(data);
                    if (result.success == true){
                        //倒计时
                        settime();
                    }
                    else {
                        $.toast(result.errorMsg);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        });

        //登录按钮
        $('#login').on('click', function () {
            $.ajax({
                    url: "/tuser/registerUserByCheckNum",
                    type: "post",
                    data: $('#form').serialize(),
                    async:false,
                    success: function (data) {
                        var result = eval(data);
                        if (result.success == true)
                            $.router.loadPage("/wechat/index");
                        else
                            $.toast(result.errorMsg);
                    }
                }
            )
        });
    });

//在主页的page（及应列表）
    $(document).on("pageInit", "#page-jy", function () {

        var maxItems = 5;
        $.ajax({
            url: "/tjiying/getJyQuestionsCount",
            data: JSON,
            async: false,
            success: function (data) {
                // 最多可加载的及应数量
                maxItems = data;
                if(data == 0)
                    $.toast("加载失败!");
            },
            error:function (data) {
                $.toast("加载失败!");
            }
        });

        //是否正在加载
        var loading = false;
        // 每次加载添加多少条及应
        var itemsPerLoad = 3;
        //第一次加载的数量
        var firstItems = 5;
        //上次加载的数量
        var lastIndex = $(".card").length;
        // 判断是否停止加载事件
        var lastID = 0;
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

        //添加新的及应,type为true则覆盖原数据，false则在原数据添加新数据
        function addItems(tempLastIndex, itemsPerLoad, type) {
            var html = '';
            $.ajax({
                url: "/tjiying/getJyQuestions?lastID="+lastID+"&count="+itemsPerLoad,
                type: "POST",
                data: JSON,
                async: false,
                success: function (data) {
                    var result = eval(data);
                    if (result.return == "success") {
                        var rows = result.data;
                        for (var i = 0; i < rows.length; i++) {
                            //在这里插入数据(悬赏金额、内容、时间等等),用ajax更新，更新一次取出少量数据
                            html += '<div class="card facebook-card"><div class="card-header no-border"><div class="facebook-avatar">';
                            //判断用户是否有头像，没有则使用默认头像
                            if(rows[i].headImage != null)
                                html += '<img class="img-head" src="' + rows[i].headImage + '" width="34" height="34">';
                            else
                                html += '<img class="img-head" src="/images/1.jpg" width="34" height="34">';
                            html += '</div><div class="facebook-name">' + rows[i].userName + '</div><div class="facebook-date">' +
                                rows[i].place + " " + rows[i].creatTime + '</div></div><div class="card-content img-padded">';
                            //判断及应是否有图片
                            if(rows[i].imagePack != null)
                                html += '<img src="' + rows[i].imagePack + '" width="100%"></div>';
                            else
                                html += '<img src="/images/1.jpg" width="100%"></div>';
                            html += '<div class="card-content"><div class="card-content-inner">' +
                                '<p class="color-gray">悬赏'+ rows[i].reward+ '</p><p>' +  rows[i].content +
                                '</p></div></div><div class="card-footer no-border"><a href="/wechat/jy_reply" class="link confirm-ok">' +
                                '解答</a> <a href="/wechat/jy_detail" class="link">更多</a></div></div>';
                        }
                        //标记最后一个及应的id
                        lastID = rows[rows.length-1].id;
                        // 添加新条目
                        if (type)
                            $(".jy-list").html(html);
                        else
                            $(".jy-list").append(html);
                        lastIndex = $(".card").length;
                        if (del()) {
                            $.toast("加载完毕！");
                        }
                    }
                    else {
                        del();
                        $.toast("加载完毕！");
                    }
                }
            });
        }

        //向下滚动时调用
        $(document).on("infinite", ".infinite-scroll", function () {
            // 如果正在加载，则退出
            if (loading) return;
            // 如果停止加载则退出
            if (del()) return;
            // 设置flag
            loading = true;
            //更新前最后加载符号
            lastIndex = $(".card").length;
            setTimeout(function () {
                addItems(lastIndex, itemsPerLoad, false);
                loading = false;
            }, 500);
        });

        //下拉刷新时调用
        $(document).on("refresh", ".pull-to-refresh-content", function () {
            setTimeout(function () {
                lastID = 0;
                addItems(0, firstItems, true);
                $.pullToRefreshDone(".pull-to-refresh-content");
            }, 500);
        });
        //预先加载5条
        addItems(0, firstItems, true);
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

//及应详细page
    $(document).on("pageInit", "#page-jy-detail", function () {
        //图片高度自适应
        var $img = $('.img');
        $img.css('height', $img.css('width'));
        var $gallery = $("#gallery");
        //点击图片时，进入gallery显示图片
        $img.on("click", function () {
            $("#galleryImg").attr("style", "background-image:url(" + this.getAttribute("src") + ")");
            $gallery.fadeIn(100);
        });
        //点击gallery时返回选择图片界面
        $gallery.on("click", function () {
            $gallery.fadeOut(100);
        });
    });

//及应解答page
    $(document).on("pageInit", "#page-jy-reply", function () {
        //图片高度自适应
        var $img = $('.img');
        $img.css('height', $img.css('width'));
    });

//及应等待解答page
    $(document).on("pageInit", "#page-jy-wait", function () {
        //图片高度自适应
        var $img = $('.img');
        $img.css('height', $img.css('width'));
    });


//我的账单page
    $(document).on("pageInit", "#page-bill", function (e, id, page) {

        // 每次加载添加多少条账单
        var itemsPerLoad = 5;
        // 最多可加载的账单数量
        var maxItems = 30;
        //tab页数
        var tab = "1";
        //上次加载的数量
        var lastIndex = $("#tab" + tab).find(".card").length;


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

        $('#tab-link1').on('click', function () {
            tab = "1";
        });
        $('#tab-link2').on('click', function () {
            tab = "2";
        });


        //添加新的及应,tab为当前tab数
        function addItems(itemsPerLoad, tab) {
            var html = '';
            for (var i = lastIndex + 1; i <= lastIndex + itemsPerLoad; i++) {
                //在这里插入数据(悬赏金额、内容、时间等等),最好用ajax更新，更新一次取出少量数据
                html += '<div class="card"><div class="card-header"><div class="item-title">';
                if (tab == 1) {
                    html += '支出'
                }
                else {
                    html += '收入'
                }
                html += '</div><div class="item-after">5$</div></div><div class="card-content">' +
                    '<div class="list-block media-list"><ul><li class="item-content"><div class="item-inner">' +
                    '<div class="item-title-row"><div class="item-title">潘俊冰</div></div>' +
                    '<div class="item-subtitle">迷路了，求接送回凯宁宾馆（ACX大街666号）</div></div></li></ul></div></div>' +
                    '<div class="card-footer"><span>2015/01/15</span> <a href="/wechat/settings/bill_detail">' +
                    '查看更多信息</a></div></div>';
            }
            // 添加新条目
            var $tab = $('#tab' + tab);
            $tab.find(".list-bill").append(html);
            lastIndex = $tab.find(".card").length;
            if (del()) {
                $.toast("加载完毕！");
            }
        }

        //滚动事件
        $(document).on("infinite", ".infinite-scroll", function () {
            // 1s timeout
            var $this = $(this);
            if ($this.data("loading")) return;
            if (del())return;
            $this.data("loading", 1);
            setTimeout(function () {
                addItems(itemsPerLoad, tab);
                $this.data("loading", 0);
            }, 1000);
        });

        //初始化时给每个tab加载10条
        addItems(10, "1");
        addItems(10, "2");
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
})
;