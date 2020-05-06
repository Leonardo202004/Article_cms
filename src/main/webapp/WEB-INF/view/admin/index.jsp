<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div class="row">
			<div class="col-md-12" style="background-color: black">
				<img alt="" src="/resource/image/1.jpg" height="50px" width="50px"
					class="rounded-circle"> <font color="white">管理员中心</font>
			</div>
		</div>
		<div class="row mt-1">
			<div class="col-md-2">
				<div class="list-group">
					<a href="#" data="/admin/list"
						class="list-group-item list-group-item-action active"> 审核文章 </a> <a
						href="#" data="/admin/users"
						class="list-group-item list-group-item-action"> 管理用户</a> <a
						href="#" class="list-group-item list-group-item-action">系统设置</a>
				</div>
			</div>
			<div class="col-md-10" id="center"></div>
		</div>
	</div>
	<script type="text/javascript">
		$("#center").load("/admin/list");

		$("a").click(function() {
			//2/获取A标签的data
			var url = $(this).attr("data");

			$("a").removeClass("active");//删除所有样式
			$(this).addClass("active");//为当前点击的菜单增加选中样式
			//3 在中间区域加载url
			$("#center").load(url);
		})
	</script>
</body>
</html>