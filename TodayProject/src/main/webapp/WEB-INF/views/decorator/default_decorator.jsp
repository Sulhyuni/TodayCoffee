<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
System.out.println("default_decorator.do [path] : " + request.getContextPath());
request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<title>Today - <decorator:title /></title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/Resources/assets/css/bootstrap.css" />
<link rel="stylesheet" href="/Resources/assets/css/main.css" />

<decorator:head />
</head>
<body class="homepage">
	<div id="page-wrapper">

		<!-- Header -->
		<header id="header">
			<div class="logo container">
				<div>
					<h1>
						<a href="/" id="logo">Today</a>
					</h1>
					<p>A premium roasting coffee</p>
				</div>
			</div>
		</header>



		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="/">Home</a></li>
				<li><a href="#">Notice &amp; Event</a>
					<ul>
						<li><a href="${path }/notice/list.do">Notice</a></li>
						<li><a href="${path }/event/list.do">Event</a></li>
					</ul></li>
				<li><a href="${path }/goods/list.do">Product</a>
<%-- 				<li><a href="${path }/member/list.do">Member</a></li> --%>
				<c:if test="${ login != null && login.gradeNo == 9 }">
					<li><a href="${path }/order/list.do">Order</a></li>
				</c:if>
				<c:if test="${empty login }">
					<li><a href="${path }/member/login.do">Login</a></li>
				</c:if>
				<c:if test="${!empty login }">
					<li><a href="${path }/cart/list.do">CART</a></li>
					<li><a href="${path }/member/mymenu.do">MyMenu</a></li>
					<li><a href="${path }/member/logout.do">Logout</a></li>
				</c:if>
			</ul>
		</nav>


		<section id="main">
			<decorator:body />
		</section>


		<!-- Footer -->
		<footer id="footer">
			<div class="container">
				<div class="row gtr-200">
					<div class="col-12">

						<!-- Contact -->
						<section>
							<h2 class="major">
								<span>Contact</span>
							</h2>
							<ul class="contact">
								<li><a class="icon brands fa-facebook-f" href="#"><span
										class="label">Facebook</span></a></li>
								<li><a class="icon brands fa-twitter" href="#"><span
										class="label">Twitter</span></a></li>
								<li><a class="icon brands fa-instagram" href="#"><span
										class="label">Instagram</span></a></li>
								<li><a class="icon brands fa-dribbble" href="#"><span
										class="label">Dribbble</span></a></li>
								<li><a class="icon brands fa-linkedin-in" href="#"><span
										class="label">LinkedIn</span></a></li>
							</ul>
						</section>

					</div>
					<div class="col-12">

						<!-- About -->
						<section>
							<h2 class="major">
								<span>about today</span>
							</h2>
							<p>사업자등록번호 : 123-12-12345 | 주식회사 투데이컴퍼니 대표이사 : 김오늘 | TEL :
								1555-1555 | 개인정보 책임자 : 이내일</p>
						</section>
					</div>
				</div>

				<!-- Copyright -->
				<div id="copyright">
					<ul class="menu">
						<li>&copy; 2023 Today Coffee Company. All Rights Reserved.</li>
					</ul>
				</div>

			</div>
		</footer>

	</div>

	<script src="/Resources/assets/js/jquery.min.js"></script>
	<script src="/Resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/Resources/assets/js/jquery.scrolly.min.js"></script>
	<script src="/Resources/assets/js/browser.min.js"></script>
	<script src="/Resources/assets/js/breakpoints.min.js"></script>
	<script src="/Resources/assets/js/util.js"></script>
	<script src="/Resources/assets/js/main.js"></script>
	<script type="text/javascript" src="/Resources/assets/js/bootstrap.js"></script>

</body>
</html>