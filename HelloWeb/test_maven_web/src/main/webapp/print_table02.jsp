<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<!--如果一个for语句写在了很多的jsp块中，那么一定要注意}是否正确使用-->
		<%
			int rows= 10;
			int cows = 10;
			for (int i = 0 ; i < rows ; i ++){
		%>
		<tr>
		<%
			for (int j = 0 ; j <cows ; j ++){
		%>
			<td><%=(i*j) %></td>
		<%
			}
		%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>