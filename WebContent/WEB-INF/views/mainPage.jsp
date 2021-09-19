<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="resources/css/index.css" rel="stylesheet"  type="text/css">
</head>
<body>
	
	<!-- 여기서부터 헤드 -->
	
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	
	<!-- ul과 li로 넣어도 댐 -->
	<div class="sideBar">

		<div class="sideBar-title">Most Popular</div>

		<div class="sideBar-body">

			<div class="most-popular-recipe-1">
				<div class="most-popular-recipe-1-pic"></div>
				<span class="most-popular-recipe-1-text">Lamb chops are such a simple...</span>
			</div>

			<div class="most-popular-recipe-2">
				<div class="most-popular-recipe-2-pic"></div>
				<span class="most-popular-recipe-2-text">Everyone loves a good lasagna...</span>
			</div>

			<div class="most-popular-recipe-3">
				<div class="most-popular-recipe-3-pic"></div>
				<span class="most-popular-recipe-3-text">Dakos Salad is Greek salad...</span>
			</div>

			<div class="most-popular-recipe-4">
				<div class="most-popular-recipe-4-pic"></div>
				<span class="most-popular-recipe-4-text">Pozole is a traditional soup...</span>
			</div>

		</div>

	</div>
	
	
	<!-- 여기서부터 바디 -->
	<div class="body">

		<div class="row-1">
			<div class="row-1-recipe-1">
				<div class="row-1-recipe-1-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-1-recipe-1_RCP_PAT2">DINNER</div>
					<div class="row-1-recipe-1_RCP_NM">Lamb Chops with Rosemary and Garlic</div>
					<div class="row-1-recipe-1_rating">★★★★★</div>
				</div>

			</div>
			
			<div class="row-1-recipe-2">
				<div class="row-1-recipe-2-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-1-recipe-2_RCP_PAT2">QUICK DINNER</div>
					<div class="row-1-recipe-2_RCP_NM">Lasagna</div>
					<div class="row-1-recipe-2_rating">★★★☆</div>
				</div>
			</div>

			<div class="row-1-recipe-3">
				<div class="row-1-recipe-3-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-1-recipe-3_RCP_PAT2">SALARDS</div>
					<div class="row-1-recipe-3_RCP_NM">Dakos Salad</div>
					<div class="row-1-recipe-3_rating">★★★★☆</div>
				</div>
			</div>

			<div class="row-1-recipe-4">
				<div class="row-1-recipe-4-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-1-recipe-4_RCP_PAT2">GLUTEN-FREE-DINNER</div>
					<div class="row-1-recipe-4_RCP_NM">Pozole Rojo</div>
					<div class="row-1-recipe-4_rating">★★☆</div>
				</div>
			</div>
		</div>

	</div>
	
	<!-- https://openapi.foodsafetykorea.go.kr/api/9ee2439be26f471d9ffd/COOKRCP01/xml/1/1000/ -->
	
	<!-- 여기부턴 foot -->
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>

</body>
</html>