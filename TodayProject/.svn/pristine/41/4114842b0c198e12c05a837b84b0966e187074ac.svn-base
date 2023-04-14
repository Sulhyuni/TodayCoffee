<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<!-- 라이브러리 등록  : CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<style type="text/css">
.dataRow>.img:hover {
	cursor: pointer;
}
/* .dataRow>.thumbnail{ */
/* 	margin-bottom: 50px; */
/* } */

/* 이미지확대 */
.img-zoom:hover {
	transform: scale(1.1, 1.1);
	-webkit-transform: scale(1.1, 1.1);
}

#name_kr {
	font: 18px;
	font-weight: 900;
	text-align: center;
}

#div-head{
	display: none;
}
</style>



<script type="text/javascript">
	$(function() {
		//alert("jQuery 동작함")
		$(".dataRow").click(function() {
			let goodsNo = $(this).data("no");
			//alert("클릭한번호 : " + goodsNo);
			location = "view.do?no="+ goodsNo + "&inc=1&page=${param.page}&perPageNum=${param.perPageNum}"
									+ "&key=${param.key}&word=${param.word}";
						});
		
			//전체 체크박스 클릭
		$("#checkAll").click(function() {
			if ($("#checkAll").is(":checked")) 
				$("input[name=word]").prop("checked",true) 
			 else 
				$("input[name=word]").prop("checked",false);
		});

			// 개별 체크박스 클릭 시 전체 체크박스 체크 해제
			$(".ck").click(function() {
			  if ($(this).attr("id") != "checkAll" && !$(this).is(":checked")) {
			    $("#checkAll").prop("checked", false);
			  }
			});
			
			// 전체 체크박스 클릭 시 개별 체크박스 체크 상태 변경
			$("#checkAll").click(function() {
			  $("input[name='word']").prop("checked", $(this).is(":checked"));
			});
			
		//key 세팅
		if ("${param.key}")	
			$("#key").val("${param.key}");
		
		//perPageNum 세팅
		if ("${param.perPageNum}")
			$("#perPageNum").val("${param.perPageNum}");
			});
</script>



</head>
<body>
	<!-- 개발 후반부에 관리자 접근 주석 풀기 -->
	<div class="container">
		<div class="col-md-12">
			<c:if test="${login !=null && login.gradeNo ==9 }">
				<a href="write.do">
					<button style="float: right; margin-bottom: 20px;">상품등록</button>
				</a>
			</c:if>
			<h2>Drink&amp;Food</h2>
		</div>
		<div class="col-md-12">
			<hr>
		</div>

		<!-- 검색 카테고리 -->
		<div class="col-md-12">
			<h4>분류보기</h4>
<!-- 체크박스 구현해서 카테고리 만들기 // 전체 체크시 모든 데이터 가져오기 구현 중... -->
			<form class="form-inline">
				<input value="${param.perPageNum }" type="hidden">
					<div class="form-group" id="div-head">
						<select class="form-control" id="key" name="key">
							<option value="goodsDiv" selected="selected">분류</option>
						</select>
					</div>
			<div class="form-group" id="search" >
				<label for="selectAll" class="checkbox-inline"><input type="checkbox" id="checkAll"  class="ck"   />전체 메뉴
				</label> 
				<label for="hot" class="checkbox-inline"><input type="checkbox" value="hot" name="word" class="ck">HOT음료
				</label>
				<label for="ice" class="checkbox-inline"><input type="checkbox" value="ice" name="word" class="ck">ICE음료
				</label> 
				<label for="food" class="checkbox-inline"><input type="checkbox" value="food" name="word" class="ck">케이크,샌드위치,브레드
				</label>
					<button type="submit" style="padding: 10px;">
						<i class="glyphicon glyphicon-search"></i>
					</button>
			</div>
			</form>

<!-- 검색 // 메뉴 이름, 상세내용 검색 할 수 있는 검색 -->
<!-- 체크박스 구현 못하면 검색 입력으로 대체 하기 -->
<!-- 				<form class="form-inline"> -->
<%-- 					<input value="${param.perPageNum }" type="hidden"> --%>
<!-- 					<div class="form-group"> -->
<!-- 						<select class="form-control" id="key" name="key"> -->
<!-- 							<option value="nk">한글명</option> -->
<!-- 							<option value="ne">영문명</option> -->
<!-- 							<option value="goodsDiv">분류</option> -->
<!-- 							<option value="nkne" selected="selected">전체</option> -->
<!-- 						</select> -->
<!-- 					</div> -->

<!-- 					<div class="form-group" id="search"> -->
<!-- 						<input type="text" class="form-control" placeholder="Search" -->
<%-- 							name="word" value="${param.word }" > --%>
<!-- 					</div> -->

<!-- 					<button type="submit" style="padding: 10px;"> -->
<!-- 						<i class="glyphicon glyphicon-search"></i> -->
<!-- 					</button> -->
<!-- 				</form> -->


			<hr style="margin-top: 20px;">
		</div>

		<div class="row">
			<!-- c:forEach 의 속성 중 반복 회수가 저장 되어있는 varStatus 변수의 상태 -->
			<c:forEach items="${list }" var="vo" varStatus="vs">
				<!-- 데이터 출력 개수가 4의 배수 -->
				<c:if test="${vs.index != 0 && vs.index % 4 == 0}">
			${"</div>"}
			${"<div class = \"row\">"}
		</c:if>
				<div class="col-md-3 dataRow" data-no="${vo.goodsNo }"
					style="margin-bottom: 50px;">
					<div class="img">
						<img src="${vo.fileName }" class="img-zoom" alt="${vo.fileName }"
							style="width: 100%">
						<div class="caption">
							<p id="name_kr" style="margin-bottom: 5px;">${vo.name_kr }</p>
								<span class="pull-right">${vo.price}원<br/>
								${vo.goodsDiv}<br/>
									<c:if test="${login !=null && login.gradeNo ==9 && vo.goodsDiv eq 'food' }">
										<p class="pull-right">(${vo.stock}개)</p>
									</c:if>
								</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>