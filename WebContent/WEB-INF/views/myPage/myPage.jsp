<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet" type="text/css">

<style type="text/css">

.top{
	height:100px;
}

#myPage {
	display: flex;
	margin-top: 5vw;
}                 

#memberInfo { /* 회원정보 div */
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
	text-align:center;
}

#myReview { /* 댓글&리뷰 모아보기 div */
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
	text-align:center;
}

#myScrape { /* 스크랩 모아보기 div */
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
	text-align:center;
}


.memberInfo{ /* 회원정보 이미지 삽입 */
	background-image: url(/resources/img/mypage_memberinfo.png);
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;
}
.myReview{ /* 댓글&리뷰 이미지 삽입 */
	background-image: url(/resources/img/mypage_review.png);
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;
}

.myScrape{ /* 스크랩 이미지 삽입 */
	background-image: url(/resources/img/mypage_scrape.png);
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;
}
</style>
</head>
<body>
	
	<!-- 여기서부터 헤드 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	

	<!-- myPage 바디 -->

	<div class="top"></div>
	<c:if test="${not empty authentication}">
	<a href="/member/logout">
    <span>로그아웃</span>
    </a>
	</c:if>
	<div id="myPage">
		<div class="memberInfo" id="memberInfo" onclick = "location.href = '/myPage/memberInfo' ">
		회원정보 및 수정			
		</div>
		<div class="myReview" id="myReview" onclick = "location.href = '/myPage/myReview' ">
		댓글 & 평점		
		</div>
		<div class="myScrape" id="myScrape" onclick = "location.href = '/myPage/myScrape' ">
		스크랩
		</div>
	</div> 

	<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>