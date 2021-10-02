<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/mainPage.css" rel="stylesheet" type="text/css">

<style type="text/css">

.top{
height: 100px;
}
.tit{
	position:relative;
	top:105px;
	font-size:2.3vw;
	text-align: center;
	
}
.board_list{
	position:relative;
    left: 50%;
    transform: translateX(-50%);
    margin-top:30px;
	
}

.board_list {
	width:80%;
	border-top: 2px solid navy;
	display: flex;
	font-size:1vw;
	justify-content: center;
	align-items: center;
}

.board_list tr {
	border-bottom :1px solid #999;
}
.board_list th,
.board_list td{
	padding: 10px;
}
.board_list td{
text-align: center;
}
.board_list tbody tr td:nth-child(2){
text-align: left;
}
.board_list tbody tr td:nth-child(2):hover{
text-decoration: underline;
}
</style>

</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div class="top"></div>

	<div class="tit">자유게시판</div>
	
	<div class ="board_list">
	
		<table>
		<!-- 목록  -->
			<thead>
				<tr>
				   <th width=100>번호</th>
				   <th width=100>레시피 이름</th>
				   <th width=300>내용</th>
				   <th width=100>작성자</th>
				   <th width=150>작성일</th>
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