<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">

<style type="text/css">


.tit{
	text-align: center;
	font-size:7vw;
  	 font-weight:bolder;
}

.category{
	 display:flex;
   justify-content:right;
}

.board_list {
	width:80%;
	border-top: 2px solid navy;
	display: flex;
	justify-content: center;
}
.board_list tr {
	border-bottom :1px solid #ccc;
}
.board_list th,
.board_list td{
	padding 10px;
	font-size:14px;
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
.paging{
 	display:flex;
	justify-content: center;
  	margin-top: 20px;
  	
}

.btn{
	 display:flex;
   justify-content:right;
}


</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- 게시판 목록 리스트 -->
<div class="content">

	<div class="tit">자유게시판</div>
	<div class="category">
				<form>		 		
					<select name="nation">
				 		<option  selected disabled> ---게시글 분류---</option>
				 		<option value="all" id ="all">전체보기</option>
				 		<option value="free" id ="free">자유</option>
				 		<option value="scrap" id="scraps">스크랩공유</option>
				 	</select>
			 	</form>
	</div>
	
	<!-- 게시판 내용 뿌려주는 곳 -->

<div class ="board_list">

	<div>
		<table >
		<!-- 목록  -->
			<thead>
				<tr>
					<th width=50>번호</th>
				 	 <th width=300>제목</th>
				 	 <th width=100>작성자</th>
					  <th width=100>작성일</th>
					  <th width=100>조회수</th>
				</tr>
			</thead>
			<c:forEach var="board" items="${ls}">
				<tr>
					<td>${board.no}</td>
					<td>${board.title}</td>
					<td>${board.id}</td>
					<td>${board.date}</td>
					<td>${board.viewCount}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	
		
<div class="paging" >
				
				<i class="fas fa-angle-double-left"></i>
				<i class="fas fa-angle-left"></i>
			    <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
				<i class="fas fa-angle-right"></i>
				<i class="fas fa-angle-double-right"></i>
</div>
	<div class="btn">
			<a href="board-form.jsp"> <input type="button" value="글쓰기" ></a>
	</div>
<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>