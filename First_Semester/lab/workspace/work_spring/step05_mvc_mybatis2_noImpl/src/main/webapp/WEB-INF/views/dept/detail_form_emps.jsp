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
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 조회 with emps</h2>
		</div>
		<form method="post" action="${root}/dept/modify.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="deptno">부서번호</label></th>
						<td><input type="text" name="deptno" id="deptno" value="${requestScope.dept.deptno}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="dname">부서이름</label></th>
						<td><input type="text" name="dname" id="dname" value="${requestScope.dept.dname}"/></td>
					</tr>
					<tr>
						<th><label for="loc">지역</label></th>
						<td><input type="text" name="loc" id="loc" value="${requestScope.dept.loc}"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" formaction="${root}/dept/delete.do" formmethod="get"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<form method="post" action="${root}/emp/delete.do" class = "row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>사원번호</th>
						<th>사원이름</th>
						<th>직무</th>
						<th>월급여</th>
					</tr>
				</thead>
				
					<c:choose>
						<c:when test="${not empty dept.emps }">
						<tbody>
							<c:forEach items="${dept.emps}" var="emp">
								<tr>
									<td>${emp.empno }</td>
									<td>${emp.ename }</td>
									<td>${emp.job }</td>
									<td>${emp.sal }</td>
									<td>
										<input type="checkbox" name="empno" value="${emp.empno }" />
									</td>
								</tr>
								
							</c:forEach>
						  </tbody>
						  <tfoot>
									<tr>
										<td>
											<input type="submit" value="수정" />
											<input type="submit" value="삭제" />
										</td>
									</tr>
								</tfoot>
						</c:when>
						<c:otherwise>
							<tr><td colspan="5">배치된 사원이 없습니다.</td></tr>						
						</c:otherwise>
					</c:choose>
			</table>
		</form>
	</div>
</body>
</html>