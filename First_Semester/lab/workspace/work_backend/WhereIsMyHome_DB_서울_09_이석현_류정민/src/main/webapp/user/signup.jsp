<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>
  <link rel="stylesheet" href="${root}/assets/css/signup.css">
</head>

<body>

  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div class="body">
    <div class="main">  	
      <input type="checkbox" id="chk" aria-hidden="true">

        <div class="signup">
          <form id="signUpForm" method="post" action="${root}/user/register.do" >
            <label for="chk" aria-hidden="true">Sign up</label>
            <input type="text" id="userId" name="userId" placeholder="User ID" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <input type="text" id="username" name="username" placeholder="User name" required>
            <input type="text" id="address" name="address" placeholder="Address" required>
            <input type="button" id="signup-btn" value="Sign up"/>
            <div style="text-align: center;">
              <a href="${root}/user/findPassword.jsp">비밀번호를 잊으셨습니까?</a>
            </div>
          </form>
        </div>

        <div class="login">
          <form method="post" action="${root}/user/login.do">
            <label id="login-label" for="chk" aria-hidden="true">Login</label>
            <input type="text" id="login-id" name="login-id" placeholder="User ID" required>
            <input type="password" id="login-password" name="login-password" placeholder="Password" required>
            <input type="button" id="login-btn" value="Login" />
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
  
  <script>
  
      let name = '';
      let email = '';
      let password = '';
      document.querySelector("#signup-btn").addEventListener("click", function(event) {
    	  
          let userId = document.querySelector("#userId").value;
          let password = document.querySelector("#password").value;
          let username = document.querySelector("#username").value; 
    	  let address = document.querySelector("#address").value;
    	  
    	  fetch('${root}/user/register.do', {
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
    	    		  alert('회원가입 성공');
    	    		  document.querySelector("#login-label").click();
    	    	  }else{
    	    		  alert('중복되는 Id가 있습니다.');
    	    	  }
    	      });
    	  
    	/*  
        let signup_name = document.querySelector("#signup-name").value;
        let signup_email = document.querySelector("#signup-email").value;
        let signup_password = document.querySelector("#signup-password").value;
        name = signup_name; email = signup_email; password = signup_password;
        if(signup_name.length > 0 && signup_email.indexOf('@') != -1 && signup_password.length > 0){
          document.getElementById("login-label").click();
        }else{
          alert('입력창을 제대로 입력하세요!');
        }
        */
      });
      
      document.querySelector("#login-btn").addEventListener("click", function(event) {
        let login_id = document.querySelector("#login-id").value;
        let login_password = document.querySelector("#login-password").value;
        
        fetch('${root}/user/login.do', {
  	      method: 'POST',
  	      headers: {
  	          'Content-Type': 'application/x-www-form-urlencoded'
  	      },
  	      body: new URLSearchParams({
  	    		login_id,
  	    		login_password
  	        })
  	    }).then(response =>response.json())
  	      .then(name => {
  	    	  if(name != null){
  	    		  window.location.href = '${root}';
  	    	  }else{
  	    		  console.log('아이디 비번 틀림');
  	    		  alert('ID, Password가 일치하지 않습니다.');
  	    	  }
  	      });
      });

  </script>
</body>

</html>