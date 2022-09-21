<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<c:if test="${errorMsg!=null}">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">${errorMsg }</h2>
		</div>
	</c:if>
	<div class="container p-4">
	
	  <h2>상품 정보 등록</h2>
	  <form id="registForm" action="${root}/product/register.do" class="row">
	  	<input type="hidden" name="action" value="">
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      <input type="text" class="form-control" name="code" id="productCode" placeholder="고유번호 입력">
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" name="model" id="model" placeholder="모델명 입력">
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" name="price" id="price" placeholder="가격 입력" >
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
	<%-- --%>
<%@ include file="/include/footer.jsp" %>