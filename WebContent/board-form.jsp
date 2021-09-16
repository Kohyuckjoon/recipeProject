<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/all.css" rel="stylesheet">
<link href="resources/css/test.css"rel="stylesheet"  type="text/css">
<link rel="stylesheet" href="/resources/css/board/board.css"/>
</head>
<body>
<div class="head">
		<div class="title">RfDnH</div>
		<form class="pagebutton">
			<button class="mainPageButton">메인페이지</button>
			<button class="recipePageButton">다이어트 & 헬스 레시피</button>
			<button class="boardPageButton">자유게시판</button>
			<button class="myPageButton">마이페이지</button>
		</form>

		<form class="search-box" id="search_button">
			<button type="submit" form="search_button" class="btn-search">
				<i class="fas fa-search"></i>
			</button>
			<input type="text" name="search" class="input-search"
				placeholder="Type to Search..." id="search_keyword">
		</form>


	
<div class="content">
	<h2 class="tit">게시판</h2>
	<div class="desc_board">
		<form action="${contextPath}/board/upload" method="post" enctype="multipart/form-data">
			<div>
				<div class="tit_board">
					제목 : <input type="text" name="title" required="required"/><br>
					파일 : <input type="file" name="files" id="contract_file" multiple/>
				</div>
				<div class="category">
				<form>		 		
					<select name="nation">
				 		<option  selected disabled> ---게시글 분류---</option>
				 		<option value="free">자유</option>
				 		<option value="ch">스크랩공유</option>
				 	</select>
				 	<input type="submit">
			 </form>
				</div>
				<div class="content_board">
					<textarea name="content" required="required"></textarea>
				</div>
				<div class="btn_section">
					<button style="background-color:blue; color:white; width:100%">전송</button>
				</div>
			</div>
		</form>
	</div>
</div>

	<!-- 여기부턴 foot -->
	<div class="foot">
		<div class="Copyright">Copyright © 1992-2021 HSJ All Right
			Reserved</div>
	</div>
</body>
</html>