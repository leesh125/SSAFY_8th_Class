<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>

  <!-- 합쳐지고 최소화된 최신 CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

  <!-- 부가적인 테마 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="${root}/assets/css/notice.css">
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
          <form>
            <div class="mb-3 mt-3">
              <label for="bno" class="form-label">번호</label> <input type="text"
                class="form-control" id="noticeid" name="noticeid" value="${notice.noticeId}"
                disabled>
            </div>
            <div class="mb-3">
              <label for="title" class="form-label">제목</label> <input
                type="text" class="form-control" id="title" name="title"
                value="${notice.title}" disabled>
            </div>
            <div class="mb-3">
              <label for="title" class="form-label">작성자</label> <input
                type="text" class="form-control" id="admin" name="admin"
                value="관리자" disabled>
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">내용</label>
              <textarea class="form-control" id="content" name="content" disabled>
				${notice.content}
              </textarea>
            </div>
            <div class="mb-3">
              <label for="regDate" class="form-label">날짜</label> <input
                type="text" class="form-control" id="datetime" name="datetime"
                value="${notice.date_time}" disabled>
            </div>
            <div class="mb-3">
              <label for="writer" class="form-label">조회수</label> <input
                type="text" class="form-control" id="writer" name="writer"
                value="${notice.hit}" disabled>
            </div>
            <a href="${root}/notice/notice.jsp" class="btn btn-outline-secondary">글 목록</a> <a
              href="${root}" class="btn btn-outline-warning" onclick="return confirm('수정하시겠습니까?')">수정하기</a>
            <a href="${root}" class="btn btn-outline-danger"
              onclick="return confirm('삭제하시겠습니까?')">삭제</a>
          </form>
        </div>
      </div>
    </div>
    </main>
  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script>
      let name = '';
      let email = '';
      let password = '';
      document.querySelector("#signup-btn").addEventListener("click", function(event) {
        event.preventDefault();
        let signup_name = document.querySelector("#signup-name").value;
        let signup_email = document.querySelector("#signup-email").value;
        let signup_password = document.querySelector("#signup-password").value;
        name = signup_name; email = signup_email; password = signup_password;
        if(signup_name.length > 0 && signup_email.indexOf('@') != -1 && signup_password.length > 0){
          document.getElementById("login-label").click();
        }else{
          alert('입력창을 제대로 입력하세요!');
        }
      });
      
      document.querySelector("#login-btn").addEventListener("click", function(event) {
        let login_email = document.querySelector("#login-email").value;
        let login_password = document.querySelector("#login-password").value;
        event.preventDefault();
        if(login_email == email && password == login_password){
          localStorage.setItem('name',name);
          localStorage.setItem('email',email);
          localStorage.setItem('password',password);
          window.location.href = '/';
        }else{
          alert('계정정보가 정확하지 않습니다.');
        }
      });

  </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>