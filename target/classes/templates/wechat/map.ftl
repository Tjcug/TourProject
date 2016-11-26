<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
    <title>及应</title>
    <script type="text/javascript"src="http://webapi.amap.com/maps?v=1.3&key=4105f2985be4cb5b193685f37cec139e"></script>
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
            <div id="mapContainer">
            </div>
        </div>
    </div>
</div>
<!-- popup, panel 等放在这里 -->
<<#include "common/panel.ftl">

<script type="text/javascript">
    //初始化地图对象，加载地图
    var map = new AMap.Map("mapContainer", {
        resizeEnable: true,
        zoom: 13
    });
    var lnglats=[
        [116.368904,39.923423],
        [116.382122,39.921176],
        [116.387271,39.922501],
        [116.398258,39.914600]
    ];
    var infoWindow = new AMap.InfoWindow({offset:new AMap.Pixel(0,-30)});
    for(var i= 0,marker;i<lnglats.length;i++){
        var marker=new AMap.Marker({
            position:lnglats[i],
            map:map
        });
        marker.content='我是第'+(i+1)+'个Marker';
        marker.on('click',markerClick);
        marker.emit('click',{target:marker});
    }
    function markerClick(e){
        infoWindow.setContent(e.target.content);
        infoWindow.open(map, e.target.getPosition());
    }
    map.setFitView();

    setTimeout(function(){
        if ($("#mapContainer").height() == 0)
            map.setFitView();
    },3000);
</script>

</body>
</html>