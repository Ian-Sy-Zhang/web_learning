<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "error.jsp"
%>
<!--一旦出现错误之后就会跳转到相关的页面 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int result = 10/0;
	%>
<h1>欢迎光临本页面</h1>
</body>
</html>