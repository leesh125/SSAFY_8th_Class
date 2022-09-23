<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- ======= Header ======= -->
  <jsp:include page="/section/head.jsp"/>
</head>

<body>

  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="clearfix">
    <div class="container d-flex h-100">
      <div class="row justify-content-center align-self-center" data-aos="fade-up">
        <div class="col-lg-6 intro-info order-lg-first order-last" data-aos="zoom-in" data-aos-delay="100">
          <h2>전국 아파트 <br>거래 정보를 <span>검색!</span></h2>
          <div>
            <a href="${root}/apt/apt_info.jsp" class="btn-get-started scrollto">검색하기</a>
          </div>
        </div>

        <div class="col-lg-6 intro-img order-lg-last order-first" data-aos="zoom-out" data-aos-delay="200">
          <img src="${root}/assets/img/intro-img.svg" alt="" class="img-fluid">
        </div>
      </div>

    </div>
  </section><!-- End Hero -->

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

</body>

</html>