<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<#include "common/base.ftl">
<script type="text/javascript">
	$(document).on('click', '.open-indicator', function() {
		$.showIndicator();
		setTimeout(function() {
			$.hideIndicator();
			$.toast('操作成功');
		}, 2000);
	});
</script>

</head>

<body>
	<header class="bar bar-nav">
	<h1 class='title'>注册</h1>
	</header>
	<div class="content">
		<div class="list-block">
			<ul>
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">账号</div>
							<div class="item-input">
								<input type="text" placeholder="请输入手机号/邮箱" class="">
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">密码</div>
							<div class="item-input">
								<input type="password" placeholder="请输入密码" class="">
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="content-block">
			<a href=""
				class="button button-big button-fill button-success open-indicator">提交</a>
		</div>
	</div>


</body>
</html>
