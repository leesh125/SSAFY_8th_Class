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
	<div class="container p-4">
	
	  <h2>노트북 상세 정보</h2>
	  	<a class="btn btn-danger" href="${root}/note/delete.do?noteCode=${note.noteCode}">삭제</a>
	  <table class="table table-striped">
	      <tr>
	        <td>고유번호</td><td>${note.noteCode}</td>
	      </tr>
	      <tr>
	        <td>모델명</td><td>${note.model}</td>
	      </tr>
	      <tr>
	        <td>가격</td><td>${note.price}</td>
	      </tr>
	      <tr>
	        <td>제조사</td><td>${note.company}</td>
	      </tr>
	  </table>
	
	</div>
<%@ include file="/include/footer.jsp" %>