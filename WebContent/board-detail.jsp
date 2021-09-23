<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">
<link href="resources/css/board/board-detail.css" rel="stylesheet"  type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %> 

<!-- 게시판 목록 리스트 -->
<div class="content">

	<div class="tit">자유게시판</div>
	<div class="category">
				<form>		 		
					<select name="nation">
				 		<option  selected disabled> --게시글 분류--</option>
				 		<option value="all" id ="all">전체보기</option>
				 		<option value="free" id ="free">자유</option>
				 		<option value="scrap" id="scraps">스크랩공유</option>
				 	</select>
			 	</form>
	</div>
	</div>
	<!-- 게시판 검색내용  -->
	<div class="search">
	<div id="search_select">
          <select>
            <option>제목</option>
            <option>내용</option>
            <option>글쓴이</option>
          </select> 
        </div>
        <div id="search_input"><input type="text"></div>
        <div id="search_btn"><i class="fas fa-search"></i></div>
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
			<tbody>
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
		</div>
	
		<!-- 게시판 페이징 구현하는 거 -->
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