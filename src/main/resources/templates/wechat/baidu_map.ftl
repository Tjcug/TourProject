<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
    <title>及应</title>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=h5XieFGFVjZ8HhUaF2bipXZduW0wKMT8"></script>
</head>

<body>
<div class="page-group">
    <div class="page" id="page-map">

        <!-- 标题栏 -->
        <header class="bar bar-nav">
            <a class="icon icon-me pull-left open-panel"></a>
            <a class="button button-link button-nav pull-right">
                列表
            </a>
            <h1 class="title">及应</h1>
        </header>
        <div class="content">
            <div id="allmap"></div>
            <p>点击标注点，可查看由纯文本构成的简单型信息窗口</p>
        </div>
    </div>
</div>
<!-- popup, panel 等放在这里 -->
<<#include "common/panel.ftl">

<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.417854,39.921988);
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);              // 将标注添加到地图中
    map.centerAndZoom(point, 15);
    var opts = {
        width : 200,     // 信息窗口宽度
        height: 100,     // 信息窗口高度
        title : "海底捞王府井店" , // 信息窗口标题
        enableMessage:true,//设置允许信息窗发送短息
        message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
    }
    var infoWindow = new BMap.InfoWindow("地址：北京市东城区王府井大街88号乐天银泰百货八层", opts);  // 创建信息窗口对象
    marker.addEventListener("click", function(){
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    });
</script>


</body>
</html>