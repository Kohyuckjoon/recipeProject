<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/mainPage.css" rel="stylesheet" type="text/css">

<style type="text/css">

.top{

	height : 100px;
	
}

</style>

</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div class="top"></div>
	
	<div>
	<table class="sub_news" border="1" cellspacing="0"
		summary="게시판의 글제목 리스트">
		<caption>게시판 리스트</caption>
		<colgroup>
			<col>
			<col width="110">
			<col width="100">
			<col width="80">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>레시피번호</th>
				<th>아이디</th>
				<th>댓글내용</th>
				<th>댓글작성날짜</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="reviewIndex">1</td>
				<td class="recipeIndex">3</td>
				<td class="id">pclass</td>
				<td class="reviewContents">asdas</td>
				<td class="date">2021/09/21</td>
				
			</tr>		
			<tr>
				<td class="reviewIndex">2</td>
				<td class="recipeIndex">7</td>
				<td class="id">pclass</td>
				<td class="reviewContents">asdasdass</td>
				<td class="date">2021/09/23</td>
				
			</tr>
			
		</tbody>
	</table>
	</div>
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>