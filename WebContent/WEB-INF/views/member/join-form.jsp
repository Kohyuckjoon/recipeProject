<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp" %>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
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
  color:red;
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

<div class="join-page">
  <div class="form">
    <form class="register-form" action="/member/join" method="post" id="frm_join" >
      <input type="text" name="userId" id="userId" size="10"
      	<c:if test="${empty joinFailed.userId}">
	           	  	value="${joinForm.userId}"	
	    </c:if>
      placeholder="ID" required/>
      
      <button type="button" id="btnIdCheck">ID 중복체크</button>
      	<span id="idCheck"  class="valid-msg" >
	        <c:if test="${not empty joinFailed.userId}">
		       	사용 불가능한 아이디 입니다.
		    </c:if>
        </span>
        
      <p></p>
      
      <input type="password" name="password" id="password"   
	      <c:if test="${empty joinFailed.password}">
		  	value="${joinForm.password}"	
		  </c:if>
     placeholder="영어,숫자,특수문자 조합의 8~14자의 문자열" required/>
      
      <span id="pwCheck" class="valid-msg">
	      <c:if test="${not empty joinFailed.password}">
		   	영어,숫자,특수문자 조합의 8~14자의 문자열
		  </c:if>
      </span>
      
      <input type="text" name="name" id="username" placeholder="2자 이상 6자 미만의 한글 이름" 
      		<c:if test="${empty joinFailed.name}">
		  		value="${joinForm.name}"	
		 	</c:if>
      required/>
      
      <span id="nameCheck" class="valid-msg">
	      <c:if test="${not empty joinFailed.name}">
		   	2자 이상 6자 미만의 한글 이름span
		  </c:if>
      </span>
      
      
      <input type="tel" name="phone" id="phone" size="10" placeholder="0100000000"  
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
      
      <button>가입하기</button>
      <p class="message">이미 회원가입 되어있으신가요? <a href="member/login">로그인하러 가기</a></p>
    </form>
  </div>
</div>

 <script type="text/javascript" src="/resources/js/member/joinForm.js"></script>
</body>
</html>