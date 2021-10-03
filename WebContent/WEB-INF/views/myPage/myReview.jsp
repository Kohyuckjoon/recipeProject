<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/myPage/myReview.css" rel="stylesheet"  type="text/css">
<style type="text/css">

.myReview_list tbody td form .cancel-img{
	width: 20px;
	height: 20px;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div class="top"></div>

	<div class="tit">내가 쓴 댓글</div>
	
	<div class ="myReview_list">
	
		<table style="table-layout: fiexd; width:70%;">
		<!-- 목록  -->
			<thead>
				<tr>
				   <th width="10%">번호</th>
				   <th width="20%">레시피 이름</th>
				   <th width="40%">내용</th>
				   <th width="15%">작성자</th>
				   <th width="15%">작성일</th>
				   <th width="15%">삭제</th>
				</tr>
			</thead>
	
		<tbody>		
			<c:forEach items="${myReviews}" var="myReview">
				<tr>
					<td>${myReview.reviewNo}</td>
					<td>${myReview.rcpNm}</td>
					<td>${myReview.reviewContents}</td>
					<td>${myReview.userId}</td>
					<td>${myReview.reviewDate}</td>
					<td>
					<form action="/myPage/cancelReview" method="get">
								<input type="hidden" name="reviewNo" value="${myReview.reviewNo }" />
								<input class="cancel-img" type="image"
									src="/resources/img/scrape_cancel.png" />
							</form>
					</td>
				</tr>
			</c:forEach> 
		</tbody>
		
		</table>
		</div>
		
		<div style="text-align: center; vertical-align: bottom; height: 50px;" >
		<c:forEach begin="1" end="${pageLength}" step="1" var="page">
			<span><a href="/myPage/myReview?page=${page}" > ${page} </a></span>
		</c:forEach>
		</div>
	
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>