<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product/list.do">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product/register.jsp">상품 정보 등록</a></li>
		<c:choose>
			<c:when test="${not empty sessionScope.userId}">
				<span style="color:white;">${userId}님 로그인중</span>
				<li class="nav-item"><a href="${root}/user/logout.do"> <span class="btn btn-info">로그아웃</span></a></li>
			</c:when>
			<c:otherwise>
				<li class="nav-item"><span class="btn btn-primary">회원가입</span></li>
				<li class="nav-item"><a href="${root}/user/login_form.do"><span class="btn btn-info">로그인</span></a></li>	
			</c:otherwise>
		</c:choose>
	</ul>
</nav>