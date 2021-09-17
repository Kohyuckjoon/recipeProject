<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp" %>
<link href="resources/css/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/all.css" rel="stylesheet">
<link href="resources/css/test.css"rel="stylesheet"  type="text/css">

<style type="text/css">

html,body{
   height: 100%;
   min-height:200px;
}

.tit{
	text-align: center;
	font-size: 10vw;
  	 font-weight:bolder;
}

.category{
	 display:flex;
   justify-content:right;
}
.list{
   display:flex;
   justify-content:center;
   align-items:center;
   height: 70%;
}


.btn_page_num{
	text-align: center;
	font-size: 1vw;
  	 font-weight:bolder;
}

.btn_section{
	display:flex;
   justify-content:right;
}



/*board-detail*/
.info{font-size:1.3vw; border-bottom:1px solid}
.info span{padding-right: 3vw;}
.info li{font-size:0.5vw;}

.foot{
   display:flex;
   flex-direction:row-reverse;
   align-items:center;
   height: 10vh;   
}



</style>
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

</div>

<!-- 게시판 목록 리스트 -->
<div class="content">

	<h1 class="tit">게시판</h1>
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
	<div class="info">
		<span>번호 <c:out value="${datas.board.bdIdx}"/></span>
		<span>제목  <c:out value="${datas.board.title}"/></span>
		<span>등록일  <c:out value="${datas.board.regDate}"/></span>
		<span>작성자  <c:out value="${datas.board.userId}"/></span>
		<span>조회수  <c:out value="${datas.board.viewCount}"/></span>
	</div>
	
	

		
	
		
<div class="btn_page_num" id=page>
				
				<a href="#"><i class="fas fa-angle-double-left"></i></a>
				<a href="#"><i class="fas fa-angle-left"></i></a>
			    <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
				<a href="#"><i class="fas fa-angle-right"></i></a>
				<a href="#"><i class="fas fa-angle-double-right"></i></a>
</div>
	<div class="btn_section">
					<button style="background-color:blue; color:white; width:10%" >글쓰기</button>
	</div>
<!-- 여기부턴 foot -->
	<div class="foot">
		<div class="Copyright">Copyright © 1992-2021 HSJ All Right
			Reserved</div>
	</div>
</body>
</html>