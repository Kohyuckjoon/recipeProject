<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">
<style type="text/css">
#myPage {
	display: flex;
	margin-top: 5vw;
}

#memberInfo { /* 회원정보 div */
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
}

#myRivew { /* 댓글&리뷰 모아보기 div */
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
}

#myScrape { /* 스크랩 모아보기 div */
	background-color: silver;
	width: 33%;
	height: 300px;
	margin-right: 10px;
}

.myRivew{ /* 댓글&리뷰 이미지 삽입 */
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
	<div id="myPage">
		<div class="memberInfo" id="memberInfo" onclick = "location.href = '/myPage/myPage_memberInfo' ">			
		</div>
		<div class="myRivew" id="myRivew" onclick = "location.href = '/myPage/myPage_review' ">		
		</div>
		<div class="myScrape" id="myScrape" onclick = "location.href = '/myPage/myPage_scrape' ">
		</div>
	</div> 

	<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>