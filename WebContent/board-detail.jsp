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


.paging{
 	display:flex;
	text-align: center;
	font-size: 1vw;
  	 font-weight:bolder;
  	
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
					<td width=50>번호</td>
				 	 <td width=300>제목</td>
				 	 <td width=100>작성자</td>
					  <td width=100>작성일</td>
					  <td width=100>조회수</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>첫번째 게시물</td>
					<td> 최윤지</td>
					<td> 2021-09-19</td>
					<td>254</td>
				</tr>
			</tbody>
		</table>
		
	
		
<div class="btn_page_num" id=page>
				
				<i class="fas fa-angle-double-left"></i>
				<i class="fas fa-angle-left"></i>
			    <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
				<i class="fas fa-angle-right"></i>
				<i class="fas fa-angle-double-right"></i>
</div>
	<div class=btn">
			<a href="board-form.jsp"> <input type="button" value="글쓰기" ></a>
	</div>
<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>