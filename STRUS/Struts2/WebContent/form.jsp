<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/form2.action " method="post">
		username:<input type="text" name="username"/>
		<br/>
		passwpord:<input type="text" name ="password"/>
		<br/>
		address:<input type = "text" name ="address"/>
		<br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>