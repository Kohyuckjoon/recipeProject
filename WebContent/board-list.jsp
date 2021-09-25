<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet"
	type="text/css">

<!-- <link href="resources/css/board/board-list.css" rel="stylesheet"  type="text/css"> -->
<style type="text/css">
div {
	box-shadow: 0 0 2px black;
}

.tit{
	magin-top:150px;
	position:relative;
	text-align:center;
	color:red;	
	font-size:100px;
}
.category{
	display: flex;
	float: right;
	position:relative;
	right:250px;
	top:20px;
	
}

.board_list{
	position:relative;
    left: 50%;
    transform: translateX(-50%);
    margin-top:50px;
	
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
.paging{

}

.searchForm{
	
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %> 

<!-- 게시판 목록 리스트 -->


	<div class="tit">자유게시판</div>
	<div class="category">
				<form>		 		
					<select name="nation">

				 		<option value="all" id ="all" selected>전체보기</option>
				 		<option value="free" id ="free">자유</option>
				 		<option value="scrap" id="scraps">스크랩공유</option>
				 	</select>
			 	</form>
	</div>
	
	<!-- 게시판 내용 뿌려주는 곳 -->

<div class ="board_list">
	
		<table>
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
			<tbody>
				<tr>
					<td>1</td>
					<td>1번째 게시물</td>
					<td>최윤지</td>
					<td>21-09-23</td>
					<td>0</td>
				</tr>
				<tr>
					<td>2</td>
					<td>2번째 게시물</td>
					<td>최윤지</td>
					<td>21-09-23</td>
					<td>43</td>
				</tr>
				<tr>
					<td>3</td>
					<td>3번째 게시물</td>
					<td>최윤지</td>
					<td>21-09-23</td>
					<td>23</td>
				</tr>
				<tr>
					<td>4</td>
					<td>4번째 게시물</td>
					<td>최윤지</td>
					<td>21-09-23</td>
					<td>2342</td>
				</tr>
				<tr>
					<td>5</td>
					<td>5번째 게시물</td>
					<td>최윤지</td>
					<td>21-09-23</td>
					<td>3453</td>
				</tr>
			</tbody>
		
		</table>
		</div>
		
		<!-- 게시판 페이징 구현하는 거 -->

<div id="paging">
		<i class="fas fa-angle-double-left"></i>
        <i class="fas fa-angle-left"></i>
         	페이지 구현
        <i class="fas fa-angle-right"></i>
        <i class="fas fa-angle-double-right"></i>
</div>
	
	
	<div id="searchForm">
		<form>
			<select name="opt">
				<option value="0">제목</option>
				<option value="1">내용</option>
				<option value="2">제목+내용</option>
				<option value="3">글쓴이</option>
			</select>
			<input type="text" size="20" name="condition"/>&nbsp;
			<input type="submit" value="검색"/>
		</form>	
	</div>
		<input type="submit" value="글쓰기" >
	<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>