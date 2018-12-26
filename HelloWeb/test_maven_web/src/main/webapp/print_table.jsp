<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" >
	<%
		int rows = 0;
		int cols = 0;
		try{
			rows = Integer.parseInt(request.getParameter("row"));
			cols = Integer.parseInt(request.getParameter("col"));
		}catch(Exception e){}
		for (int i = 0 ; i < rows ; i ++){
	%>
		<tr>
		<%
			for(int j = 0 ; j < cols ; j ++){
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