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
.info{font-size:1.3vw; border-bottom:1px solid}
.info span{padding-right: 3vw;}
.info li{font-size:0.5vw;}

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

	
	
	<div class="content"> 
	<h2 class="tit">게시판 상세 글</h2>
	
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

 <div class="btn_section">
               <button onclick = "location.href = '/board/board-update'">수정하기</button>
               <button>삭제하기</button>
               <button onclick = "location.href = '/board/board-list'">목록</button>
                   
      </div>                      
          
<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>