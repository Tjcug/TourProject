<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<#include "common/base.ftl">

<script type="text/javascript">
	$(document).on('click', '.add-picture', function() {
		var buttons1 = [ {
			text : '拍照上传',
			bold : true,
			onClick : function() {
				$.alert("你选择了拍照上传");
			}
		}, {
			text : '相册上传',
			onClick : function() {
				$.alert("你选择了相册上传");
			}
		} ];
		var buttons2 = [ {
			text : '取消',
			bg : 'danger'
		} ];
		var groups = [ buttons1, buttons2 ];
		$.actions(groups);
	});
</script>
</head>

<body>
	<!-- 工具栏 -->
	<nav class="bar bar-tab"> <a class="tab-item external"
		href="#router2"> <span class="icon icon-home"></span> <span
		class="tab-label">解答</span>
	</a> <a class="tab-item external active" href="#router1"> <span
		class="icon icon-edit"></span> <span class="tab-label">求助</span>
	</a> <a class="tab-item external" href="#router3"> <span
		class="icon icon-settings"> </span> <span class="tab-label">设置</span>
	</a> </nav>

	<!-- 标题栏 -->
	<header class="bar bar-nav"> <a
		class="icon icon-me pull-left open-panel"></a>
	<h1 class="title">Travel</h1>
	</header>
	<div class="content">
		<div class="list-block">
			<ul>
				<!--悬赏金额 -->
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-input">
								<input type="text" placeholder="请输入悬赏金额($)">
							</div>
						</div>
					</div>
				</li>
				<!--求助内容-->
				<li class="align-top">
					<div class="item-content">
						<div class="item-inner">
							<div class="item-input">
								<textarea placeholder="请输入求助内容"></textarea>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>

		<div class="card">
		
			<div class="card-content">
				<div class="list-block">
					<ul>
					<li>
					<img alt="求助照片" src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"
					width="100%">
					</li>
						<li><a href="#" class="item-link item-content add-picture">
								<div class="item-inner">
									<div class="item-title">选择照片</div>
								</div>
						</a></li>
						<li><a href="#" class="item-link item-content">
								<div class="item-inner">
									<div class="item-title">选择定位</div>
									<div class="item-aftre"><p class="color-gray">ABC大街256号</p></div>
								</div>
						</a></li>
					</ul>
				</div>
			</div>
		</div>

		<!-- 		<input type="file" accept="video/*;capture=camcorder"> <input
			type="file" accept="audio/*;capture=microphone"> -->

		<div class="content-block">
			<a href="#router2"
				class="button button-big button-fill button-success">提交</a>
		</div>
	</div>



</body>
</html>
