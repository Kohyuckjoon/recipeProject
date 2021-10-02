<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet"type="text/css">

 <link rel="stylesheet" href="/resources/css/board/board.css"/>

</head>
<body>


 <%@ include file="/WEB-INF/views/include/header.jsp" %> 

	<div class="top"></div>
	
<div class="content"> 
	<div class="tit">게시판 글쓰기 양식</div>
	<div class="desc_board">
		<form action="/board/upload" method="post" enctype="multipart/form-data">
			<div>
				<div class="tit_board">
					제목 : <input type="text" name="title" required="required" placeholder="글 제목을 입력하세요"/>
				
				</div>
				
				<div class="content_board">
					<textarea name="content" required="required" maxlength="250" placeholder="250글자 이하로 작성하시오."></textarea>
				</div>
				<div class="btn">
				<button  >전송</button>
				<button onclick = "location.href = '/board/board-list'" >목록</button>
				</div>
			</div>
		</form>
	</div>
</div>

	<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>