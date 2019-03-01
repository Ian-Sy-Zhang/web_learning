<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆成功</title>
</head>
<body>
	登陆成功！
	<br/>
	<h2>
	欢迎同学
	<%
		String userId = (String)session.getAttribute("ID");
	%>
	<%=userId %>
	</h2>
	<br/>
	<form action="Update" method="post">
		<input type="submit" value="签到">
	</form>
	
	
	
</body>
</html>