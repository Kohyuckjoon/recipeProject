<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/myPage/myReview.css" rel="stylesheet"  type="text/css">

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
				</tr>
			</c:forEach> 
		</tbody>
		
		</table>
		</div>
	
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>