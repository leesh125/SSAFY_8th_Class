<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- ======= head ======= -->
<jsp:include page="/section/head.jsp" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a2669ab921606a801e90cb04df6d5fa"></script>
<script src="https://kit.fontawesome.com/3f8e14e874.js"
	crossorigin="anonymous"></script>
</head>
<body style="background-color: rgb(245, 248, 253);">
	<!-- ======= Header ======= -->
	<jsp:include page="/section/header.jsp" />

	<div class="body" style="margin-top: 50px;">

		<div class="container">
			<div style="height: 70px"></div>
			<div class="row col-md-12 justify-content-center m-2 p-3">
				<h4 class="col-md-2 text-center">동별 조회</h4>
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="sido">
						<option value="">시도선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="gugun">
						<option value="">구군선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="dong">
						<option value="">동선택</option>
					</select>
				</div>
				<!--  
				<div class="form-group col-md-2 m-1">
					<button type="button" id="list-btn" class="btn btn-outline-primary">
						아파트매매정보가져오기</button>
				</div>-->
			</div>
			<div class="row col-md-12 justify-content-center m-2 p-3">
				<h4 class="col-md-2 text-center">아파트별 검색</h4>
				<input class="col-md-5 pl-5" type="text" id="aptName" name="aptName"
					placeholder="아파트명" style="border: 0;"><br>

				<div class="form-group col-md-1">
					<button type="button" id="searchBtn"
						class="btn btn-outline-info">검색</button>
				</div>
			</div>
			<div class="row mt-3 ">
				<div class="col-sm-5">
					<h2>거래 정보</h2>
					<div id="housedealList" style="overflow: scroll; height: 600px;">

					</div>
				</div>
				<div class="col-sm-7" id="map" style="width: 650px; height: 650px;"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../assets/js/housedeal.js"></script>

	<!-- footer -->
	<jsp:include page="/section/footer.jsp" />
</body>
</html>