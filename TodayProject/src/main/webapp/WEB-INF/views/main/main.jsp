<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	$(".dataRow").click(function(){
		let no = $(this).find(".no").text();
		if(!no) no = $(this).data("no");
		if($(this).hasClass("notice")) location = "/notice/view.do?no="+no+"&inc=1";
		if($(this).hasClass("event")) location = "/event/view.do?no="+no+"&inc=1";
		if($(this).hasClass("goods")) location = "/goods/view.do?no="+no;
	});
});
</script>
<style type="text/css">
#main1 {
	border-top: solid 5px #c7bbad;
	border-top-width: 35px;
	padding: 3em 0 0 0;
}
.dataRow:hover{
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- Banner -->
	<section id="banner">
		<div class="content">
			<h2>Welcome to Today Coffee</h2>
			<p>Sip, Savor, and Enjoy: A Coffee Experience Like No Other at
				Our Cafe</p>
			<a href="#main1" class="button scrolly">Experience</a>
		</div>
	</section>

	<!-- Main -->
	<section id="main1">
		<div class="container">
			<section class="box blog">
				<h2 class="major">
					<span>Notice &amp; Event</span>
				</h2>
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">Notice</div>
							<div class="panel-body">
								<jsp:include page="notice.jsp" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">Event</div>
							<div class="panel-body">
							 	<jsp:include page="event.jsp" />
							</div>
						</div>
					</div>
				</div>
			</section>


			<section class="box blog">
				<h2 class="major">
						<span>Product</span>
				</h2>
					<div class="row">	
						<div class="col-md-12">				
						<jsp:include page="goods.jsp" />
						</div>				
					</div>
			</section>
		</div>
	</section>

</body>
</html>