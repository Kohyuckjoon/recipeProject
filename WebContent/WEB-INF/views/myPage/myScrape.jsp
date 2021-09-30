<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<style type="text/css">
html {
	width: 1800px;
	background-color: #ccdce7;
	margin-left: 70px;
}

.top {
	height: 100px;
}

.body {
	width: 1600px;
	display: inline-flex;
	flex-direction: column;
	margin-top: 100px;
}

.row {
	height: 400px;
	display: flex;
	margin-top: 1em;
	font-weight: bold;
	text-align: center;
}

.row>* {
	margin-right: 2em;
}

.upper-recipe {
	height: 70%;
	width: 20%;
	background-color: white;
}

.recipe-pic {
	margin-bottom: 1em;
	float: left;
	height: 80%;
	width: 100%;
}

.recipe-text>div {
	margin-bottom: 0.3px;
	font-weight: bold;
	font-family: 'Single Day', cursive;
}

.food-type {
	font-size: 12px;
	color: orange;
	margin-bottom: 20px;
}

.food-name{
	display: inline-block;
}

.cancel-btn{
	display: inline-block;
	float: right;
}

</style>
</head>
<body>

	<!-- 여기서부터 헤드 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>


	<!-- myPage 바디 -->

	<div class="top"></div>

		
	

		<div class="row">
			<c:forEach var="myRecipe" items="${myRecipes}">
				<div class="upper-recipe">
					<img src="${myRecipe.attFileNoMk}" class="recipe-pic">
					<div class="recipe-text">
						<div class="food-type">${myRecipe.rcpPat2}</div>
						<div class="food-name">${myRecipe.rcpNm}</div>
						<div class="cancel-btn">			
						<button onclick="cancel_myRecipe()"><img src="/resources/img/scrape_cancel.png" width="20px" height="20px"></button>
						</div>					
					</div>
				</div>
			</c:forEach>
		</div>

<script type="text/javascript">

function cancel_myRecipe() {
	 
	console.log("테스트 중");

	
}

</script>

	

	<%@ include file="/WEB-INF/views/include/foot.jsp"%>

</body>
</html>