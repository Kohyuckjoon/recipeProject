<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/head.jsp" %>
<style type="text/css">
.valid-msg{
	display:block;
	color:red;	
	font-size:10px;
}

input{
	display:block;
	width:400px;
	border: none;
	outline: none;
}

tr>td:nth-child(1){
	background-color: red;
	color:white;
}

#Id{
	display: inline-block;
	width: 80%;
}

input[type=submit]{
	width: 100%;
}

</style>
</head>
<body>
<h1>회원 가입 양식</h1>
    <form action="/member/join" method="post" id="frm_join" >
     <table border="1">
        <tr>
           <td>ID : </td>
           <td >
           	  <input type="text" name="userId" id="userId" size="10" 
	           	  <c:if test="${empty joinFailed.userId}">
	           	  	value="${joinForm.userId}"	
	           	  </c:if>
           	  required />
           	  
           	  <button type="button" id="btnIdCheck">check</button>
           	  <span id="idCheck"  class="valid-msg" >
           	  	  <c:if test="${not empty joinFailed.userId}">
	           	  	이미 존재하는 아이디 입니다.
	           	  </c:if>
           	  </span>
           </td>
        </tr>
        <tr>
           <td>PASSWORD : </td>
           <td>
           	  <input type="password" name="password" id="password" placeholder="영어,숫자,특수문자 조합의 8글자 이상의 문자열입니다."  
           	  	<c:if test="${empty joinFailed.password}">
	           	  	value="${joinForm.password}"	
	           	</c:if>
           	  required/>
           	  <span id="pwCheck" class="valid-msg">
           	  	<c:if test="${not empty joinFailed.password}">
	           	  	비밀번호는 영어,숫자,특수문자 조합의 8글자 이상의 문자열입니다.
	           	</c:if>
           	  </span>
           </td>
        </tr>
        <tr>
           <td>휴대폰번호 : </td>
           <td>
           	  <input id="tell" type="tel" name="tell" placeholder="숫자만 입력하세요"  
           	  	<c:if test="${empty joinFailed.tell}">
	           	  	value="${joinForm.tell}"	
	           	</c:if>
           	  required/>
           	  <span  id="tellCheck" class="valid-msg">
           	  	<c:if test="${not empty joinFailed.tell}">
	           	  	전화번호는 9~11자리 숫자입니다. 
	           	</c:if>
           	  </span>
           </td>
        </tr>
        <tr>
           <td>EMAIL : </td>
           <td>
           	  <input type="email" name="email"  
           	  	<c:if test="${empty joinFailed.email}">
	           	  	value="${joinForm.email}"	
	           	</c:if>
           	  required/>
           </td>
        </tr>
        <tr>
           <td colspan="2">
              <input type="submit" value="가입" />
           </td>
       </tr>
   </table>
  </form>
   
 
 <script type="text/javascript" src="/resources/js/member/joinForm.js"></script>
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>