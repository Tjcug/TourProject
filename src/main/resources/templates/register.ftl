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
				<!-- Text inputs -->
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">昵称</div>
							<div class="item-input">
								<input type="text" placeholder="请输入昵称">
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">手机号</div>
							<div class="item-input">
								<input type="text" placeholder="请输入手机号">
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">手机验证码</div>
							<div class="item-input">
								<input type="text" placeholder="请输入手机验证码">
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
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">确认密码</div>
							<div class="item-input">
								<input type="password" placeholder="请再次输入密码" class="">
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">性别</div>
							<div class="item-input">
								<select>
									<option>男士</option>
									<option>女士</option>
								</select>
							</div>
						</div>
					</div>
				</li>
				<!-- Date -->
				<li>
					<div class="item-content">
						<div class="item-inner">
							<div class="item-title label">生日</div>
							<div class="item-input">
								<input type="date" value="2000-00-00">
							</div>
						</div>
					</div>
				</li>

			</ul>
		</div>
		<div class="content-block">
			<div class="row">
				<div class="col-50">
					<a href="/register"
						class="button button-big button-fill button-danger">重置</a>
				</div>
				<div class="col-50">
					<a href="#"
						class="button button-big button-fill button-success open-indicator">提交</a>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
