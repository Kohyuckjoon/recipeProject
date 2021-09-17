<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.tit{display:block; width:50px;}
.valid-msg{color:red; font-size:0.5vw;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/include/head.jsp" %>

<form action="/member/login" method="post">

<c:if test="${not empty param.err}">
<span class="valid-msg">아이디나 비밀번호를 확인하세요.</span>
</c:if>

<span class='tit'>ID : </span>
<input type="text" name="userId" id="userId">
<span class='tit'>Password : </span>
<input type="password" name="password" id="password">
<button>로그인</button>
</form>

</body>
</html>