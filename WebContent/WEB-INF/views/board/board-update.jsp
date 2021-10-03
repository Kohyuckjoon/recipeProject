<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet" type="text/css">


<style type="text/css">



.top > div{
	height: 100px;
}
.tit{
	top:100px;
	position:relative;
	color:blue;
	font-weight:bold;
	font-size:2.3vw;
	text-align: center;
	
}
.info{
display:flex;
margin-top:200px;
font-size:1.3vw; 
border-bottom:1px solid;}
.info span{
padding-right: 3vw;
}
a{
	font-size:20px;
	background-color:lightblue;
}
.btn_section > input{
	position:relative;
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
	<!-- 게시판수정  -->
	<%-- 게시판 수정 세션값 담겨있는지 체크하는 거 퍼온내용
	<%
		// 세션에 값이 담겨있는지 체크
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		if(userID == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요')");
			script.println("location.href='login.jsp'");
			script.println("</script>");
		}
		int no = 0;
		if(request.getParameter("no") != null){
			no = Integer.parseInt(request.getParameter("no"));
		}
		if(no == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다')");
			script.println("location.href='bbs.jsp'");
			script.println("</script>");
		}
		//해당 'bbsID'에 대한 게시글을 가져온 다음 세션을 통하여 작성자 본인이 맞는지 체크한다
		BoardDao boardDao = new BoardDao().getBoard(no);
		if(!userID.equals(bbs.getUserID())){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다')");
			script.println("location.href='bbs.jsp'");
			script.println("</script>");
		}
	%>
	 --%>
	
	
<form action="/board/upload" method="post" enctype="multipart/form-data" class="update">
	<div class="content"> 
	<div class="tit">게시판 글 수정</div>
	
		<div class="info">
		<span>번호 : <c:out value="${datas.board.no}"/></span>
		<span>제목 : <input type="text" name="title" required="required" value="${datas.board.title}" /></span>
		<span>등록일 : <c:out value="${datas.board.regDate}"/></span>
		<span>작성자 : <c:out value="${datas.board.userId}"/></span>
		<span>조회수 : <c:out value="${datas.board.viewCount}"/></span>
	
	</div>
	
	
	<div class="article_content">
		<textarea name="content" required="required" maxlength="250" >${datas.board.content}</textarea>
	</div>
	
</div>

 	<div class="btn_section">
       	<input type="submit" value="수정완료"> 
       	<button type="reset" >다시 입력</button>   
          <button onclick = "location.href = '/board/board-list'">목록</button>         
    </div>    
    
   </form>
<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>