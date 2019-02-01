<%@page import="myWebProject1.dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="myWebProject1.dao.LoginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("uname");
		String id = request.getParameter("upwd");
		LoginDao dao = new LoginDao();
		int result = dao.login(name, id);
		if (result > 0 ){
			out.print("success");
		}
		else if(result == 0){
			out.print("wrong pwd");
		}
		else{
			out.print("Fuck");
		}
	%>
</body>
</html>