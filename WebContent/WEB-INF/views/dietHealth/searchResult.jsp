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

.blank {
	float: left;
	width: 7%;
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

.sideBarGender label {
	float: left;
}

.calorie {
	float: left;
	height: 15vh;
	width: 7%;
}

.calorielabel {
	font-size: 110%;
	margin: 5%;
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
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
	font-size: 110%;
	margin: 5%;
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
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
	font-size: 110%;
	margin: 5%;
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
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
	font-size: 110%;
	margin: 5%;
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
}

.proteinCheckbox {
	margin: 10%;
}

.search {
	float: left;
	height: 50%;
	width: 7%;
	padding: 1%;
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

.calculateResult {
	float: right;
}

.checkBoxStyle1 {
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
	margin: 5%;
}

.checkBoxStyle2 {
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
	margin: 5%;
}

.checkBoxStyle3 {
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
	margin: 5%;
}

.checkBoxStyle4 {
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
	margin: 5%;
}

.button {
	background: #fff;
	border: none;
	padding: 2px;
	cursor: pointer;
	display: block;
	position: relative;
	overflow: hidden;
	transition: all .35s ease-in-out .35s;
	margin: 0 auto;
	width: 85%;
	text-align: center;
	
}

span {
	display: flex;
	padding: 15px;
	background: #fff;
	z-index: 100;
	position: relative;
	transition: all .35s ease-in-out .35s;
	text-align: center;
}

.button:hover span {
	background: #36B4C7;
	color: #fff;
	transition: all .35s ease-in-out .35s;
}

.button:after {
	bottom: -100%;
	right: -100%;
	content: "";
	width: 100%;
	height: 100%;
	position: absolute;
	background: #36B4C7;
	transition: all .35s ease-in-out .5s;
}

.button:hover:after {
	right: 0;
	bottom: 0;
	transition: all ease-in-out .35s;
}

.button:before {
	top: -100%;
	left: -100%;
	content: "";
	width: 100%;
	height: 100%;
	position: absolute;
	background: #36B4C7;
	transition: all .35s ease-in-out .5s;
}

.button:hover:before {
	left: 0;
	top: 0;
	transition: all ease-in-out .35s;
}
</style>
</head>
<body oncontextmenu='return false' onselectstart='return false' ondragstart='return false'>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>



<form action="#" method="get">
	<div>
		<div class="topBlank"></div>
		<!-- 칼로리, 나트륨, 지방, 단백질 선택박스 표시 -->
		<div class="checkBox">
			<div class="calorie">
				<div>
					<div class="calorielabel">
						<label>칼로리(cal)</label>
					</div>
					<div class="blank"></div>

					<div class="checkBoxStyle1">
						<div class="calorieCheckbox">
							0~300<input type="checkbox" name="calorie1" value=""><br>
							300~500<input type="checkbox" name="calorie2" value=""><br>
							500~700<input type="checkbox" name="calorie3" value=""><br>
						</div>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="salt">
				<div>
					<div class="saltLabel">
						<label>나트륨(na)</label>
					</div>
					<div class="blank"></div>

					<div class="checkBoxStyle2">
						<div class="saltCheckbox">
							0~50<input type="checkbox" name="salt1" value=""><br>
							50~100<input type="checkbox" name="salt2" value=""><br>
							100~150<input type="checkbox" name="salt3" value=""><br>
						</div>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="fat">
				<div>
					<div class="fatLabel">
						<label>지방(g)</label>
					</div>
					<div class="blank"></div>

					<div class="checkBoxStyle3">
						<div class="fatCheckbox">
							0~50<input type="checkbox" name="fat1" value=""><br>
							50~100<input type="checkbox" name="fat2" value=""><br>
							100~150<input type="checkbox" name="fat3" value=""><br>
						</div>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


			<div class="protein">
				<div>
					<div class="proteinLabel">
						<label>단백질(g)</label>
					</div>
					<div class="blank"></div>

					<div class="checkBoxStyle4">
						<div class="proteinCheckbox">
							0~50<input type="checkbox" name="protein1" value=""><br>
							50~100<input type="checkbox" name="protein2" value=""><br>
							100~150<input type="checkbox" name="protein3" value=""><br>
						</div>
					</div>
				</div>
			</div>
			<div class="middleBlank"></div>


		
			<div class="search">
				<button class="button" type="reset" value="내용초기화">
					<span> 초기화 </span>
				</button>
				
				<div>　</div>
				
				<button class="button" type="" value="검색하기">
					<span> 검색하기 </span>
				</button>
			</div>
		
			<div class="middleBlank"></div>
		</div>
	</div>
	</form>

	<div class="sideBar">
		<div class="sideBarRight">
			<div class="sideBarGender">
				<!-- 라벨칸 -->
				<div>
					<label>&nbsp;&nbsp;&nbsp;성별 : </label>
				</div>
				<!-- 라디오박스칸 -->
				<div>
					<input type="radio" name="gender" value="man">남 <input
						type="radio" name="gender" value="woman"
						style="padding-left: 50%;">여 <br>
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