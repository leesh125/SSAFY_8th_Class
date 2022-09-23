<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ======= Footer ======= -->
  <footer id="footer" class="section-bg">
    <div class="footer-top">
      <div class="container">

        <div class="row">

          <div class="col-lg-6">

            <div class="row">

              <div class="col-sm-6">

                <div class="footer-info">
                  <h3>SSAFY HOMES</h3>
                  <p>'구해줘 SSAFY HOMES'는 전국 아파트 실거래 정보를 제공합니다. 공공기관에 등록된 주택 정보라면 전국 아파트 어디든 거래 정보 조회가 제공됩니다.</p>
                </div>
                <p>
                  <a href="${root}/notice/notice.do">
                    공지사항
                  </a>
                </p>
              </div>

              <div class="col-sm-6">
                

                <div class="footer-links">
                  <h4>Contact Us</h4>
                  <p>
                    서울시 강남구 역삼동<br>
                    <strong>Phone:</strong> +1 82 8688 0000<br>
                    <strong>Email:</strong> chelsea12345@example.com<br>
                  </p>
                </div>

                <div class="social-links">
                  <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                  <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                  <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                  <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                </div>
                
              </div>

            </div>

          </div>

          <div class="col-lg-6">

            <div class="form">

              <h4>Send us a message</h4>

              <form action="forms/contact.php" method="post" role="form" class="php-email-form">
                <div class="form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="이름" required>
                </div>
                <div class="form-group mt-3">
                  <input type="email" class="form-control" name="email" id="email" placeholder="이메일" required>
                </div>
                <div class="form-group mt-3">
                  <textarea class="form-control" name="message" rows="2" placeholder="메시지" required></textarea>
                </div>

                <div class="my-3">
                  <div class="loading">Loading</div>
                  <div class="error-message"></div>
                  <div class="sent-message">Your message has been sent. Thank you!</div>
                </div>

                <div class="text-center"><button type="submit" title="Send Message">Send Message</button></div>
              </form>

            </div>

          </div>

        </div>

      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong>SSAFY</strong>. All Rights Reserved
      </div>
    </div>
  </footer><!-- End  Footer -->