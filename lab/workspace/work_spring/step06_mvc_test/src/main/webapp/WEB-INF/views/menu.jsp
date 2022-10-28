<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<ul class="navbar-nav me-auto">
<c:choose>
	<c:when test="${not empty userId}">
	    <span class="navbar-text me-3 ms-3 text-white">${userId}님 로그인중</span>
		<li class="nav-item"><a class="nav-link bg-success text-white" href="${root}/user/logout.do">
		로그아웃</a></li>
	</c:when>
<%-- 	<c:when test="${not empty cookie.userId.value}">
		${cookie.userId.value}님 로그인중
		<a href="${root}/user/logout.do"><span class="btn btn-info">로그아웃</span></a>
	</c:when> --%>
	<c:otherwise>
		<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/user/login_form.do">로그인</a></li>
	</c:otherwise>
</c:choose>
		<li class="nav-item"><a class="nav-link ms-2 bg-primary text-white" href="${root}/index.do">
		홈</a></li>
	</ul>

</nav>










