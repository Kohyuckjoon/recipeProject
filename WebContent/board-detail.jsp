<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">
<link href="resources/css/board/board-detail.css" rel="stylesheet"  type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>  

<div id="wrap">
    
    <div id="board">
        <table class="boardForm">
        
            <tr>
                <td id="date">작성일</td>
                <td>${datas.board.date}</td>
            </tr>
            <tr>
                <td id="id">작성자</td>
                <td>${datas.board.id}</td>
            </tr>
            <tr>
                <td id="title">제 목</td>
                <td>
                    ${datas.board.title}
                </td>        
            </tr>
            <tr>
                <td id="content">내 용 </td>
                <td>
                  ${datas.board.content}
                </td>        
            </tr>
            <tr>
      	 	 <td id = "file">파 일</td>
      	 	 <td>
      	 	 <div class="info file_info">
			<c:if test="${not empty datas.files}">
			<ol>
					<c:forEach items="${datas.files}" var="file">
					<li><a href="${file.downloadLink}">${file.originFileName}</a></li>				
				</c:forEach>
			</ol>
		</c:if>
	</div>  
      	 	 </td>
            </tr>
    
            <tr align="center" valign="middle">
                <td colspan="5">
                    <input type="button" value="수정" >
                    <input type="button" value="삭제" >
                    <input type="button" value=답글 >    
                    <input type="button" value="목록" 
                        onclick="board-list.jsp">            
                </td>
            </tr>
        </table>
    </div>
</div>    
<!-- 여기부턴 foot -->
	 <%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>