<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="../resources/css/mainPage/mainPage.css" rel="stylesheet"  type="text/css">
</head>
<body>
	
	<!-- 헤더 불러옴 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<!-- 싸이드바 -->
	<!-- 애는 파라미터 바꿀일이 없어서 JSTL 사용함 -->
	<div class="sideBar">
		<div class="sideBar-title">Best Recipes</div>
		<div>
		<a>
			<img src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png" id="kakao_share_btn" onclick="shareKakao();"/>
		</a>
		</div>
		<div class="sideBar-body">
			<c:forEach var="recipe" items="${Recipes}" begin= "31" end="36">
				<div class="best-recipe">
					<img class="best-recipe-pic" src="${recipe.attFileNoMk}">
					<div class="best-recipe-text">
						<div class="most-popular-recipe-text" >${recipe.rcpNm}</div>
						<div class="food-star">★★★★★</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	
	
	<!-- 여기서부터 바디 -->
	
	<!-- JAVA(server)단 session은 JavaScript(client)단에서 변경 불가. controller를 타야 변경 가능. -->
	<!-- controller를 페이지 수만큼 늘리는건 좀 무식한짓 같았음 -->
	<!-- 따라서 JSTL로 구현했던 페이지를 JavaScript로 갈아엎음 -->
	<!-- JSTL은 JavaScript의 array에 값을 넣는데만 쓰임-->
	<!-- 그리고 하단 페이저의 숫자 클릭시 sPN(Session Page Number)이라는 세션값이 설정되고-->
	<!-- 그 값을 변수로 가져와서 페이지 설정-->
	
	<!-- body class의 div에 JavaScript로 설정한 노드들이 붙음-->
	<!-- JSTL 제외하고 다 JavaScript 파일로 빼놓음-->
	 
	<div class="body">
			 
	</div>
	
	<script type="text/javascript">
	let sPN = parseInt(sessionStorage.getItem('sessionPageNumber'));
	
	if(isNaN(sPN) == true) {
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
	
 
	<!-- 페이저 구현 HTML-->
	<!-- 물론 자바스크립트 코드는 따로 뺴놓음 -->
	<div class = "pager">
		<table>
			<tr>
				<td class = "arrow prevPrevPage"><i class="fas fa-angle-double-left"></i></td>
				<td class = "blank"></td>
				<td class = "arrow prevPage"><i class="fas fa-angle-left"></i></td>
				<td class = "blank"> </td>
				<td class = "blank num"> </td>
				<td class = "arrow nextPage"><i class="fas fa-angle-right"></i></td>
				<td class = "blank"></td>
				<td class = "arrow nextNextPage"><i class="fas fa-angle-double-right"></i></td>
			</tr>
		</table>
	</div>
	
	
	<!-- footer 불러옴-->
	
	<%@ include file="/WEB-INF/views/include/foot.jsp" %>
	
	<script type="text/javascript" src = "/resources/js/mainPage/mainPage.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
	Kakao.init('0c512e152e989192c220235a73035b4b');
	Kakao.isInitialized();
	
	function shareKakao() {
		 
		  // 사용할 앱의 JavaScript 키 설정
		 
		 
		  // 카카오링크 버튼 생성
		  Kakao.Link.createDefaultButton({
		    container: '#kakao_share_btn', // 카카오공유버튼ID
		    objectType: 'feed',
		    content: {
		      title: "Fitness Recipes", // 보여질 제목
		      description: "The Fitness Recipes", // 보여질 설명
		      imageUrl: "../../img/banner.gif", // 콘텐츠 URL
		      link: {
		         mobileWebUrl: window.location.href,
		         webUrl: window.location.href
		      }
		    }
		  });
		}
	</script>
	
</body>
</html>