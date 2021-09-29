<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="../resources/css/mainPage.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
.top{
	height: 100px;
}

.recipe_page{
	width: 80vw;
	display: flex;
	flex-wrap: wrap;
	background-color: white;
	padding: 5vw;
}

.food_img{
	display: inline-block;
	width: 37vw;
	height: 37vw;
	background-color: silver;
}

.container{
	display: flex;
	flex-direction: column;
	width: 31vw;
	margin: 0 1vw 0 5vw;
}

.food_category{
	color: orange;
	height: 1.7vw;
}

.food_name{
	height: 4vw;
	font-weight: bold;
}

.nutrition-fact_tlt{
	height: 3vw;
}

.nutrition-fact{
	height: 10vw;
}

.ingredients_tlt{
	height: 3vw;
}

.ingredients{

}

.recipe_tlt{
	width: 100%;
	font-size: 2vw;
	margin: 5vw 0 3vw 0;
}

.recipe{
	width: 100%;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="top"></div>
<div class="recipe_page">
	<div class="food_img"></div>
	
	<div class="container">
		<div class="food_category">-밥-</div>
		<div class="food_name">칼륨 듬뿍 고구마죽</div>
		
		<div class="nutrition-fact_tlt">영양성분</div>
		<div class="nutrition-fact"></div>
		
		<div class="ingredients_tlt">재료</div>
		<div class="ingredients"></div>
	</div>
	
	<div class="scrap"></div>
	<div class="share"></div>
	
	<div class="recipe_tlt">조리 방법</div>
	<div class="recipe">1.</div>
	
	<div class="reply"></div>
	
</div>
<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>