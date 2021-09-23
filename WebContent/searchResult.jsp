<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="resources/css/index.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/resources/css/board/board.css" />
<style type="text/css">

.first{
	display: flex;
}

.calorieCheckbox {
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
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="first">
		<label>칼로리(cal)</label><br> <br>

		<div class="calorieCheckbox">
			0~300<input type="checkbox" name="calorie1" value=""><br>
			300~500<input type="checkbox" name="calorie2" value=""><br>
			500~700<input type="checkbox" name="calorie3" value=""><br>
		</div>


		<label>나트륨(ng)</label><br> <br>
		<div class="saltCheckbox">
			0~50<input type="checkbox" name="salt1" value=""><br>
			50~100<input type="checkbox" name="salt2" value=""><br>
			100~150<input type="checkbox" name="salt3" value=""><br>
		</div>

		<label>지방(g)</label><br> <br>
		<div class="fatCheckbox">
			0~50<input type="checkbox" name="fat1" value=""><br>
			50~100<input type="checkbox" name="fat2" value=""><br>
			100~150<input type="checkbox" name="fat3" value=""><br>
		</div>

		<label>단백질(g)</label><br> <br>
		<div class="proteinCheckbox">
			0~50<input type="checkbox" name="protein1" value=""><br>
			50~100<input type="checkbox" name="protein2" value=""><br>
			100~150<input type="checkbox" name="protein3" value=""><br>
		</div>
	</div>
	<input type='submit' value='검 색'>

	

	<div class="sideInfoBar">

		<label>성별
		<input type="radio" name="gender" value="man"> 남
		<input type="radio" name="gender" value="woman"> 여 <br></label>
		
		<label>나이 : <input type="text" name="age"></label><br>
		<label>키 : <input type="text" name="height"></label><br>
		<label>몸무게 : <input type="text" name="weight"></label><br>

		<input type='submit' value='계 산' >
		
	</div>

</body>
</html>