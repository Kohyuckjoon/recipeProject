<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="../resources/css/mainPage.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="resources/css/include/all.css">
<link rel="stylesheet" href="resources/css/include/reset.css">
<style type="text/css">
/* div {
	box-shadow: 0 0 2px black;
} */

input[type="text"] {
	width: 130px;
}

.topBlank {
	height: 13vh;
}

.middleBlank {
	float: left;
	height: 15vh;
	width: 2%;
}

.checkBox {
	height: 15vh;
}

.sideBar {
	float: right;
	height: 45vh;
	width: 10%;
}

.sideBarRight label {
	float: right;
}

.sideBarGender label{
	float: left;
}

/* .sideBarAreaLeft{
	float: left;
	width: 30%;
}

.sideBarAreaRight{
	float: right;
	width: 70%;
} */

/* position: relative;
	width: 50vw;
	height: 25vw;
	max-height:78vh;
	left: 25vw;
	background-color: rgba(0,0,0,0.5); */
.calorie {
	float: left;
	height: 15vh;
	width: 7%;
}

.calorielabel {
	background-color: white;
	margin: 7%;
}

.calorieCheckbox {
	margin: 10%;
}

.salt {
	float: left;
	height: 15vh;
	width: 7%;
}

.saltLabel {
	background-color: white;
	margin: 7%;
}

.saltCheckbox {
	margin: 10%;
}

.fat {
	float: left;
	height: 15vh;
	width: 7%;
}

.fatLabel {
	background-color: white;
	margin: 7%;
}

.fatCheckbox {
	margin: 10%;
}

.protein {
	float: left;
	height: 15vh;
	width: 7%;
}

.proteinLabel {
	background-color: white;
	margin: 7%;
}

.proteinCheckbox {
	margin: 10%;
}

.search {
	float: left;
	height: 50%;
	width: 7%;
}

.searchLabel {
	background-color: white;
	margin: 7%;
}

.searchCheckbox {
	margin: 10%;
	float: right;
	position: absolute, bottom:0, right:0;
}

.calculateResult{
	float: right;
}

/* ----------------------------------------------------- */
/* .calorieCheckbox {
	margin-right: 20px;
	border: 1px solid red;
	float: left;
	width: 5%;
	background: white;
}

.saltCheckbox {
	margin-right: 20px;
	border: 1px solid red;
	float: left;
	width: 5%;
	background: white;
}

.fatCheckbox {
	margin-right: 20px;
	border: 1px solid red;
	float: left;
	width: 5%;
	background: white;
}

.proteinCheckbox {
	margin-right: 20px;
	border: 1px solid red;
	float: left;
	width: 5%;
	background: white;
}

.sideInfoBar {
	border: 1px solid red;
	float: right;
	padding: 10px;
	margin-left: 10px;
} */
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>


	<div>
		<div class="topBlank"></div>
		<!-- 칼로리, 나트륨, 지방, 단백질 선택박스 표시 -->
		<div class="checkBox">
			<div class="calorie">
				<div>
					<div class="calorielabel">
						<label>칼로리(cal)</label>
					</div>

					<div class="calorieCheckbox">
						0~300<input type="checkbox" name="calorie1" value=""><br>
						300~500<input type="checkbox" name="calorie2" value=""><br>
						500~700<input type="checkbox" name="calorie3" value=""><br>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="salt">
				<div>
					<div class="saltLabel">
						<label>나트륨(na)</label>
					</div>

					<div class="saltCheckbox">
						0~300<input type="checkbox" name="calorie1" value=""><br>
						300~500<input type="checkbox" name="calorie2" value=""><br>
						500~700<input type="checkbox" name="calorie3" value=""><br>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="fat">
				<div>
					<div class="fatLabel">
						<label>지방(g)</label>
					</div>
					<div class="fatCheckbox">
						0~300<input type="checkbox" name="calorie1" value=""><br>
						300~500<input type="checkbox" name="calorie2" value=""><br>
						500~700<input type="checkbox" name="calorie3" value=""><br>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="protein">
				<div>
					<div class="proteinLabel">
						<label>단백질(g)</label>
					</div>
					<div class="proteinCheckbox">
						0~300<input type="checkbox" name="calorie1" value=""><br>
						300~500<input type="checkbox" name="calorie2" value=""><br>
						500~700<input type="checkbox" name="calorie3" value=""><br>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="search">
				<div></div>
				<div>
					<div class="resetButtonBox">
						<input type='submit' value='초기화'>
					</div>
					<div class="searchButtonBox">
						<input type='submit' value='검 색'>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>
		</div>
	</div>

	<div class="sideBar">
		<div class="sideBarRight">
			<div class="sideBarGender">
				<!-- 라벨칸 -->
				<div>
					<label>&nbsp;&nbsp;&nbsp;성별 : </label>
				</div>
				<!-- 라디오박스칸 --> 
				<div>
					<input type="radio" name="gender" value="man">남
					<input type="radio" name="gender" value="woman" style="padding-left: 50%;">여 <br>
				</div>
			</div>
			<div>
				<label>나이 : <input type="text" name="age"></label><br>
			</div>
			<div>
				<label>키 : <input type="text" name="height"></label><br>
			</div>
			<div>
				<label>몸무게 : <input type="text" name="weight"></label><br>
			</div>
			<div class="calculateResult">
				<input type='submit' value='계 산'>
			</div>
		</div>
	</div>
</body>
</html>