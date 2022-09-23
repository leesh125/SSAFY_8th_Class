<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="${root}/assets/css/notice.css">		
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>

  <!-- 합쳐지고 최소화된 최신 CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

  <!-- 부가적인 테마 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
  
</head>
<body>
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div class="body" style="padding: 200px 20%; background-color:rgb(245, 248, 253);">
    <h2 style="text-align: center; margin-bottom: 50px;">공지사항</h2>
    <c:if test="${usrId eq 'admin'}">
	    <div style="text-align: right;">
	    	<input type="button" value="공지사항 등록" onclick="location.href='${root}/notice/register.do'"/> 
	    </div>
    </c:if>
    
    <table class="table table-bordered table-hover">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
          <th>조회수</th>
        </tr>
      </thead>
      <tbody>
      <c:choose>
		<c:when test="${empty notices }">
			<tr>
				<td colspan="4">등록된 공지사항이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${requestScope.notices}" 
				var="notice" varStatus="status">
				<tr>
					<td>${notice.noticeId}</td>
					<td><a href="${root}/notice/noticeDetail.do?noticeid=${notice.noticeId}">${notice.title}</a></td>
					<td>관리자</td>	
					<td>${notice.date_time}</td>
					<td>${notice.hit}</td>			
				</tr>
			</c:forEach>
		</c:otherwise>
	  </c:choose>	
      </tbody>
    </table>
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
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
