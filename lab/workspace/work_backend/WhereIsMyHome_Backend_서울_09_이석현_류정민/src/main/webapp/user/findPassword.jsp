<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>
  <link rel="stylesheet" href="${root}/assets/css/memberInfo.css">
</head>

<body>

  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <!-- ======= Hero Section ======= -->
  <div class="body">
    <div class="container position-relative" style="height: 800px;">
        <div class="login-box">
            <h2>비밀번호 찾기</h2>
            <form>
            <div class="user-box">
              <input type="text" style="font-size: 20px;" name="" required="">
                <label style="font-size: 20px; ">이름</label>
            </div>
            <div class="user-box">
                <input type="text" style="font-size: 20px;" name="" required="">
                <label style="font-size: 20px; ">이메일</label>
            </div>
            <div class="user-box">
              <input type="text" style="font-size: 20px;" name="" required="">
              <label style="font-size: 20px; ">전화번호</label>
            </div>
            <div style="text-align: center;">
                <a id="a1" onclick="alert('문자를 확인하세요?');" href="/">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    비밀번호 찾기
                </a>
            </div>
            </form>
        </div>
    </div>
  </div>



  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${root}/assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="${root}/assets/vendor/aos/aos.js"></script>
  <script src="${root}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${root}/assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="${root}/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${root}/assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="${root}/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${root}/assets/js/main.js"></script>
  <script src="${root}/assets/js/memberInfo.js"></script>
</body>

</html>