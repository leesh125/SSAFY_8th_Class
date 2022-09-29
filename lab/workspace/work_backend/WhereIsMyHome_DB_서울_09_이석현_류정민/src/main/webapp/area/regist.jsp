<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- ======= head ======= -->
  <jsp:include page="/section/head.jsp"/>
  <link rel="stylesheet" type="text/css" href="${root}/assets/css/area_register.css">
</head>
<body style="background-color: rgb(245, 248, 253);">
  <!-- ======= Header ======= -->
  <jsp:include page="/section/header.jsp"/>

  <div class="container" style="margin-top: 200px; min-height: 500px;">
    <h2 style="text-align: center;">관심 지역 설정</h2>
    <div class="row mt-3 " style="margin-bottom: 100px; text-align: center;">
      
      <div class="col-sm-6" style="text-align: center; width: 100%; display:flex; justify-content: center;">
        <div class="form-group col-md-2">
			<select class="form-select bg-secondary text-light" id="sido">
				<option value="">시도선택</option>
			</select>
		</div>
		<div class="form-group col-md-2">
			<select class="form-select bg-secondary text-light" id="gugun">
				<option value="">구군선택</option>
			</select>
		</div>
		<div class="form-group col-md-2">
			<select class="form-select bg-secondary text-light" id="dong">
				<option value="">동선택</option>
			</select>
		</div>
		<div style="margin-left: 20px;">
          <button class="btn btn-primary" id="registerBtn">등록</button>
      	</div>
      </div>
      
    </div>
    <div>
      
      

    </div>
  </div>

  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>
  <c:set var="userId" value="${userId}"/>
  <script type="text/javascript" src="${root}/assets/js/registArea.js"></script>
  <script>
  	
  	document.querySelector("#registerBtn").addEventListener("click", function(event) {
  		console.log(dongCode);
  		let userId = document.querySelector("#userId").innerText;
  		console.log(userId);
        fetch('${root}/interest/regist.do', {
  	      method: 'POST',
  	      headers: {
  	          'Content-Type': 'application/x-www-form-urlencoded'
  	      },
  	      body: new URLSearchParams({
  	    		userId,
  	    		dongCode
  	        })
  	    }).then(response =>response.json())
  	      .then(flag => {
  	    	if(flag){
	    		  alert('관심 지역 등록이 완료되었습니다.');
	    	  }else{
	    		  alert('관심 지역 등록에 실패하였습니다.');
	    	  }
  	      });
      });
  </script>
  <script src="http://code.jquery.com/jquery-latest.js"></script> 
  <script type="text/javascript">
  $(".custom-select").each(function() {
	  var classes = $(this).attr("class"),
	    id = $(this).attr("id"),
	    name = $(this).attr("name");
	  var template = '<div class="' + classes + '">';
	  template +=
	    '<span class="custom-select-trigger">' +
	    $(this).attr("placeholder") +
	    "</span>";
	  template += '<div class="custom-options">';
	  $(this)
	    .find("option")
	    .each(function() {
	      template +=
	        '<span class="custom-option ' +
	        $(this).attr("class") +
	        '" data-value="' +
	        $(this).attr("value") +
	        '">' +
	        $(this).html() +
	        "</span>";
	    });
	  template += "</div></div>";

	  $(this).wrap('<div class="custom-select-wrapper"></div>');
	  $(this).hide();
	  $(this).after(template);
	});
	$(".custom-option:first-of-type").hover(
	  function() {
	    $(this)
	      .parents(".custom-options")
	      .addClass("option-hover");
	  },
	  function() {
	    $(this)
	      .parents(".custom-options")
	      .removeClass("option-hover");
	  }
	);
	$(".custom-select-trigger").on("click", function() {
	  $("html").one("click", function() {
	    $(".custom-select").removeClass("opened");
	  });
	  $(this)
	    .parents(".custom-select")
	    .toggleClass("opened");
	  event.stopPropagation();
	});
	$(".custom-option").on("click", function() {
	  $(this)
	    .parents(".custom-select-wrapper")
	    .find("select")
	    .val($(this).data("value"));
	  $(this)
	    .parents(".custom-options")
	    .find(".custom-option")
	    .removeClass("selection");
	  $(this).addClass("selection");
	  $(this)
	    .parents(".custom-select")
	    .removeClass("opened");
	  $(this)
	    .parents(".custom-select")
	    .find(".custom-select-trigger")
	    .text($(this).text());
	});
  </script>
</body>
</html>