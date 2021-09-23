<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">
<link href="resources/css/board/board-list.css" rel="stylesheet"  type="text/css">
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
        <div id="search_input"><input type="text" place></div>
        <div id="search_btn"><i class="fas fa-search"></i></div>
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

<div id="pageForm">
		페이지 번호
	</div>
	<br>
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
	<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>