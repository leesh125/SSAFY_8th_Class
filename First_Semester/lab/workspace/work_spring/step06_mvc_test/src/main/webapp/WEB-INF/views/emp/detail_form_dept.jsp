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
	<jsp:include page="/WEB-INF/views/menu.jsp"/>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">사원 조회 with depts</h2>
		</div>
		<form method="post" action="${root}/emp/modify.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="empno">사원번호</label></th>
						<td><input type="text" name="empno" id="empno" 
									value="${emp.empno}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="ename">사원이름</label></th>
						<td><input type="text" name="ename" id="ename" 
							value="${emp.ename}"/></td>
					</tr>
					<tr>
						<th><label for="job">담당이름</label></th>
						<td><input type="text" name="job" id="job" 
							value="${emp.job}"/></td>
					</tr>
					<tr>
						<th><label for="sal">급여</label></th>
						<td><input type="text" name="sal" id="sal" 
							value="${emp.sal}"/></td>
					</tr>
					<tr>
						<th><label for="deptno">부서번호</label></th>
						<td><input type="text" name="deptno" id="deptno" 
								value="${emp.deptno}" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" 
								formaction="${root}/emp/remove.do" formmethod="get"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		
		<form method="post" action="" class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서이름</th>
						<th>지역</th>
						<th></th>
					</tr>			
				</thead>
					<c:choose>
						<c:when test="${not empty emp.dept}">
							<tbody>
								<tr>
									<td>${emp.dept.deptno }</td>
									<td>${emp.dept.dname }</td>
									<td>${emp.dept.loc }</td>
								</tr>
							</tbody>
						</c:when>
						<c:otherwise>
							<tbody>
								<tr><td colspan="5">배치된 부서 없습니다.</td></tr>
							</tbody>
						</c:otherwise>
					</c:choose>
			</table>
		</form>
	</div>
</body>
</html>


















