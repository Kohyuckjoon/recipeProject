<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="../resources/css/recipePage/recipePage.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="recipe_page">

		<img class="food_img" src="http://www.foodsafetykorea.go.kr/uploadimg/cook/10_00017_1.png"></img>

		<div class="container">
			<div class="food_category">-밥-</div>
			<div class="food_name">칼륨 듬뿍 고구마죽</div>

			<div class="nutrition_fact">
				<div class = "nutrition_fact_title">영양성분</div>
				<div class = "nutrition_fact_detail">
					<div class = "calory">&#x25C9 열량 : 1</div>
					<div class = "carbohydrate">&#x25C9 탄수화물 : 2</div>
					<div class = "protein">&#x25C9 단백질 : 3</div>
					<div class = "fat">&#x25C9 지방 : 4</div>
					<div class = "natrium ">&#x25C9 나트륨 : 5</div>
				</div>
			</div>

			<div class="ingredients">
				<div class="ingredients_title">재료</div>
				<div class="ingredients_detail">
					<div class="ingredients_detail_1">&#x25C9 고구마죽 고구마 100g(2/3개)</div>
					<div class="ingredients_detail_2">&#x25C9 설탕 2g(1/3작은술)</div>
					<div class="ingredients_detail_3">&#x25C9 찹쌀가루 3g(2/3작은술)</div>
					<div class="ingredients_detail_4">&#x25C9 물 200ml(1컵)</div>
					<div class="ingredients_detail_5">&#x25C9 잣 8g(8알)</div>
				</div>
			</div>
			
		</div>

		<div class="scrap">
			<i class="far fa-bookmark"></i>
		</div>
		
		<div class="share"></div>

		<div class="cooking_method">
			<div class="cooking_method_title">조리방법</div>
			<img class="cooking_method_img" src="http://www.foodsafetykorea.go.kr/uploadimg/cook/20_00017_1.png"></img>
			<div class="cooking_method_detail">1. 고구마는 깨끗이 씻어서 껍질을 벗기고 4cm 정도로 잘라준다.a</div>
			<img class="cooking_method_img" src="http://www.foodsafetykorea.go.kr/uploadimg/cook/20_00017_2.png"></img>
			<div class="cooking_method_detail">2. 찜기에 고구마를 넣고 20~30분 정도 삶아 주고, 블렌더나 체를 이용하여 잘 으깨어 곱게 만든다.b</div>
			<img class="cooking_method_img" src="http://www.foodsafetykorea.go.kr/uploadimg/cook/20_00017_3.png"></img>
			<div class="cooking_method_detail">3. 고구마와 물을 섞어 끓이면서 찹쌀가루로 농도를 맞추고 설탕을 넣어 맛을 낸다.c</div>
			<div class="cooking_method_detail">4. 잣을 팬에 노릇하게 볶아 다져서 고구마 죽에 섞는다. 기호에 따라 고구마를 튀겨 얹어 먹어도 좋다.</div>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<div class="reply_list">
			<table>
				<thead>
					<tr>
						<th style="width: 10%;">No.</th>
						<th style="width: 60%;">내용</th>
						<th style="width: 15%;">작성자</th>
						<th style="width: 15%;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reviews}" var="review">
						<tr>
							<td>${review.reviewNo}</td>
							<td>${review.reviewContents}</td>
							<td>${review.userId}</td>
							<td>${review.reviewDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="replt_form">
			<form>
				<input id="form" type="text" placeholder="댓글 입력"> <input id="submit" type="submit" value="댓글 등록">
			</form>
		</div>

	</div>

	<%@ include file="/WEB-INF/views/include/foot.jsp"%>
</body>
</html>