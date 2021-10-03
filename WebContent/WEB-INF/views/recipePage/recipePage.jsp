<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="../resources/css/recipePage/recipePage.css" rel="stylesheet" type="text/css">
<style type="text/css">

.top{
	height: 100px;
}

.recipe_page{
	width: 80vw;
	display: flex;
	flex-wrap: wrap;
	background-color: white;
	padding: 7vw;
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

.nutrition-fact_tit{
	height: 3vw;
}

.nutrition-fact{
	height: 10vw;
}

.ingredients_tit{
	height: 3vw;
}

.ingredients{

}

.scrap{
	height: 5vw;
}

.scrap i{
	font-size: 5vw;
}

.recipe_tit{
	width: 100%;
	font-size: 2vw;
	margin: 9vw 0 3vw 3vw;
}

.recipe{
	width: 100%;
	padding: 3vw;
	margin-bottom: 13vw
}

.reply_list{
	width: 100%;
	position:relative;
    left: 50%;
    transform: translateX(-50%);
}

.reply_list table{
	width:100%;
	
}

.reply_list tr {
	border-bottom :1px solid #999;
}

.reply_list th,
.reply_list td{
	text-align: center;
}

.reply_list tbody tr td:nth-child(2){
	text-align: left;
}

.replt_form{
	margin-top: 3vw;
}

#form{
	width: 70vw;
	height: 7vw;
}

#submit{
	width: 8.5vw;
	height: 7vw;
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
		
		<div class="nutrition-fact_tit">영양성분</div>
		<div class="nutrition-fact"></div>
		
		<div class="ingredients_tit">재료</div>
		<div class="ingredients"></div>
	</div>
	
	<div class="scrap">
		<i class="far fa-bookmark"></i>
	</div>
	<div class="share"></div>
	
	<div class="recipe_tit">조리 방법</div>
	<div class="recipe">
		<pre>1.
2.
3.
4.
5.</pre>
	</div>
	
	<div class="reply_list">
		<table>
			<thead>
				<tr>
					<th style="width:10%;">No.</th>
					<th style="width:60%;">내용</th>
					<th style="width:15%;">작성자</th>
					<th style="width:15%;">작성일</th>
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
			<input id="form" type="text" placeholder="댓글 입력">
			<input id="submit" type="submit" value="댓글 등록">
		</form>
	</div>
	
</div>

<%@ include file="/WEB-INF/views/include/foot.jsp" %>
</body>
</html>