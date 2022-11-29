<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>

  <script>
    window.onload = function(){
      let registerBtn = document.querySelector("#registerBtn");
      let closeBtn = document.querySelector("#closeBtn");

      registerBtn.addEventListener("click", function(){
        alert("등록 완료!");
      });

      closeBtn.addEventListener("click", function(){
        alert("정말 삭제하시겠습니까?");
      });
    }
  </script>
</head>
<body style="background-color: rgb(245, 248, 253);">
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div class="container" style="margin-top: 200px; ;">
    <h2 style="text-align: center;">관심 지역 설정</h2>
    <div class="row mt-3 " style="margin-bottom: 200px">
      <div class="col-sm-3">
        <label for="inputRegion">관심 지역 설정</label>
      </div>
      <div class="col-sm-6">
        <form>
          <div class="form-group">
            <select class="form-control m-1">
              <option>서울특별시</option>
              <option>경기도</option>
              <option>부산광역시</option>
              <option>대전광역시</option>
              <option>강원도</option>
            </select>
            <select class="form-control m-1">
              <option>도봉구</option>
              <option>종로구</option>
              <option>중구</option>
              <option>용산구</option>
              <option>강남구</option>
            </select>
            <select class="form-control m-1">
              <option>도봉동</option>
              <option>방학동</option>
              <option>쌍문동</option>
              <option>창동</option>
            </select>
        </form>
        <div class="mt-3">
          <button class="btn btn-primary" id="registerBtn" type="submit">등록</button>
          <button class="btn btn-primary" id="closeBtn">닫기</button>
        </div>
        
      </div>
    </div>
  </div>

  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>
</body>
</html>