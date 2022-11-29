<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	
	<ul>
		<li><a href="${root}/emp/register_form.do">사원 등록</a></li>
		<li><a href="${root}/emp/list.do">사원 목록</a></li>
		<li><a href="${root}/dept/register_form.do">부서 등록</a></li>
		<li><a href="${root}/dept/list.do">부서 목록</a></li>
		<li><a href="${root}/dept/rest/list.do">부서 목록을 페이지가 아니라 JSON 으로 받아요 (응답 오는지만 확인)</a></li>
	</ul>
</body>
</html>