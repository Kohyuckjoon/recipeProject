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

<link href="resources/css/board/board.css" rel="stylesheet"  type="text/css">
<style type="text/css">
.top{
height: 100px;
}
.info{font-size:2vw; border-bottom:1px solid}
.info span{padding-right: 3vw;}
.info li{font-size:1.5vw;}

.btn_section{
   padding-top:20px;
   flex-direction:row;
   justify-content:flex-end;
   width:50%;

}
.btn_section input{
 font-size:1.5vw;
 background-color: lightblue;
  color:white;
   }
.wrap_board{
   overflow:hidden;
   width:70%;
   left:30%;
}

.btn_down-file{margin-left:1%;   z-index:999;}
.article_content{min-height: 50vh; border-bottom: 1px solid;}
</style>
</head>
<body>
 <%@ include file="/WEB-INF/views/include/header.jsp" %> 
<div class="top"></div>
	
	
	<div class="content"> 
	<div class="tit">게시판 상세 글</div>
	
		<div class="info">
		<span>번호 : <c:out value="${datas.board.no}"/></span>
		<span>제목 : <c:out value="${datas.board.title}"/></span>
		<span>등록일 : <c:out value="${datas.board.regDate}"/></span>
		<span>작성자 : <c:out value="${datas.board.userId}"/></span>
		<span>조회수 : <c:out value="${datas.board.viewCount}"/></span>
	</div>
	<div class="info file_info">
		<c:if test="${not empty datas.files}">
			<ol>
				<c:forEach items="${datas.files}" var="file">
					<li><a href="${file.downloadLink}">${file.originFileName}</a></li>				
				</c:forEach>
			</ol>
		</c:if>
	</div>
	<div class="article_content">
		<pre><c:out value="${datas.board.content}"/></pre>
	</div>
	
</div>

	<a href="/board/board-update?no=${board.no}">게시글 수정</a>
	<a href="/board/board-delete?no=${board.no}">게시글 삭제</a>   
	<a href="/board/board-list">목록</a>     
	<!-- <button onclick = "location.href = '/board/board-list'">목록</button>   -->                
          
<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>