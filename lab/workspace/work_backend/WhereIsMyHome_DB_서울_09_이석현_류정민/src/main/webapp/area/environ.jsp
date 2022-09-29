<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- ======= head ======= -->
<jsp:include page="/section/head.jsp" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a2669ab921606a801e90cb04df6d5fa"></script>
<script src="https://kit.fontawesome.com/3f8e14e874.js" crossorigin="anonymous"></script>
</head>
<body style="background-color: rgb(245, 248, 253);">
	<!-- ======= Header ======= -->
	<jsp:include page="/section/header.jsp" />

	<div class="body" style="margin-top: 50px;">

		<div class="container">
			<div style="height: 70px"></div>
			<div class="row col-md-12 justify-content-center m-2 p-3">
				<h4 class="col-md-2 text-center">동별 검색</h4>
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
			</div>
			<div class="row mt-3 ">
				<div class="col-sm-5">
					<%-- <div>
						<h3>관심 지역 목록</h3>
						<div id="likeAreaList" style="overflow: scroll; overflow-x: hidden; height: 250px;">
	
						</div>
					</div> --%>
					
					<div>
						<h3>환경 정보</h3>
						<div id="environList" style="overflow: scroll; overflow-x: hidden; height: 600px;">
	
						</div>
					</div>					
				</div>
				<div class="col-sm-7" id="map" style="width: 650px; height: 650px;"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../assets/js/environ.js"></script>

	<!-- footer -->
	<jsp:include page="/section/footer.jsp" />
</body>
</html>