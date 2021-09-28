<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<link href="../resources/css/mainPage.css" rel="stylesheet" type="text/css">

<style type="text/css">

.top{
	height:100px;
}

</style>
</head>
<body>

<!-- 여기서부터 헤드 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	

	<!-- myPage 바디 -->

	<div class="top"></div>
	
	<c:forEach begin="0" end="0">

			<div class="row">
				<c:forEach var="myRecipe" items="${myRecipes}" >
					<div class="upper-recipe">
						<img src="${myRecipe.attFileNoMk}" class="recipe-pic">
						<div class="recipe-text">
							<div class="food-type">${myRecipe.rcpPat2}</div>
							<div class="food-name">${myRecipe.rcpNm}</div>
						</div>
					</div>
				</c:forEach>
			</div>

			

		</c:forEach>


</body>
</html>