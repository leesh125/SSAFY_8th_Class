<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>

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
<body style="background-color: rgb(245, 248, 253);">
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div class="body" style="margin-top: 50px;">

  
	  <div class="container mt-3">
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
	    </div>
	    
	    <div class="row mt-3">
	      <div class="col-sm-3">
	        <h2>거래 정보</h2>
	        <div class="border-top p-3 apt">
	          <a class="btn p-0" data-value="1"><h4>극동</h4></a>
	          <p>거래금액 : 32,500만원</p>
	          <p>면적: 84.83</p>
	          <p class="text-muted">
	            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar3" viewBox="0 0 16 16">
	              <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
	              <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
	            </svg> 
	            2019.12.3
	          </p>
	        </div>
	        <div class="border-top p-3 apt">
	          <a class="btn p-0" data-value="2"><h4>도봉산리베니움</h4></a>
	          <!-- <div class="h4 mb-3"><a href="">도봉산리베니움</a></div> -->
	          <p>거래금액 : 29,500만원</p>
	          <p>면적: 84.19</p>
	          <p class="text-muted">
	            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar3" viewBox="0 0 16 16">
	              <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
	              <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
	            </svg> 
	            2019.12.12
	          </p>
	        </div>
	        <div class="border-top p-3 apt">
	          <a class="btn p-0" data-value="3"><h4>도봉파크빌2</h4></a>
	          <!-- <div class="h4 mb-3"><a href="">도봉파크빌2</a></div> -->
	          <p>거래금액 : 43,100만원</p>
	          <p>면적: 84.166</p>
	          <p class="text-muted">
	            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar3" viewBox="0 0 16 16">
	              <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
	              <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
	            </svg> 
	            2019.11.4
	          </p>
	        </div>
	        <div class="border-top p-3 apt">
	          <a class="btn p-0" data-value="4"><h4>도봉파크빌3</h4></a>
	          <!-- <div class="h4 mb-3"><a href="">도봉파크빌3</a></div> -->
	          <p>거래금액 : 45,600만원</p>
	          <p>면적: 84.163</p>
	          <p class="text-muted">
	            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar3" viewBox="0 0 16 16">
	              <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
	              <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
	            </svg> 
	            2019.10.14
	          </p>
	        </div>
	        <div class="border-top p-3 apt">
	          <a class="btn p-0" data-value="5"><h4>동아에코빌</h4></a>
	          <!-- <div class="h4 mb-3"><a href="">동아에코빌</a></div> -->
	          <p>거래금액 : 48,000만원</p>
	          <p>면적: 84.96700000000001</p>
	          <p class="text-muted">
	            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar3" viewBox="0 0 16 16">
	              <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
	              <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
	            </svg> 
	            2019.12.2
	          </p>
	        </div>
	      </div>
	      <div class="col-sm-5 w-75" id="map" style="height:800px;"></div>
	
	    </div>
      </div>
    </div>
  	<!-- footer -->
  	<jsp:include page="/section/footer.jsp"/>
</body>
</html>