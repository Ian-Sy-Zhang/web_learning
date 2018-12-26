<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:scriptlet>
		String url = "www.baidu.com";
	</jsp:scriptlet>
	<h2><%=url %></h2>
</body>
</html>