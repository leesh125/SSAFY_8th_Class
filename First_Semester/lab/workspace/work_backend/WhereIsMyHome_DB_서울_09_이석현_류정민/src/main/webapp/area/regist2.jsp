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
    <div>
      <div class="row mt-3 " style="margin-bottom: 100px; text-align: center;">
      	<h2 style="text-align: center; margin-bottom: 100px;">내 관심 지역</h2>
      <div class="col-sm-6" style="text-align: center; width: 100%; display:flex; justify-content: center;">
      	  <c:choose>
			<c:when test="${empty interests}">
				<tr>
					<td colspan="4">관심지역이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="interest" items="${interests}">
					<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
			          <defs>
			            <filter id="gooey">
			                <!-- in="sourceGraphic" -->
			                <feGaussianBlur in="SourceGraphic" stdDeviation="5" result="blur" />
			                <feColorMatrix in="blur" type="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9" result="highContrastGraphic" />
			                <feComposite in="SourceGraphic" in2="highContrastGraphic" operator="atop" />
			            </filter>
			          </defs>
				    </svg>
				
				    <button id="gooey-button">
				        ${interest}
				        <span class="bubbles">
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				            <span class="bubble"></span>
				        </span>
				    </button>
				</c:forEach>
			</c:otherwise>
		  </c:choose> 
        
      </div>
      
    </div>
    </div>
  </div>

  <!-- footer -->
  <jsp:include page="/section/footer.jsp"/>

</body>
</html>