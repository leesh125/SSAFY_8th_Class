<%@ page import = "com.ssafy.model.dto.Dept" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<%
	Dept dept = (Dept)request.getAttribute("dept");
%>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 조회</h2>
		</div>
		<%
			String errorMsg = (String)request.getAttribute("errorMsg");
		if(errorMsg != null){
		%>
		<div class="row mt-3">
			<h4 class="bg-warning text-light text-center"><%= errorMsg %></h4>
		</div>
		<% } %>
		<form method="post" action="./modify.do?deptno=${dept.deptNo }" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="deptno">부서번호</label></th>
						<td><input type="text" name="deptno" id="deptno" value="${dept.deptNo }" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="dname">부서이름</label></th>
						<td><input type="text" name="dname" id="dname" value="${dept.dname }"/></td>
					</tr>
					<tr>
						<th><label for="loc">지역</label></th>
						<td><input type="text" name="loc" id="loc" value="${dept.loc }"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" formaction="./delete.do?<%= dept.getDeptNo() %>" formmethod="get"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>