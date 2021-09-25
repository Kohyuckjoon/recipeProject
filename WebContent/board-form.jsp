<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet"
	type="text/css">

 <link rel="stylesheet" href="/resources/css/board/board.css"/>

</head>
<body>


 <%@ include file="/WEB-INF/views/include/header.jsp" %> 

	
<div class="content"> 
	<h2 class="tit">게시판 글쓰기 양식</h2>
	<div class="desc_board">
		<form action="${contextPath}/board/upload" method="post" enctype="multipart/form-data">
			<div>
				<div class="tit_board">
					제목 : <input type="text" name="title" required="required" placeholder="글 제목을 입력하세요"/>
					<br>
					파일 : <input type="file" name="files" id="contract_file" multiple/>
				</div>
				<!-- <div class="category">
				<form>		 		
					<select name="nation">
				 		<option  selected disabled> ---게시글 분류---</option>
				 		<option value="free" id ="free">자유</option>
				 		<option value="scrap" id="scraps">스크랩공유</option>
				 	</select>
			 </form>
				</div> -->
				<div class="content_board">
					<textarea name="content" required="required" maxlength="250" placeholder="250글자 이하로 작성하시오."></textarea>
				</div>
				<button style="background-color:red; color:white; width:100%">전송</button>
				<!-- <a href="board-list.jsp"> <input type="button" value="목록" ></a> -->
			</div>
		</form>
	</div>
</div>

	<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>