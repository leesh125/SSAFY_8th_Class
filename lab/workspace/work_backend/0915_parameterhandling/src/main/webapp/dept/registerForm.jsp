<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>부서 등록</h2>
	
	<form method="post" action="./register.do">
		<table>
			<tbody>
				<tr>
					<th><label for="deptno">부서번호</label></th>
					<td><input type="text" name="deptno" id="deptno"> </td>
				</tr>
				<tr>
					<th><label for="deptname">부서이름</label></th>
					<td><input type="text" name="dname" id="dname"> </td>
				</tr>
				<tr>
					<th><label for="loc">지역</label></th>
					<td><input type="text" name="loc" id="loc"> <br/> </td>
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
</body>
</html>