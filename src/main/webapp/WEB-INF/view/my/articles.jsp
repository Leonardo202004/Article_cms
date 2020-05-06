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
<div class="container">

		<c:forEach items="${info.list}" var="article">
			<div class="media">
				<img src="/img/${article.picture }" class="mr-3 rounded" alt="..." width="156px" height="108px">
				<div class="media-body">
					<h5 class="mt-0">${article.title }</h5>
					<p><fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
				<div class="float-right">
					<button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModalLong" onclick="detail(${article.id})">
						详情
					</button>
				</div>	
				</div>
			</div>
                 <hr>
        </c:forEach>
	<jsp:include page="/WEB-INF/view/comment/pages.jsp"></jsp:include>
	</div>
	<!-- Button trigger modal -->

<!-- Modal框 -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><span id="title"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="content">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
function goPage(pageNum){
	$("#center").load("/my/list?pageNum="+pageNum);
}
function detail(id){
	$.post(
		"/my/article",
		{id:id},
		function(msg){
			//alert(JSON.stringify(msg))
			$("#title").text(msg.title);
			$("#content").html(msg.content);
		},
		"json"
	)
}
</script>
</body>
</html>