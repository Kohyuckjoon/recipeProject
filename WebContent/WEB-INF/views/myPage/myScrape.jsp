<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="../resources/css/myPage/myScrape.css" rel="stylesheet"  type="text/css">

</head>
<body>

	<!-- 여기서부터 헤드 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>


	<!-- myPage 바디 -->

	<div class="body">



		<div class="row">
			<c:forEach var="myRecipe" items="${myRecipes}">
				<div class="upper-recipe">
					<img src="${myRecipe.attFileNoMk}" class="recipe-pic">
					<div class="recipe-text">
						<div class="food-type">${myRecipe.rcpPat2}</div>
						<div class="food-name">${myRecipe.rcpNm}</div>
						<div class="cancel-btn">

							<form action="/myPage/cancelScrape" method="get">
								<input type="hidden" name="rcpSeq" value="${myRecipe.rcpSeq }" />
								<input class="cancel-img" type="image"
									src="/resources/img/scrape_cancel.png" />
							</form>

						</div>
					</div>
				</div>

			</c:forEach>
		</div>

	</div>




	<%@ include file="/WEB-INF/views/include/foot.jsp"%>


</body>
</html>