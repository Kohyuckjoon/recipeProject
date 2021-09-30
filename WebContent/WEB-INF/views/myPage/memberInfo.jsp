<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<c:if test="${empty authentication}">
	<c:redirect  url="/member/login-form"/>
	</c:if>


	<c:if test="${not empty authentication}">
		<h1>${authentication.name}님 환영합니다.</h1>
		
		<table border="1">
		<tr>
			<th>회원 탈퇴하기</th>
			<th><button onclick="location.href='/member/delete-form'">회원 탈퇴</button></th>
		</tr>
		<tr>
			<th>개인정보 수정</th>
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
	
	</table>
	</c:if>



</body>
</html>