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
.reply_list{
	width: 100%;
	position:relative;
    left: 50%;
    transform: translateX(-50%);
    margin-top: 30px;
}

.reply_list table{
	width:100%;
	
}

.reply_list tr {
	border-bottom :1px solid #999;
}

.reply_list th,
.reply_list td{
	text-align: center;
}

.reply_list tbody tr td:nth-child(2){
	text-align: left;
}

.replt_form{
	margin-top: 3vw;
}

#form{
	width: 70vw;
	height: 7vw;
}

#submit{
	width: 8.5vw;
	height: 7vw;
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
 <!--작성자와 수정하는 사람이 같아야 수정 삭제 버튼 보이게  -->
		  <button onclick = "location.href = '/board/board-update?no=${datas.board.no}'">[수정]</button>
		   <button onclick = "location.href = '/board/board-delete?no=${datas.board.no}'">[삭제]</button>   		 
     
          
		<div class="reply_list">
			<table>
				<thead>
					<tr>
						<th style="width: 10%;">No.</th>
						<th style="width: 60%;">내용</th>
						<th style="width: 15%;">작성자</th>
						<th style="width: 15%;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comment}" var="coment">
						<tr>
							<td>${comment.commentNo}</td>
							<td>${comment.commentContent}</td>
							<td>${comment.userId}</td>
							<td>${comment.commentDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="replt_form">
			<form action="/board/comment" method="post" enctype="multipart/form-data">
				<input id="form" type="text" placeholder="댓글 입력"> <input id="submit" type="submit" value="댓글 등록">
			</form>
		</div>

	

<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>