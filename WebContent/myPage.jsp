<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/all.css" rel="stylesheet">
<link href="resources/css/test.css" rel="stylesheet" type="text/css">
<style type="text/css">
#myPage {
	display: flex;
	margin-top: 5vw;
}

#memberInfo {
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
}

#myRivew {
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
}

#myscrape {
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
}
</style>
</head>
<body>
	<!-- 여기서부터 헤드 -->
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

		<div class="login">
			<form>
				<button type="submit">
					<i class="fas fa-user-circle"></i>
				</button>
			</form>
		</div>
	</div>

	<!-- 마이페이지 메인 -->
	<div id="myPage">
		<div id="memberInfo">asdasdsa</div>
		<div id="myRivew">zxczxcxzx</div>
		<div id="myscrape">qweqeqwwe</div>
	</div>

	<!-- 여기부턴 foot -->
	<div class="foot">
		<div class="Copyright">Copyright © 1992-2021 HSJ All Right
			Reserved</div>
	</div>
</body>
</html>