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

	<script type="text/javascript">
		
		let onLogin = '<c:out value='${onLogin}'/>';
		
		let recipeIdx = new Array();
		let recipeImg = new Array();
		let recipeType = new Array();
		let recipeName = new Array();
		
		let caloryArr = new Array();
		let carbohydrateArr = new Array();
		let proteinArr = new Array();
		let fatArr = new Array();
		let natriumArr = new Array();
		let ingredientsArr = new Array();
		
		let manual1 = new Array();
		let manual2 = new Array();
		let manual3 = new Array();
		let manual4 = new Array();
		let manual5 = new Array();
		let manual6 = new Array();
		let manual7 = new Array();
		let manual8 = new Array();
		let manual9 = new Array();
		let manual10 = new Array();
		let manual11 = new Array();
		let manual12 = new Array();
		let manual13 = new Array();
		let manual14 = new Array();
		let manual15 = new Array();
		let manual16 = new Array();
		let manual17 = new Array();
		let manual18 = new Array();
		let manual19 = new Array();
		let manual20 = new Array();
		
		let manualImg1 = new Array();
		let manualImg2 = new Array();
		let manualImg3 = new Array();
		let manualImg4 = new Array();
		let manualImg5 = new Array();
		let manualImg6 = new Array();
		let manualImg7 = new Array();
		let manualImg8 = new Array();
		let manualImg9 = new Array();
		let manualImg10 = new Array();
		let manualImg11 = new Array();
		let manualImg12 = new Array();
		let manualImg13 = new Array();
		let manualImg14 = new Array();
		let manualImg15 = new Array();
		let manualImg16 = new Array();
		let manualImg17 = new Array();
		let manualImg18 = new Array();
		let manualImg19 = new Array();
		let manualImg20 = new Array();
		
		<c:forEach var="recipe" items="${Recipes}">
			recipeIdx.push('${recipe.rcpSeq}');
			recipeImg.push('${recipe.attFileNoMk}');
			recipeType.push('${recipe.rcpPat2}');
			recipeName.push('${recipe.rcpNm}');
			caloryArr.push('${recipe.infoEng}');
			carbohydrateArr.push('${recipe.infoCar}');
			proteinArr.push('${recipe.infoPro}');
			fatArr.push('${recipe.infoFat}');
			natriumArr.push('${recipe.infoNa}');
			ingredientsArr.push('${recipe.rcpPartsDtls}');
			// 줄바꿈문자 제거함
			manual1.push('${recipe.manual1}');
			manual2.push('${recipe.manual2}');
			manual3.push('${recipe.manual3}');
			manual4.push('${recipe.manual4}');
			manual5.push('${recipe.manual5}');
			manual6.push('${recipe.manual6}');
			manual7.push('${recipe.manual7}');
			manual8.push('${recipe.manual8}');
			manual9.push('${recipe.manual9}');
			manual10.push('${recipe.manual10}');
			manual11.push('${recipe.manual11}');
			manual12.push('${recipe.manual12}');
			manual13.push('${recipe.manual13}');
			manual14.push('${recipe.manual14}');
			manual15.push('${recipe.manual15}');
			manual16.push('${recipe.manual16}');
			manual17.push('${recipe.manual17}');
			manual18.push('${recipe.manual18}');
			manual19.push('${recipe.manual19}');
			manual20.push('${recipe.manual20}');
			// 줄바꿈문자 제거함!
		
			manualImg1.push('${recipe.manualImg01}');
			manualImg2.push('${recipe.manualImg02}');
			manualImg3.push('${recipe.manualImg03}');
			manualImg4.push('${recipe.manualImg04}');
			manualImg5.push('${recipe.manualImg05}');
			manualImg6.push('${recipe.manualImg06}');
			manualImg7.push('${recipe.manualImg07}');
			manualImg8.push('${recipe.manualImg08}');
			manualImg9.push('${recipe.manualImg09}');
			manualImg10.push('${recipe.manualImg10}');
			manualImg11.push('${recipe.manualImg11}');
			manualImg12.push('${recipe.manualImg12}');
			manualImg13.push('${recipe.manualImg13}');
			manualImg14.push('${recipe.manualImg14}');
			manualImg15.push('${recipe.manualImg15}');
			manualImg16.push('${recipe.manualImg16}');
			manualImg17.push('${recipe.manualImg17}');
			manualImg18.push('${recipe.manualImg18}');
			manualImg19.push('${recipe.manualImg19}');
			manualImg20.push('${recipe.manualImg20}');
		</c:forEach>
		
	</script>


	<div class="recipe-page">

		<div class="container">

			<div class="nutrient">
				<div class="nutrient-title">영양성분</div>
				<div class="nutrient-detail"></div>
			</div>

			<div class="ingredients">
				<div class="ingredients-title">재료</div>
				<div class="ingredients-detail"></div>
			</div>

		</div>

		<div class="scrap" style=" cursor:pointer">
			<i class="far fa-bookmark"></i>
		</div>

		<div class="share"></div>

		<div class="cooking-method">
			<div class="cooking-method-title">조리방법</div>
			<div class="cooking-method-detail"></div>
		</div>

		<div class="reply-list">
			<table class="reply-list-table">
				<thead>
					<tr>
						<th>No.</th>
						<th>작성자</th>
						<th>한 줄 평</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="comment" items="${Comments}">
						<tr class="reply-detail">
							<td class="reply-detail-num">${comment.reviewNo}</td>
							<td class="reply-detail-user">${comment.userId}</td>
							<td class="reply-detail-contests">${comment.reviewContents}</td>
							<td class="reply-detail-date">${comment.reviewDate}</td>
						</tr> 
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="reply-form" >
			<input class="reply-text" placeholder="한 줄 평을 입력해주세요">
			<a class="reply-submit">등록</a>
		</div>
		

	</div>

	
	<%@ include file="/WEB-INF/views/include/foot.jsp"%>
	<script type="text/javascript" src = "/resources/js/recipePage/recipePage.js"></script> 
</body>
</html>