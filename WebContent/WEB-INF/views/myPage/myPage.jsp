<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/myPage/myPage.css" rel="stylesheet"  type="text/css">

</head>
<body>
	
	<!-- 여기서부터 헤드 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	

	<!-- myPage 바디 -->
	<c:if test="${empty authentication and empty sessionStorage}">
		<c:redirect  url="/member/login-form"/>
	</c:if>
	
	<div class="top"></div>
	
	<c:if test="${not empty authentication}">
		<div style ="float:right;" class="button-4">
		    <div class="eff-4"></div>
		    <a href="/member/logout"> 로그아웃</a>
	    </div>
  	</c:if>
	
	<c:if test="${not empty sessionStorage}">    
		<div style ="float:right;" class="button-4">
		    <div class="eff-4"></div>
		    <a onclick="kakaoLogout();"> 로그아웃</a>
	    </div>
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

	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
		function kakaoLogout() {
			 if (!Kakao.Auth.getAccessToken()) {
			      alert("로그인 되어있지 않습니다.");
			      return
			    }
			var logout = confirm("로그아웃 하시겠습니까?");
			if(logout == true){
				Kakao.Auth.logout(function() {
		       	alert("로그아웃 되셨습니다.");
		       	Kakao.Auth.getAccessToken()
		        location.href = 'http://localhost:9090/mainPage/mainPage';
		      })
		      Kakao.Auth.setAccessToken(undefined)
			}else{
				return false;
				
			}
		  } 
	</script>
</body>
</html>