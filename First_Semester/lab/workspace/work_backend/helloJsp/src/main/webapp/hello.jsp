<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private String name;

public void init() {
	name = "홍길동";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>hello JSP!</h2>
	<h2>안녕 <%= name %>님</h2>
</body>
</html>