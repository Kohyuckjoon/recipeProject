<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
table.type11{
width: 96%;
text-align: center; 
border-spacing: 1px; 
line-height: 1.5; 
margin: 20px 10px;

}

table.type11 th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #4CAF50 ;
    
}
table.type11 td {
    width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}

    
</style>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link href="../resources/css/include/header.css" rel="stylesheet"  type="text/css">
<link href="../resources/css/myPage/myPage.css" rel="stylesheet"  type="text/css">
<link href="../resources/css/myPage/memberInfo.css" rel="stylesheet"  type="text/css">
</head>

<body>

	<c:if test="${empty authentication and empty Storage}">
	<c:redirect  url="/member/login-form"/>
	</c:if>

	<c:if test="${not empty authentication or not empty session}">
		
		<div class="tabmenu">
  		<ul>
    		<li id="tab1" class="btnCon"><a class="btn first" href="#tab1">회원 정보</a>
	      		<div class="tabCon">
	      			
						<table class="type11">
						
						<thead>
							<tr>
								<th colspan="2">${authentication.name}님 환영합니다.</th>
							</tr>
						</thead>
						<tbody>
						<tr>
							<td>이름</td>
							<td>${authentication.name}</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>${authentication.userId}</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>${authentication.phone}</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${authentication.email}</td>
						</tr>
						</tbody>
					
					</table>
	      		
	      		</div>
    		</li>
    		
		    <li id="tab2" class="btnCon"><a class="btn" href="#tab2">회원정보 수정</a>
				<div class="tabCon">
					
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
					    <div class="eff-2" style="position: absolute  top: 50%; left: 50%; transform: translate(-50%,-50%);"></div>
					    <a href="/member/delete-form">회원 탈퇴하기</a>
				  	</div>
      			</div>
		    </li>
		</ul>
		</div>
	</c:if>
	
	
	
	

 <script type="text/javascript" src="/resources/js/include/header.js"></script>
 <script type="text/javascript">
 location.href = "#tab1";
 </script>
 
</body>
</html>