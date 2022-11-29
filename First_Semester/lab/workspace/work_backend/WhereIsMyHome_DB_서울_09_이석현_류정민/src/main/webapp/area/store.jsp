<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- ======= head ======= -->
<jsp:include page="/section/head.jsp" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a2669ab921606a801e90cb04df6d5fa"></script>
<script src="https://kit.fontawesome.com/3f8e14e874.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/section/header.jsp" />

	<div class="container mt-3">
		<div style="height: 70px"></div>

		<div class="row col-md-12 justify-content-center m-2 p-3">
			<div class="form-group col-md-3">
				<select class="form-select bg-secondary text-light" id="large">
					<option value="">대분류선택</option>
				</select>
			</div>
			<div class="form-group col-md-3">
				<select class="form-select bg-secondary text-light" id="medium">
					<option value="">중분류선택</option>
				</select>
			</div>
			<div class="form-group col-md-3">
				<select class="form-select bg-secondary text-light" id="small">
					<option value="">소분류선택</option>
				</select>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-sm-5">
				<div>
					<h3>관심 지역 목록</h3>
					<div class="border-top p-3 apt">
						<a class="btn p-0" data-value="1"><h4>도봉동 / 도봉구</h4></a>
	
						<p>
							<button type="button" class="btn btn-outline-primary">
								<i class="bi bi-bookmark-plus-fill text-primary"></i> 메인으로 변경
							</button>
							<button type="button" class="btn btn-danger">
								<i class="bi bi-trash text-light"></i> 삭제
							</button>
						</p>
					</div>
				</div>

				<div>
					<h3>상권 정보</h3>
					<div id="storeList"
						style="overflow: scroll; overflow-x: hidden; height: 450px;">

					</div>
				</div>
			</div>
			<div class="col-sm-7" id="map" style="width: 650px; height: 650px;"></div>
		</div>
	</div>

	<script type="text/javascript" src="../assets/js/store.js"></script>

	<!-- footer -->
	<jsp:include page="/section/footer.jsp" />
</body>
</html>