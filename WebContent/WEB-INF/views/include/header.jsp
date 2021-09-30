<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/css/include/header.css" rel="stylesheet"  type="text/css">
<title>header</title>
</head>

	<div class="header">
		<div class="title"></div>
		<div class="pagebutton">
			<button class="mainPageButton">메인페이지</button>
			<button class="recipePageButton">다이어트 & 헬스 레시피</button>
			<button class="boardPageButton">자유게시판</button>
			<button class="myPageButton">마이페이지</button>
		</div>
		
		<form class="search-box" id="search_button">
			<button type="submit" form="search_button" class="btn-search">
				<i class="fas fa-search"></i>
			</button>
			<input type="text" name="search" class="input-search" placeholder="검색어를 입력하세요" id="search_keyword">
		</form>


		<div class="login">
				<button class="login_btn">
					<i class="fas fa-user-circle"></i>
				</button>
		</div>
		
	</div>
	


</html>