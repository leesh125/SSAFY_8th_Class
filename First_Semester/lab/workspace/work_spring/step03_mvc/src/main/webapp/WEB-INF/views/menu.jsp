<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${not empty userId}">
		${userId}님 로그인되어있음
		<a href="${root}/user/logout.do"><span class="btn btn-info">로그아웃</span></a>
		<a href="${root}/index.do"><span class="btn btn-info">홈으로</span></a>
	</c:when>

	<c:otherwise>
		<a href="${root}/user/register_form.do"><span class="btn btn-primary">회원가입</span></a>
		<a href="${root}/user/login_form.do"><span class="btn btn-info">로그인</span></a>	
		<a href="${root}/index.do"><span class="btn btn-info">홈으로</span></a>
	</c:otherwise>
</c:choose>


