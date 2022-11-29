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
			<h2 class="bg-primary text-light text-center">사원 등록</h2>
		</div>
		<c:if test="${errorMsg != null}">
			<div class="row mt-3">
				<h4 class="bg-warning text-light text-center">${errorMsg}</h4>
			</div>		
		</c:if>

		<form method="post" action="${root}/emp/register.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="empno">사원번호</label></th>
						<td><input type="text" name="empno" id="empno"/></td>
					</tr>
					<tr>
						<th><label for="ename">사원이름</label></th>
						<td><input type="text" name="ename" id="ename"/></td>
					</tr>
					<tr>
						<th><label for="job">담당업무</label></th>
						<td><input type="text" name="job" id="job"/></td>
					</tr>
					<tr>
						<th><label for="sal">급여</label></th>
						<td><input type="text" name="sal" id="sal"/></td>
					</tr>
					<tr>
						<th><label for="deptno">부서번호</label></th>
						<td><input type="text" name="deptno" id="deptno"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>