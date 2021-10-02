<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/myPage/myPage.css" rel="stylesheet"  type="text/css">
<link href="../resources/css/myPage/memberInfo.css" rel="stylesheet"  type="text/css">
</head>

<body>

	<c:if test="${empty authentication}">
	<c:redirect  url="/member/login-form"/>
	</c:if>
<script type="text/javascript">
location.href = "#tab1";
</script>
	<c:if test="${not empty authentication}">
		<div class="tabmenu">
  		<ul>
    		<li id="tab1" class="btnCon"><a class="btn first" href="#tab1">회원 정보</a>
	      		<div class="tabCon">
	      			<h1>${authentication.userId}님 환영합니다.</h1>
		
						<table border="1">
						
						<tr>
							<th>이름</th>
							<th>${Member.name}</th>
						</tr>
						<tr>
							<th>아이디</th>
							<th>${authentication.userId}</th>
						</tr>
						<tr>
							<th>전화번호</th>
							<th>${authentication.phone}</th>
						</tr>
						<tr>
							<th>이메일</th>
							<th>${authentication.email}</th>
						</tr>
						
					
					</table>
	      		
	      		</div>
    		</li>
    		
		    <li id="tab2" class="btnCon"><a class="btn" href="#tab2">회원정보 수정</a>
				<div class="tabCon" >
				
					<div class="button-7">
						<div class="eff-7"></div>
						<a href="/member/update-password-form">비밀번호 변경</a>
					</div>
					
					<div class="button-7">
						<div class="eff-7"></div>
						<a href="/member/update-name-form">이름 변경</a>
					</div>
					
					<div class="button-7">
						<div class="eff-7"></div>
						<a href="/member/update-phone-form">전화번호 변경</a>
					</div>
					
					<div class="button-7">
						<div class="eff-7"></div>
						<a href="/member/update-email-form">이메일 변경</a>
					</div>

				</div>
		    </li>    

		    <li id="tab3" class="btnCon"><a class="btn" href="#tab3">회원 탈퇴</a>
      			<div class="tabCon">
      			
      				<div class="button-2">
					    <div class="eff-2"></div>
					    <a href="/member/delete-form">회원 탈퇴하기</a>
				  	</div>
      			</div>
		    </li>
		</ul>
		</div>
	</c:if>



</body>
</html>