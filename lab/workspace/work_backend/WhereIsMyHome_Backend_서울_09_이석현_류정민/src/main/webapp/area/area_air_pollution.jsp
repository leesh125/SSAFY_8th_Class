<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a2669ab921606a801e90cb04df6d5fa"></script>
  <script>
    window.onload = function(){

      var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
      var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
      };

      var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

      let apts = document.querySelectorAll(".apt>a"); // 아파트명
      let mapImg = document.querySelector('img'); // 지도 사진

      for(const apt of apts){
        apt.addEventListener("click", getInfo);
      }

      // 클릭한 아파트 상세 정보 가져오기
      function getInfo(){
        let color = this.style.color;

        // 색상 초기화
        initColor();

        let mapId = this.getAttribute('data-value');
          
        // 선택한 부분 하이라이트
        this.style.color="blue";
      }

      function initColor(){
        for(const apt of apts){
          apt.style.color = "black";
        }
      }
    }
  </script>
</head>
<body style="background-color: rgb(245, 248, 253); ">
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div style="background-color: rgb(245, 248, 253);">
    <div class="container" style="margin-top: 100px; margin-bottom: 100px;">
      <div class="d-flex justify-content-center align-items-center">
        <select class="form-select w-auto m-1">
          <option>서울특별시</option>
          <option>경기도</option>
          <option>부산광역시</option>
          <option>대전광역시</option>
          <option>강원도</option>
        </select>
        <select class="form-select w-auto m-1">
          <option>도봉구</option>
          <option>종로구</option>
          <option>중구</option>
          <option>용산구</option>
          <option>강남구</option>
        </select>
        <select class="form-select w-auto m-1">
          <option>도봉동</option>
          <option>방학동</option>
          <option>쌍문동</option>
          <option>창동</option>
        </select>
        <button class="btn btn-dark">추가</button>
      </div>
      
      <div class="row mt-3">
        <div class="col-sm-3">
          <div class="row mb-3">
            <div class="form-check col">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                녹지
              </label>
            </div>
            <div class="form-check col">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                매수 배출
              </label>
            </div>
            <div class="form-check col">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                대기 배출
              </label>
            </div>
          </div>
          <h2>환경 정보 조회</h2>
          <div class="border-top p-3 apt">
            <a class="btn p-0" data-value="1">
              <h4><span class="dong">궁동</span> / <span class="gu">구로구</span></h4>
            </a>
            <p>
              <button type="button" class="btn btn-outline-primary">
                <i class="bi bi-bookmark-plus-fill text-primary"></i> 메인으로 변경
              </button>
              <button type="button" class="btn btn-danger">
                <i class="bi bi-trash text-light"></i> 삭제
              </button>
            </p>
          </div>
          <div class="border-top p-3 apt">
            <a class="btn p-0" data-value="1">
              <h4><span class="dong">방학동</span> / <span class="gu">도봉구</span></h4>
            </a>
            <p>
              <button type="button" class="btn btn-outline-primary">
                <i class="bi bi-bookmark-plus-fill text-primary"></i> 메인으로 변경
              </button>
              <button type="button" class="btn btn-danger">
                <i class="bi bi-trash text-light"></i> 삭제
              </button>
            </p>
          </div>
          <div class="border-top p-3 apt">
            <a class="btn p-0" data-value="1">
              <h4><span class="dong">도봉동</span> / <span class="gu">도봉구</span></h4>
            </a>
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
        <div class="col-sm-5 w-75" id="map" style="height:800px;"></div>
      </div>
    </div>
  </div>
  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

</body>
</html>