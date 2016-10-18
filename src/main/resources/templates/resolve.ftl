
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/base.ftl">

<style type="text/css">
.infinite-scroll-preloader {
	margin-top: -20px;
}
</style>

<script type="text/javascript">
	//对话框
	$(document).on('click', '.confirm-ok', function() {
		$.confirm('确认解答这个问题么？', function() {
			window.location.href = "/answer";
		});
	});

	//无限滚动
	// 加载flag
	var loading = false;
	// 最多可加载的条目
	var maxItems = 10;

	// 每次加载添加多少条目
	var itemsPerLoad = 1;

	//一个卡片(数据在里面修改)
	var html = '<li class="card facebook-card"><div class="card-header no-border"><div class="facebook-avatar"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"width="34" height="34"></div><div class="facebook-name">食长</div><div class="facebook-date">纽约ABC大街111号 1月15日 15:47</div></div><div class="card-content"><img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"width="100%"></div><div class="card-content"><div class="card-content-inner"><p class="color-gray">悬赏20$</p><p>迷路了，求接送回凯宁宾馆（ACX大街666号）</p></div></div><div class="card-footer no-border"><a href="#" class="link confirm-ok">解答</a> <a href="#" class="link">更多</a></div></li>';


	function addItems(number, lastIndex) {
		// 生成新条目的HTML

		for (var i = lastIndex + 1; i <= lastIndex + number; i++) {
			html += card;
		}

		// 添加新条目
		$('.infinite-scroll-bottom .list-container').append(html);

	}

	//预先加载1条
	addItems(itemsPerLoad, 0);

	// 上次加载的序号

	var lastIndex = 1;

	// 注册'infinite'事件处理函数
	$(document).on('infinite', '.infinite-scroll-bottom', function() {

		$.toast("hey");
		// 如果正在加载，则退出
		if (loading)
			return;

		// 设置flag
		loading = true;

		// 模拟1s的加载过程
		setTimeout(function() {
			// 重置加载flag
			loading = false;

			if (lastIndex >= maxItems) {
				// 加载完毕，则注销无限加载事件，以防不必要的加载
				$.detachInfiniteScroll($('.infinite-scroll'));
				// 删除加载提示符
				$('.infinite-scroll-preloader').remove();
				return;
			}

			// 添加新条目
			addItems(itemsPerLoad, lastIndex);
			// 更新最后加载的序号
			lastIndex = $('.list-container li').length;
			//容器发生改变,如果是js滚动，需要刷新滚动
			$.refreshScroller();
		}, 1000);
	});
</script>

</head>

<body>

	<!-- 工具栏 -->
	<nav class="bar bar-tab"> <a class="tab-item external active"
		href="#router2"> <span class="icon icon-home"></span> <span
		class="tab-label">解答</span>
	</a> <a class="tab-item external" href="#router1"> <span
		class="icon icon-edit"></span> <span class="tab-label">求助</span>
	</a> <a class="tab-item external" href="#router3"> <span
		class="icon icon-settings"></span> <span class="tab-label">设置</span>
	</a> </nav>

	<!-- 标题栏 -->
	<header class="bar bar-nav"> <a
		class="icon icon-me pull-left open-panel"></a>
	<h1 class="title">Travel</h1>
	</header>

	<!-- 添加 class infinite-scroll 和 data-distance  向下无限滚动可不加infinite-scroll-bottom类，这里加上是为了和下面的向上无限滚动区分-->
	<div class="content infinite-scroll infinite-scroll-bottom">


		<!--正文内容-->
		<!--需求-->
		<div class="list-block cards-list">
			<ul class="list-container">
				<li class="card facebook-card">
					<div class="card-header no-border">
						<div class="facebook-avatar">
							<img
								src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"
								width="34" height="34">
						</div>
						<div class="facebook-name">食长</div>
						<div class="facebook-date">纽约ABC大街111号 1月15日 15:47</div>
					</div>
					<div class="card-content">
						<img
							src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"
							width="100%">
					</div>
					<div class="card-content">
						<div class="card-content-inner">
							<p class="color-gray">悬赏20$</p>
							<p>迷路了，求接送回凯宁宾馆（ACX大街666号）</p>
						</div>
					</div>
					<div class="card-footer no-border">
						<a href="#" class="link confirm-ok">解答</a> <a href="#"
							class="link">更多</a>
					</div>
				</li>
			</ul>
		</div>
		<!-- 加载提示符 -->
		<div class="infinite-scroll-preloader">
			<div class="preloader"></div>
		</div>
	</div>
</body>
</html>
