<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//设置编码
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("uage"));
		String password = request.getParameter("upwd");
		String[] hobbies = request.getParameterValues("uhobbies");
	%>
	注册成功。信息如下：<br/>
	<table border = "1">
		<tr>
			<td>姓名</td>
			<td><%=name %>></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><%=age %>></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><%=password %>></td>
		</tr>
		<tr>
			<td>爱好</td>
			<% 
				if(hobbies != null){
				for (int i = 0 ; i < hobbies.length ; i ++){
			%>
			<!-- 这里的格式不会因为看似这个东西不在循环里边就只被遍历一次
				 而且两边的td标示也不会在遍历的时候丢失
			 -->
			<td><%= hobbies[i]%></td>
			<% 
				}
				}
			%>
		</tr>
		
	</table>
	

</body>
</html>