<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	
	<div class="container">
		<div class="row">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">상품 목록</h2>
		</div>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품코드</th>
						<th>모델명</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
			<c:choose>
				<c:when test="${empty products }">
					<tr>
						<td colspan="4">등록된 부서정보가 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.products}" 
						var="product" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${product.code}</td>
							<td><a href="${root}/product/detail.do?code=${product.code}">${product.model}</a></td>
							<td>${product.price}</td>		
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