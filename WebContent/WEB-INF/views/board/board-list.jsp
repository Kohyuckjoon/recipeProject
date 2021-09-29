<%@page import="java.util.ArrayList"%>
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


/* div {
	box-shadow: 0 0 2px black;
} */
.top{
height: 100px;
}
.tit{
	position:relative;
	top:105px;
	font-size:2.3vw;
	text-align: center;
	
}
.category{
	width:150px;
	margin:120px;
 	position: relative;
 	left:80%;
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
.paging{
	
	}

Form {
	position:relative;
     margin-top: 30px; 
    left:47%;
}
.formBtn{
   display:flex;
   position:relative;
   left:80%;
   flex-direction:row;
   justify-content:center;
   width:100px;
   background-color: yellow;
}
</style>
</head>
<body>
 <%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="top"></div>
<!-- 게시판 목록 리스트 -->


	<div class="tit">자유게시판</div>
	<div class="category">
				<form>		 		
					<select name="nation">
				 		<option value="" id ="" selected>최신순</option>
				 		<option value="" id ="" >조회순</option>
				 	
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
				   <th width=150>작성자</th>
				   <th width=150>작성일</th>
				   <th width=100>조회수</th>
				</tr>
			</thead>
		<tbody>
		
			<c:forEach items="${datas}" var="board">
				<tr>
					<td>${board.no}</td>
					
					
					<%-- <a href="BoardServlet?command=board_view&num=${board.num}">${board.title}</a> --%>

					<!-- BoardServlet(가상 주소로)
					command키에 board_view와
					num키에 servlet으로 받은 num(Vo)값이 담겨있는 값을 담는다.?no="+rset.getInt("no") -->
					
					<td><a href="/board/board-detail?no=${board.no}">${board.title}</a></td>
					<td>${board.userId}</td>
					<td>${board.regDate}</td>
					<td>${board.viewCount}</td>
				</tr>
			</c:forEach> 
		</tbody>
		
		</table>
		</div>
		
		<!-- 게시판 페이징 구현하는 거 -->

<div id="paging">
		페이징 구현 할 부분
</div>
	
	
	<div class="searchForm">
		
		<form>
			<select name="opt">
				<option value="0">제목</option>
				<option value="3">글쓴이</option>
			</select>
			<input type="text" size="20" name="condition"/>&nbsp;
			<input type="submit" value="검색"/>
		</form>	
		
	</div>
	<button class="formBtn" onclick = "location.href = '/board/board-form'">글쓰기</button>
	<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>