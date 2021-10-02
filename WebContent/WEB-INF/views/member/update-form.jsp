<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="com.kh.recipe.member.model.dao.MemberDao" %>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.update-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  background: #ccdce7; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #76b852, #8DC26F);
  background: -moz-linear-gradient(right, #76b852, #8DC26F);
  background: -o-linear-gradient(right, #76b852, #8DC26F);
  background: linear-gradient(to left, #ccdce7, #ccdce7);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
</style>
</head>
<body>
	
	<c:if test="${not empty authentication}">
		<div class="update-page">
	  		<div class="form">
	  
		    <form class="update-memberinfo" action="/myPage/update-memberinfo" method="post">
			
				<input type="text" name="name" id="username" placeholder="ID"/>
		
				<input type="password" name="password" id="password" placeholder="Password"/>
			
				<input type="tel" name="phone" id="phone" size="10" placeholder=`${authentication.phone}`  
	
			     <c:if test="${empty joinFailed.tell}">
				 value="${joinForm.tell}"	
		  		 </c:if>
      			required/>
      <span  id="tellCheck" class="valid-msg">
	      <c:if test="${not empty joinFailed.tell}">
		   	전화번호는 9~11자리 숫자입니다. 
		  </c:if>
      </span>
      
      <input type="text" name="email" placeholder="Email address"  
	      <c:if test="${empty joinFailed.email}">
		  	value="${joinForm.email}"	
		  </c:if>
      required/>
			
			
			
			<h1 style >${authentication.name}님 환영합니다.</h1>
		
		<table border="1">
		
		<tr>
			<th>회원 탈퇴하기</th>
			<th><button onclick="location.href='/member/delete-form'">회원 탈퇴</button></th>
		</tr>
		
		<tr>
			<th>이름</th>
			<th>${authentication.name}</th>
		</tr>
	
		<tr>
			<th>아이디</th>
			<th>${authentication.userId}</th>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<th>${authentication.password}</th>
		</tr>
		
		<tr>
			<th>전화번호</th>
			<th>${authentication.phone}</th>
		</tr>
		
		<tr>
			<th>이메일</th>
			<th>${authentication.email}</th>
		</tr>
		
		<tr>
			<th>개인정보 수정하기</th>
			<th><button onclick="location.href='/member/update-form'">회원 정보 수정</button></th>
		</tr>
		
	</table>
			
			
			
			
			
			
			
			<button>회원 탈퇴</button>
			</form>
			
			<p class="message">회원 탈퇴 시 계정 데이터를 복구할 수 없습니다.</p>
			<a><button onclick="history.back()">뒤로가기</button></a>
			
			
			
	 		</div>
		</div>
	</c:if>



</body>
</html>