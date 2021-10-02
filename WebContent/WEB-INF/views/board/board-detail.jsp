<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet"
	type="text/css">


<style type="text/css">
.top{
height: 100px;
}
.tit{
	position:relative;
	color:blue;
	font-weight:bold;
	font-size:2.3vw;
	text-align: center;
	
}
.info{font-size:1.3vw; border-bottom:1px solid}
.info span{
padding-right: 3vw;
}

a{
	font-size:20px;
	background-color:lightblue;
}
button{
	position:relative;
	font-size:20px;
	background-color:lightblue;
}

.article_content{
min-height: 50vh; 
border-bottom: 1px solid;
font-size:2vw;
}
</style>
</head>
<body>
 <%@ include file="/WEB-INF/views/include/header.jsp" %> 
<div class="top"></div>
	
	
	
	<div class="tit"> ${datas.board.no }번 상세 글 보기</div>
	<div class="info">
		<span>번호 : <c:out value="${datas.board.no}"/></span>
		<span>제목 : <c:out value="${datas.board.title}"/></span>
		<span>등록일 : <c:out value="${datas.board.regDate}"/></span>
		<span>작성자 : <c:out value="${datas.board.userId}"/></span>
		<span>조회수 : <c:out value="${datas.board.viewCount}"/></span>
	</div>
	
	<div class="article_content">
		<pre><c:out value="${datas.board.content}"/></pre>
	</div>
	

	
	<a href="/board/board-list">[목록]</a>    
<c:if test="${board.userId == userId }"  >  <!--작성자와 수정하는 사람이 같아야 수정 삭제 버튼 보이게  -->
		  <button onclick = "location.href = '/board/board-update?no=${datas.board.no}'">[수정]</button>
		   <button onclick = "location.href = '/board/board-delete?no=${datas.board.no}'">[삭제]</button>   		 
 </c:if>     
          
<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>