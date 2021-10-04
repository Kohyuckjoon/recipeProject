<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link href="../resources/css/mainPage/mainPage.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/mainPage.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="resources/css/include/all.css">
<link rel="stylesheet" href="resources/css/include/reset.css">
<link href="../resources/css/include/footer.css" rel="stylesheet"  type="text/css">
<style type="text/css">
/* div {
	box-shadow: 0 0 2px black;
} */
input[type="text"] {
	width: 130px;
}

.topBlank {
	height: 2vh;
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

.body {
	width: 1600px;
	display: inline-flex;
	flex-direction: column;
	margin-top: 100px;
}

/* .checkBox {
	height: 15vh;
} */
.sideBar {
	float: right;
	height: 45vh;
	width: 13%;
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

.secondBlank {
	height: 5vh;
}

.lowerBox {
	height: 100%;
}

.lowerBoxLeft {
	float: left;
	width: 82%;
	height: 79vh;
}

.lowerBoxRight {
	float: right;
	width: 13.5%;
	height: 79vh;
}

.sideBarBoxStyle {
	box-shadow: 7px 14px 42px 3px rgba(0, 0, 0, 0.3);
	background-color: white;
	padding: 3%;
	margin: 5%;
	width: 85%;
	height: 85%;
}

.sideBarinfo {
	float: right;
	left: 50%;
}

.sideBarTitle {
	margin: 10px;
	width: 70%;
	height: 78vh;
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

.foot {
	margin-top: 20px;
	width : 1800px;
	height: 100px;
	background-color: lightblue;
	display: flex;
	
}

.Copyright {
	position: relative;
	margin: auto;
}
</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>



	<div class="body"></div>

	<form action="#" method="get">
		<div>
			<div class="topBlank"></div>
			<div class="checkBox">
				<div class="calorie">
					<div>
						<div class="calorielabel">
							<label>칼로리(cal)</label>
						</div>
						<div class="blank"></div>

						<div class="checkBoxStyle1">
							<div class="calorieCheckbox">
								0~300<input type="checkbox" name="calorie" value="300" onclick="calorieCheckbox(this)"><br>
								300~500<input type="checkbox" name="calorie" value="500" onclick="calorieCheckbox(this)"><br> 
								500~700<input type="checkbox" name="calorie" value="700" onclick="calorieCheckbox(this)"><br>
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
								0~50<input type="checkbox" name="salt" value="50"
									onclick="saltCheckbox(this)"><br> 50~100<input
									type="checkbox" name="salt" value="100"
									onclick="saltCheckbox(this)"><br> 100~150<input
									type="checkbox" name="salt" value="150"
									onclick="saltCheckbox(this)"><br>
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
								0~50<input type="checkbox" name="fat" value=50
									onclick="fatCheckbox(this)"><br> 50~100<input
									type="checkbox" name="fat" value="100"
									onclick="fatCheckbox(this)"><br> 100~150<input
									type="checkbox" name="fat" value="150"
									onclick="fatCheckbox(this)"><br>
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
								0~50<input type="checkbox" name="protein" value="50"
									onclick="proteinCheckbox(this)"><br> 50~100<input
									type="checkbox" name="protein" value="100"
									onclick="proteinCheckbox(this)"><br> 100~150<input
									type="checkbox" name="protein" value="150"
									onclick="proteinCheckbox(this)"><br>
							</div>
						</div>
					</div>
				</div>
				<div class="middleBlank"></div>


				<div class="search">
					<button class="button" type="reset" value="resetButten">
						<span> 초기화 </span>
					</button>

					<div></div>

					<button name="search" class="button" type="" value="searchButten">
						<span> 검색하기 </span>
					</button>
				</div>



				<div class="middleBlank"></div>
			</div>

			<div class="secondBlank"></div>
		</div>
	</form>

	<!-- checkBox값 추출하기 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#getCheckedAll").click(function() {
				$("input[name=box]:checked").each(function() {
					var test = $(this).val();
					console.log(test);
				});
			});
		})();
	</script>

	<!-- 출력? -->
	<script type="text/javascript">
		function checkTest() {
			console.log(checktest1());

			console.log('checkBox값 : '
					+ $(":input:checkbox[name=checkbox]:checked").val());

			$("input[name=checkbox]:checked").each(function() {
				console.log('checkbox값 : ' + $(this).val());
			});
		}
	</script>


	<script type="text/javascript">
		let sPN = parseInt(sessionStorage.getItem('sessionPageNumber'));

		if (isNaN(sPN) == true) {
			sPN = 1;
		}

		let recipeIdx = new Array();
		let recipeImg = new Array();
		let recipeType = new Array();
		let recipeName = new Array();

		<c:forEach var="recipe" items="${Recipes}">
		recipeIdx.push('${recipe.rcpSeq}');
		recipeImg.push('${recipe.attFileNoMk}');
		recipeType.push('${recipe.rcpPat2}');
		recipeName.push('${recipe.rcpNm}');

		</c:forEach>
	</script>


	<div class="lowerBox">
		<div class="lowerBoxLeft"></div>

		<!-- <div class="lowerBoxRight">
			<div class="sideBarBoxStyle">
				<div class="sideBarinfo">
					<div>
						<label>성별 : </label> <input type="radio" name="gender" value="man">남
						<input type="radio" name="gender" value="woman"
							style="padding-left: 50%;">여 <br> <br>
					</div>

					<div>
						<label>나이 : <input type="text" name="age"></label><br>
						<br>
					</div>

					<div>
						<label>키 : <input type="text" name="height"></label><br>
						<br>
					</div>

					<div>
						<label>몸무게 : <input type="text" name="weight"></label><br>
						<br>
					</div>


					<div class="calculateResult">
						<input type='submit' value='계 산'>
					</div>


				</div>
			</div>
		</div> -->
	</div>



	<script type="text/javascript">
		/* 체크박스 중복체크 불가하도록 자바스크립트 코드 */
		function calorieCheckbox(a) {
			var obj = document.getElementsByName("calorie");
			for (var i = 0; i < obj.length; i++) {
				if (obj[i] != a) {
					obj[i].checked = false;
				}
			}
		}
		function saltCheckbox(a) {
			var obj = document.getElementsByName("salt");
			for (var i = 0; i < obj.length; i++) {
				if (obj[i] != a) {
					obj[i].checked = false;
				}
			}
		}
		function fatCheckbox(a) {
			var obj = document.getElementsByName("fat");
			for (var i = 0; i < obj.length; i++) {
				if (obj[i] != a) {
					obj[i].checked = false;
				}
			}
		}
		function proteinCheckbox(a) {
			var obj = document.getElementsByName("protein");
			for (var i = 0; i < obj.length; i++) {
				if (obj[i] != a) {
					obj[i].checked = false;
				}
			}
		}
	</script>


	<script type="text/javascript"
		src="/resources/js/dietHealth/dietHealthPage.js"></script>
		


</body>
</html>