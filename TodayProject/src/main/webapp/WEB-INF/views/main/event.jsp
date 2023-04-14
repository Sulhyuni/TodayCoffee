<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jspf는 조각파일이라고 생각하면 됨. html, head, body 태그 필요 없음 -->
<table class="table">
	<thead>
		<tr>
			<th>No</th>
			<th>Title</th>
			<th>Start Date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${eventList }" var="vo">
			<tr class="dataRow event">
				<td class="no">${vo.eventNo }</td>
				<td>${vo.title }</td>
				<td>${vo.startDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
