<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>
  <link rel="stylesheet" href="${root}/assets/css/memberInfo.css">
  <!-- =======================================================
  * Template Name: Rapid - v4.8.2
  * Template URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  
<!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <!-- ======= Hero Section ======= -->
  <div class="body">
    <div class="container position-relative" style="height: 800px;">
        <div class="login-box">
            <h2>회원정보</h2>
            <form>
            <div class="user-box">
                <input id="memberInfo-userId" style="margin:20px 0px 40px; font-size: 20px; color: rgb(202, 202, 202);" type="text" name="memberInfo-userId" value="${userId}" disabled>
                <label style="font-size: 20px; color: #03e9f4">아이디</label>
            </div>
            <div class="user-box">
                <input id="memberInfo-password" type="password" style="font-size: 20px;" name="memberInfo-password" value="${user.password}">
                <label>비밀번호</label>
            </div>
            <div class="user-box">
                <input id="memberInfo-username" type="text" style="font-size: 20px;" name="memberInfo-username" value="${user.username}">
                <label>이름</label>
            </div>
            <div class="user-box">
                <input id="memberInfo-address" type="text" style="font-size: 20px;" name="memberInfo-address" value="${user.address}">
                <label>주소</label>
            </div>
            <div class="button-div">
                <a id="a1" onclick="modify()">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    정보 수정
                </a>
                <a id="a2" onclick="deleteUser()">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    회원 삭제
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
  <!-- <script src="${root}/assets/js/memberInfo.js"></script> -->
  <script>
    function modify() {
        if (confirm("회원정보를 수정하시겠습니까?")) {
        	let userId = document.querySelector("#memberInfo-userId").value;
            let password = document.querySelector("#memberInfo-password").value;
            let username = document.querySelector("#memberInfo-username").value;
            let address = document.querySelector("#memberInfo-address").value; 
      	  
      	  fetch('${root}/user/modify.do', {
      	      method: 'POST',
      	      headers: {
      	          'Content-Type': 'application/x-www-form-urlencoded'
      	      },
      	      body: new URLSearchParams({
      	    	  userId,
      	          password,
      	          username,
      	          address
      	        })
      	    }).then(response =>response.json())
      	      .then(flag => {
      	    	  if(flag){
      	    		  alert('회원 정보 수정 성공');
      	    	  }else{
      	    		  alert('회원 정보 수정 실패');
      	    	  }
	      	      window.location.href = '${root}/user/memberInfo.do?userId=${user.userId}';
      	      });
      	  
        } else {
            alert("취소!");
        }
    }
    
    
	</script>	
	<script>
	function deleteUser() {
	        if (confirm("회원정보를 삭제하시겠습니까?")) {
	        	let userId = document.querySelector("#memberInfo-userId").value;
	      	  
	      	  fetch('${root}/user/delete.do', {
	      	      method: 'POST',
	      	      headers: {
	      	          'Content-Type': 'application/x-www-form-urlencoded'
	      	      },
	      	      body: new URLSearchParams({
	      	    	  userId
	      	        })
	      	    }).then(response =>response.json())
	      	      .then(flag => {
	      	    	  if(flag){
	      	    		  window.location.href = '${root}/user/logout.do';
	      	    		  alert('회원 삭제 성공');
	      	    	  }else{
	      	    		  alert('회원 삭제 실패');
	      	    	  }
		      	      window.location.href = '${root}';
	      	      });
	      	  
	        } else {
	            alert("취소!");
	        }
	    }
	</script>
</body>

</html>