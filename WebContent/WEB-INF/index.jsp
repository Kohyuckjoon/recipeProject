<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe</title>
<link href="resources/css/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/test.css" type="text/css">
</head>
<body>
	
	<!-- 여기서부터 헤드 -->
	<div class="head">
		<div class="title">RfDnH</div>
		<form class="pagebutton">
			<button class="mainPageButton">메인페이지</button>
			<button class="recipePageButton">다이어트 & 헬스 레시피</button>
			<button class="boardPageButton">자유게시판</button>
			<button class="myPageButton">마이페이지</button>
		</form>

		<form class="search-box" id="search_button">
			<button type="submit" form="search_button" class="btn-search">
				<i class="fas fa-search"></i>
			</button>
			<input type="text" name="search" class="input-search"
				placeholder="Type to Search..." id="search_keyword">
		</form>


		<div class="login">
			<form>
				<button type="submit">
					<i class="fas fa-user-circle"></i>
				</button>
			</form>
		</div>
	</div>


	<!-- ul과 li로 넣어도 댐 -->
	<div class="sideBar">

		<div class="sideBar-title">Most Popular</div>

		<div class="sideBar-body">

			<div class="most-popular-recipe-1">
				<div class="most-popular-recipe-1-pic"></div>
				<div class="most-popular-recipe-1-text">Lamb chops are such a simple...</div>
			</div>

			<div class="most-popular-recipe-2">
				<div class="most-popular-recipe-2-pic"></div>
				<div class="most-popular-recipe-2-text">Everyone loves a good lasagna...</div>
			</div>

			<div class="most-popular-recipe-3">
				<div class="most-popular-recipe-3-pic"></div>
				<div class="most-popular-recipe-3-text">Dakos Salad is Greek salad...</div>
			</div>

			<div class="most-popular-recipe-4">
				<div class="most-popular-recipe-4-pic"></div>
				<div class="most-popular-recipe-4-text">Pozole is a traditional soup...</div>
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

		<div class="row-2">
			<div class="row-2-recipe-1">
				<div class="row-2-recipe-1-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-1_RCP_PAT2">EASY BREAKFAST</div>
					<div class="row-2-recipe-1_RCP_NM">Spanish Style Migas with
						Fried Eggs</div>
					<div class="row-2-recipe-1_rating">★★★★☆</div>
				</div>

			</div>

			<div class="row-2-recipe-2">
				<div class="row-2-recipe-2-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-2_RCP_PAT2">FRENCH</div>
					<div class="row-2-recipe-2_RCP_NM">Classic Barnaise Sauce</div>
					<div class="row-2-recipe-2_rating">★★★☆</div>
				</div>
			</div>

			<div class="row-2-recipe-3">
				<div class="row-2-recipe-3-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-3_RCP_PAT2">QUICK DINNERS</div>
					<div class="row-2-recipe-3_RCP_NM">Beef Stroganoff</div>
					<div class="row-2-recipe-3_rating">★★★★</div>
				</div>
			</div>

			<div class="row-2-recipe-4">
				<div class="row-2-recipe-4-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-4_RCP_PAT2">Christmas Dinner</div>
					<div class="row-2-recipe-4_RCP_NM">Classic Rack of Lamb</div>
					<div class="row-2-recipe-4_rating">★★★★★</div>
				</div>
			</div>
		</div>

		<div class="row-3">
			<div class="row-3-recipe-1">
				<div class="row-3-recipe-1-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-1_RCP_PAT2">BLUEBERRY DESSERTS</div>
					<div class="row-3-recipe-1_RCP_NM">Ricotta and Summer Berry
						Parfaits</div>
					<div class="row-3-recipe-1_rating">★★☆</div>
				</div>

			</div>

			<div class="row-3-recipe-2">
				<div class="row-3-recipe-2-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-2_RCP_PAT2">CHRISTMAS DESSERTS</div>
					<div class="row-3-recipe-2_RCP_NM">Gingerbread House</div>
					<div class="row-3-recipe-2_rating">★★★</div>
				</div>
			</div>

			<div class="row-3-recipe-3">
				<div class="row-3-recipe-3-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-3_RCP_PAT2">EASY DESSERTS</div>
					<div class="row-3-recipe-3_RCP_NM">Baked Apples</div>
					<div class="row-3-recipe-3_rating">★★☆</div>
				</div>
			</div>

			<div class="row-3-recipe-4">
				<div class="row-3-recipe-4-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-4_RCP_PAT2">CHOCOLATE DESSERTS</div>
					<div class="row-3-recipe-4_RCP_NM">Brownie in a Mug</div>
					<div class="row-3-recipe-4_rating">★★★☆</div>
				</div>
			</div>
		</div>
		
		<div class="row-2">
			<div class="row-2-recipe-1">
				<div class="row-1-recipe-1-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-1_RCP_PAT2">DINNER</div>
					<div class="row-2-recipe-1_RCP_NM">Lamb Chops with Rosemary and Garlic</div>
					<div class="row-2-recipe-1_rating">★★★★☆</div>
				</div>

			</div>

			<div class="row-2-recipe-2">
				<div class="row-1-recipe-2-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-2_RCP_PAT2">QUICK DINNER</div>
					<div class="row-2-recipe-2_RCP_NM">Lasagna</div>
					<div class="row-2-recipe-2_rating">★★★☆</div>
				</div>
			</div>

			<div class="row-2-recipe-3">
				<div class="row-1-recipe-3-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-3_RCP_PAT2">SALARDS</div>
					<div class="row-2-recipe-3_RCP_NM">Dakos Salad</div>
					<div class="row-2-recipe-3_rating">★★★★</div>
				</div>
			</div>

			<div class="row-2-recipe-4">
				<div class="row-1-recipe-4-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-4_RCP_PAT2">GLUTEN-FREE-DINNER</div>
					<div class="row-2-recipe-4_RCP_NM">Pozole Rojo</div>
					<div class="row-2-recipe-4_rating">★★★★☆</div>
				</div>
			</div>
		</div>
		
		<div class="row-2">
			<div class="row-2-recipe-1">
				<div class="row-2-recipe-1-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-1_RCP_PAT2">EASY BREAKFAST</div>
					<div class="row-2-recipe-1_RCP_NM">Spanish Style Migas with Fried Eggs</div>
					<div class="row-2-recipe-1_rating">★★★★</div>
				</div>

			</div>

			<div class="row-2-recipe-2">
				<div class="row-2-recipe-2-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-2_RCP_PAT2">FRENCH</div>
					<div class="row-2-recipe-2_RCP_NM">Classic Barnaise Sauce</div>
					<div class="row-2-recipe-2_rating">★★★</div>
				</div>
			</div>

			<div class="row-2-recipe-3">
				<div class="row-2-recipe-3-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-3_RCP_PAT2">QUICK DINNERS</div>
					<div class="row-2-recipe-3_RCP_NM">Beef Stroganoff</div>
					<div class="row-2-recipe-3_rating">★★☆</div>
				</div>
			</div>

			<div class="row-2-recipe-4">
				<div class="row-2-recipe-4-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-2-recipe-4_RCP_PAT2">Christmas Dinner</div>
					<div class="row-2-recipe-4_RCP_NM">Classic Rack of Lamb</div>
					<div class="row-2-recipe-4_rating">★★★★☆</div>
				</div>
			</div>
		</div>

		<div class="row-3">
			<div class="row-3-recipe-1">
				<div class="row-3-recipe-1-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-1_RCP_PAT2">BLUEBERRY DESSERTS</div>
					<div class="row-3-recipe-1_RCP_NM">Ricotta and Summer Berry
						Parfaits</div>
					<div class="row-3-recipe-1_rating">★★★☆</div>
				</div>

			</div>

			<div class="row-3-recipe-2">
				<div class="row-3-recipe-2-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-2_RCP_PAT2">CHRISTMAS DESSERTS</div>
					<div class="row-3-recipe-2_RCP_NM">Gingerbread House</div>
					<div class="row-3-recipe-2_rating">★★★★☆</div>
				</div>
			</div>

			<div class="row-3-recipe-3">
				<div class="row-3-recipe-3-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-3_RCP_PAT2">EASY DESSERTS</div>
					<div class="row-3-recipe-3_RCP_NM">Baked Apples</div>
					<div class="row-3-recipe-3_rating">★★★★</div>
				</div>
			</div>

			<div class="row-3-recipe-4">
				<div class="row-3-recipe-4-ATT_FILE_NO_MK"></div>
				<div class="recipe-text">
					<div class="row-3-recipe-4_RCP_PAT2">CHOCOLATE DESSERTS</div>
					<div class="row-3-recipe-4_RCP_NM">Brownie in a Mug</div>
					<div class="row-3-recipe-4_rating">★★★★★</div>
				</div>
			</div>
		</div>

		

	</div>

	<!-- 여기부턴 foot -->
	<div class="foot">
		<div class="Copyright">Copyright © 1992-2021 HSJ All Right
			Reserved</div>
	</div>

</body>
</html>