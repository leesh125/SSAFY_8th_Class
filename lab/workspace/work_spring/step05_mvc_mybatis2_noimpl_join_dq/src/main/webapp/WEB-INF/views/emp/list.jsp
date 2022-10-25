 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<script>

<%--	
	<c:if test="${not empty param.msg}">
		alert("${param.msg}");  
	</c:if>
	--%>
	<c:if test="${not empty msg}">
		alert("${msg}");  
	</c:if>

</script>

	<jsp:include page="/WEB-INF/views/menu.jsp"/>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 목록</h2>
		</div>
		<!-- <div class="row mt-3">
			<form class="text-center">
				<input type="text" name="dname" placeholder="부서명을입력하세요"/>
				<input type="text" name="loc" placeholder="지역을 입력하세요"/>
				<input type="submit" value="검색"/>
			</form>
		</div> -->
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>사원번호</th>
						<th>사원이름</th>
						<th>담당업무</th>
						<th>급여</th>
						<th>부서번호</th>
					</tr>			
				</thead>
				<tbody>
				
				<c:choose>
					<c:when test="${empty empList}">	
						<tr> <td colspan="4">등록된 부서정보가 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.empList}" 
							var="emp" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${emp.empno}</td>
<%-- 								<td><a href="${root}/dept/detail.do?deptno=${dept.deptno}">${dept.dname}</a></td> --%>
								<td><a href="${root}/emp/detail_with_dept.do?empno=${emp.empno}">${emp.ename}</a></td>
								<td>${emp.job}</td>
								<td>${emp.sal}</td>
								<td>${emp.deptno}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			
				</tbody>
			</table>
		</div>	
	</div>
</body>
</html>