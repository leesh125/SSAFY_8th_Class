<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header" class="fixed-top d-flex align-items-center header-transparent">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="${root}/index.do">SSAFY Homes</a></h1>
      
      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="${root}">홈</a></li>
          <li class="dropdown"><a href="#"><span>아파트/지역 조회</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="${root}/apt/list.do">실거래가 조회</a></li>
              <li><a href="${root}/area/regist.jsp">관심지역 추가</a></li>

              <li><a href="${root}/interest/regist2.do?userId=${userId}">내 관심지역 조회</a></li>

              <li><a href="${root}/area/store.do">관심지역 조회</a></li>

              <li><a href="${root}/area/environ.do">환경정보 조회</a></li>
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="#footer">Contact</a></li>
          <c:choose>
			<c:when test="${not empty sessionScope.userId}">
				<li style="color:#1bb1dc;"><span id="userId">${userId}</span>님 로그인중</li>
				<li><a class="nav-link scrollto" href="${root}/user/logout.do"> <span class="btn btn-info">로그아웃</span></a></li>
				<li><a class="nav-link scrollto" href="${root}/user/memberInfo.do?userId=${userId}">회원정보</a></li>
			</c:when>
			<c:otherwise>
				<li><a class="nav-link scrollto" href="${root}/user/signup.jsp" style="margin-left: 50px;">로그인/회원가입</a></li>
			</c:otherwise>
			</c:choose>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->  

    </div>
  </header><!-- End Header -->