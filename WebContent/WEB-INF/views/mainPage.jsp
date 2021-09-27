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


	<!-- 페이지 이동 기능 -->
	<div class = "page">
		<table>
			<tr>
				<td class = "arrow"><i class="fas fa-angle-double-left"></i></td>
				<td class = "blank"></td>
				<td class = "arrow"><i class="fas fa-angle-left"></i></td>
				<td class = "blank"> </td>
				
				
				
				<td class = "blank num"> </td>
				<td class = "arrow"><i class="fas fa-angle-right"></i></td>
				<td class = "blank"></td>
				<td class = "arrow"><i class="fas fa-angle-double-right"></i></td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	let totalPage = 28
	// 1000/36 = 27.7
	let currentPage = 1
	let viewPageNumbers = 10
	let remainder = currentPage % viewPageNumbers
	let firstPagerNum = currentPage - remainder + 1
	let lastPagerNum = currentPage - remainder + viewPageNumbers
		
	if(totalPage < lastPagerNum){
		totalPage = lastPagerNum
	}
	
	for(let i = firstPagerNum; i < lastPagerNum; i++){
		let pageNumber = document.createElement('td');
		pageNumber.append(i);
		document.querySelector('.num').before(pageNumber);
		
	}
	
	</script>
	
	
	<!-- 
	데이터셋이나 속성값에 넣자
	el-jstl 동작 시점이 다르니까, 속성값만 미리 넣어놓자
	자바스크립트로 통일시키자.  -->
	


	<!-- 여기부턴 foot -->
	
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
	
	<script type="text/javascript" src = "/resources/js/mainPage/mainPage.js"></script>
</body>
</html>