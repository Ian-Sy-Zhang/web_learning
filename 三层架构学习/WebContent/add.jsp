<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method = "post">
		ID:<input type="text" name = "sID"/><br/>
		name:<input type="text" name="sname"/><br/>
		age:<input type="text" name="sage"/><br/>
		address:<input type="text" name="saddress"/><br/>
		name:<input type="submit" value="新增"/><br/>
	</form>
</body>
</html>