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
		int begin = (int) session.getAttribute("sessionPageNumber") * 36 - 35;
		int end = (int) session.getAttribute("sessionPageNumber") * 36 - 32;
		%>

		<c:forEach begin="0" end="8">

			<div class="row">
				
			</div>

			<%begin += 4; end += 4; %>

		</c:forEach>


	</div>
	
	<script type="text/javascript">
	let recipeDetail = new Array();
	
	
	
	<c:forEach var="recipe" items="${Recipes}" begin="<%=begin%>" end="<%=end%>">
		recipeDetail.push("${recipe.rcpNm}");
	</c:forEach>
	 
	console.dir(recipeDetail);
	</script>
	
	
	
	
	
	
	
	
	
	
	
	<!-- 페이지 이동 기능 -->
	<div class = "page">
		<table>
			<tr>
				<td class = "arrow" class = "firstPage"><i class="fas fa-angle-double-left"></i></td>
				<td class = "blank"></td>
				<td class = "arrow" class = "prevPage"><i class="fas fa-angle-left"></i></td>
				<td class = "blank"> </td>
				<td class = "blank num"> </td>
				<td class = "arrow" class = "nextPage"><i class="fas fa-angle-right"></i></td>
				<td class = "blank"></td>
				<td class = "arrow" class = "lastPage"><i class="fas fa-angle-double-right"></i></td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
		let numberForPaging = (totalPage, viewPageNumbers, currentPage) => {
		
		this.totalPage = totalPage;
		// 1000/36 = 27.7
		this.currentPage = currentPage;
		this.viewPageNumbers = viewPageNumbers;
		let remainder = currentPage % viewPageNumbers;
		let firstPagerNum = currentPage - remainder + 1;
		let lastPagerNum = currentPage - remainder + viewPageNumbers;
		
		if(remainder == 0){
			firstPagerNum -= 10;
			lastPagerNum -= 10;
		}
		
		if(this.totalPage < lastPagerNum ){
			lastPagerNum = this.totalPage; 
		}
		
		return{
			totalPage,
			currentPage,
			viewPageNumbers,
			firstPagerNum,
			lastPagerNum
		}
		
	}
	
	let paging = null;
	let sPN = parseInt(sessionStorage.getItem('sessionPageNumber'));
	
	
	if(isNaN(sPN) == true) {
		paging = numberForPaging(28, 10, 1)
	} else {
		paging = numberForPaging(28, 10, sPN)
	}
	
	for(let i = paging.firstPagerNum; i < paging.lastPagerNum + 1; i++){
		let pageNumber = document.createElement('td');
		pageNumber.classList.add('page-' + i);
		pageNumber.append(i);
		document.querySelector('.num').before(pageNumber);
		
		document.querySelector('.page-' + i).addEventListener('click',() =>{
			sessionStorage.setItem('sessionPageNumber', i );
			location.href="/mainPage/clickedPage";
		});
		
	}
	</script>
	
	<!-- 여기부턴 foot -->
	
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
	
	<!-- <script type="text/javascript" src = "/resources/js/mainPage/mainPage.js"></script> -->

</body>
</html>