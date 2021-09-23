<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/mainPage.css" rel="stylesheet"  type="text/css">
</head>
<body>
	
	<!-- 여기서부터 헤드 -->
	
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	

	<!-- ul과 li로 넣어도 댐 -->
	<div class="sideBar">

		<div class="sideBar-title">Best Recipes</div>
		<div class="sideBar-body">
				<c:forEach var="recipe" items="${Recipes}" begin= "31" end="36">
					<div class="best-recipe">
						<img class="best-recipe-pic" src="${recipe.attFileNoMk}">
						<div class="best-recipe-text">
							<div class="most-popular-recipe-text" >${recipe.rcpNm}</div>
							<div class="food-star">★★★★★</div>
						</div>
					</div>
				</c:forEach>

		</div>

	</div>
	
	<!-- 여기서부터 바디 -->
	<div class="body">

		<%
		int begin = (int) request.getAttribute("pageNumber")*36 - 35;
		int end = (int) request.getAttribute("pageNumber")*36 - 32;
		%>
		<c:forEach begin="0" end="8">
			<div class="row">
				<c:forEach var="recipe" items="${Recipes}" begin="<%=begin%>" end="<%=end%>">
					<div class="upper-recipe">
						<img src="${recipe.attFileNoMk}" class="recipe-pic">
						<div class="recipe-text">
							<div class="food-type">${recipe.rcpPat2}</div>
							<div class="food-name">${recipe.rcpNm}</div>
							<span class="food-star">★★★★★</span>
						</div>
					</div>
				</c:forEach>
			</div>
			<%begin += 4; end += 4; %>
		</c:forEach>

	</div>

	<!-- 스코프 문제 -->
	<!-- 페이지 이동 기능 -->
	<div class = "page">
	<% int pageNum = 0;%>
		<table>
			<tr>
				<td class = "arrow"><i class="fas fa-angle-double-left"></i></td>
				<td class = "blank"></td>
				<td class = "arrow"><i class="fas fa-angle-left"></i></td>
				
				<c:forEach begin= "0" end="9">
					<% pageNum += 1;%>
					<td class = "blank"> </td>
					<td class = "page-number-<%=pageNum%>"><%=pageNum%></td>
				</c:forEach>
				
				<td class = "blank"> </td>
				<td class = "arrow"><i class="fas fa-angle-right"></i></td>
				<td class = "blank"></td>
				<td class = "arrow"><i class="fas fa-angle-double-right"></i></td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	<% int step = 0;%>
	
	<c:forEach begin= "0" end="9">
		<% step += 1;%>
		document.querySelector(".page-number-<%=step%>").addEventListener('click', () => {
			<%-- <c:set scope = "session" var="pageNumber" value = "<%=step%>"/> --%>
			location.href="/mainPage/<%=step%>";
		});
	</c:forEach>
	
	</script>

	<!-- 여기부턴 foot -->
	
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
	
	<!-- <script type="text/javascript" src = "/resources/js/mainPage/mainPage.js"></script> -->
</body>
</html>