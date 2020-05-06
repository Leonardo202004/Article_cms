<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
		<link rel="stylesheet" href="/resource/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/resource/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="/resource/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="/resource/kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<%=htmlData%>
	<form id="form1">
	<div class="form-group">
	<label for="title">标题:</label>
	<input id="title" class="form-control" name="title" type="text">
	</div>
	<div class="form-group">
	<label for="picture">图片:</label>
	<input id="picture" class="form-control-file" name="file" type="file">
	</div>
	<div class="form-group form-inline">
	<label for="channel">栏目:</label>
	<select id="channel" class="form-control" name="channelId" type="text">
		<option>请选择</option>
	</select>
	<label for="category">分类:</label>
	<select id="category" class="form-control" name="categoryId" type="text">
		<option>请选择</option>
	</select>
	</div>
		<textarea name="content1" cols="100" rows="8" style="width:1571.5px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<input type="button" name="saves" value="发布" onclick="savess()" class="btn btn-info"/>
	</form>
	<script type="text/javascript">
	
	 $.get("/my/channels",function(msg){
		 //遍历所有的栏目，动态追加option
		 for(var i in msg){
			 $("#channel").append("<option value='"+msg[i].id+"'>"+msg[i].name+"</option>");
		 }
		 
	 });
	 //为栏目添加点击事件
	 $("#channel").change(function(){
		 var channelId =$(this).val();//获取当前点击的栏目id
		 $("#category").empty();//先清空原有分类
		 $.get("/my/getCategoryByChannelId",{channelId:channelId},function(msg){
			 //遍历所有的分类，动态追加option
			 for(var i in msg){
				 $("#category").append("<option value='"+msg[i].id+"'>"+msg[i].name+"</option>");
			 }
		 })
	 })
	function savess(){
		 var formData = new FormData($("#form1")[0]);
		// alert(editor1.html());
		 formData.set("content",editor1.html());
		 $.ajax({
			 url:"/my/insert",
			 data:formData,
			 type:"post",
			 processData:false,
			 contentType:false,
			 success:function(msg){
				 if (msg>0) {
					alert("发布成功");
					location="/my";
				}else{
					alert("发布失败");
				}
			 }
		 })
	 }
	</script>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>