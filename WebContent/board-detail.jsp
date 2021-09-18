<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">

<style type="text/css">

html,body{
   height: 100%;
   min-height:200px;
}

.tit{
	text-align: center;
	font-size:7vw;
  	 font-weight:bolder;
}

.category{
	 display:flex;
   justify-content:right;
}


.bdTable{
	display:flex;
	justify-content: center;
	width: 70%;
	height: 66%;
	
}
.btn_page_num{
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
		<table class="bdTable" border="1">
		<!-- 목록  -->
			
				<tr>
					<td width=50>번호</td>
				 	 <td width=300>제목</td>
				 	 <td width=100>작성자</td>
					  <td width=100>작성일</td>
					  <td width=100>조회수</td>
				</tr>
				<tr>
			<td><c:out value="${datas.board.bdIdx}"/></td>
			<td> <c:out value="${datas.board.title}"/></td>
			<td><c:out value="${datas.board.regDate}"/></td>
			<td><c:out value="${datas.board.userId}"/></td>
			<td><c:out value="${datas.board.viewCount}"/></td>
				</tr>
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
			<a href="board-form.jsp"> <input type="button" value="글쓰기" ></a>
<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>