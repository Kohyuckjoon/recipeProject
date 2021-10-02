<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container-fluid">
<header class="p-3 mb-3 border-bottom">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
        	<img src="../resources/img/banner.gif" style="width:25%;height:auto;"/>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 link-secondary">메인페이지</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">다이어트 & 헬스레시피</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">자유게시판</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">마이페이지</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none " aria-expanded="false">
          	<i class="fa fa-user-circle fa-2x" aria-hidden="true"></i>
          </a>
        </div>
      </div>
  </header>
	<div class="row m-2" style="width: 40%">
		<div class="col card p-0" style="margin-right: 2rem;">
			<div class="card-header">칼로리(cal)</div>
			<form>
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        0-300
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        300-500
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        500-700
				      </label>
				    </div>
				  </div>
			    </li>
			  </ul>
			</form>
		</div>
		<div class="col card p-0" style="margin-right: 2rem;">
			<div class="card-header">나트륨(na)</div>
			<form>
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        0-50
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        50-100
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        100-150
				      </label>
				    </div>
				  </div>
			    </li>
			  </ul>
			</form>
		</div>
		<div class="col card p-0" style="margin-right: 2rem;">
			<div class="card-header">지방(g)</div>
			<form>
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        0-50
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        50-100
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        100-150
				      </label>
				    </div>
				  </div>
			    </li>
			  </ul>
			</form>
		</div>
		<div class="col card p-0" style="margin-right: 2rem;">
			<div class="card-header">단백질(g)</div>
			<form>
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        0-50
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        50-100
				      </label>
				    </div>
				  </div>
			    </li>
			    <li class="list-group-item">
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck" checked>
				      <label class="form-check-label" for="gridCheck">
				        100-150
				      </label>
				    </div>
				  </div>
			    </li>
			  </ul>
			</form>
		</div>
		<div class="col" style="margin-top:15%">
			<button class="btn btn-primary">전체선택</button>
		</div>
	</div>
	<div class="row container">
		<div class="card" style="width: 18rem;">
		  <img src="https://w.namu.la/s/40d7c3c736da95c2354af2cf42cdb86c138c1a2daa19e3102b9083ca1cdea1fa88d2a772544b5a1912185b2117f5822950774633d962d96f31109eb824125b92f6d7f6f2855dcca58485a79d433c5b309ff7153f599b9537facd7b74418d756cf8a0d8c7cf19922b3e38a464c1bdab13" class="card-img-top" alt="...">
		  <div class="card-body">
		    <p class="card-title">음식</p>
		  </div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html> --%>