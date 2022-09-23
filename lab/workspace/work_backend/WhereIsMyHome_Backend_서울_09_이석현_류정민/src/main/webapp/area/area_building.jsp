<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  
<!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
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
<body>
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div class="container mt-3">
    <div class="d-flex justify-content-center align-items-center">
      <select class="form-select w-auto m-1">
        <option>서비스업</option>
        <option>외식업</option>
        <option>소매업</option>
        <option>기타</option>
      </select>
      <select class="form-select w-auto m-1">
        <option>관광/여가/오락</option>
        <option>학문/교육</option>
        <option>의료</option>
        <option>생활서비스</option>
        <option>부동산</option>
        <option>숙박</option>
      </select>
      <select class="form-select w-auto m-1">
        <option>영화관</option>
        <option>미술관</option>
        <option>박물관</option>
        <option>아트센터</option>
        <option>연극</option>
      </select>
    </div>
    
    <div class="row mt-3">
      <div class="col-sm-3">
        <h2>관심 지역 목록</h2>
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
          <!-- <p class="text-muted">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
              <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
            </svg>
            메인으로 변경
          </p>
          <p class="text-muted">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
              <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
            </svg>
            삭제
          </p> -->
        </div>
      </div>
      <div class="col-sm-5 w-75" id="map" style="height:800px;"></div>
    </div>
    
  </div>
  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>
</body>
</html>