<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>

  <!-- 합쳐지고 최소화된 최신 CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

  <!-- 부가적인 테마 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="/assets/css/notice.css">
</head>
<body>
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <body class="sb-nav-fixed">
    <main class="mt-5 pt-5" style="width: 1000px; margin: 100px auto!important;">
    <div class="container-fluid px-4">
      <h1 class="mt-4">게시글 1</h1>
      <div class="card mb-4">
        <div class="card-body">
          <form method="post" action="${root}/notice/register.do" >
            <div class="mb-3">
              <label for="title" class="form-label">제목</label> <input
                type="text" class="form-control" id="title" name="title" required>
            </div>
            <div class="mb-3">
              <label for="title" class="form-label">작성자</label> <input
                type="text" class="form-control" id="admin" name="admin"
                value="관리자" disabled>
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">내용</label>
              <textarea class="form-control" id="content" name="content" required>
				
              </textarea>
            </div>
            <div class="mb-3">
              <label for="regDate" class="form-label">날짜</label> <input
                type="text" class="form-control" id="datetime" name="datetime"
                disabled>
            </div>
            <div class="mb-3">
              <label for="writer" class="form-label">조회수</label> <input
                type="text" class="form-control" id="writer" name="writer"
                disabled>
            </div>
            <a href="${root}/notice/notice.do" class="btn btn-outline-secondary">글 목록</a>
            <c:if test="${userId eq 'admin'}"> 
	            <input type="submit" class="btn btn-outline-warning" value="등록" />
            </c:if>
          </form>
        </div>
      </div>
    </div>
    </main>
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
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>