<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisIsANewpage</title>
</head>
<body>
	<%
	int i = 0 ; 
	for (;i<10;i++){
		out.print(i+"</br>");
	}
	%>
	<%="这是一句直接输出的语句" %>
	<%!
	public String a;
	public void show(){
		a = "这个标志符表示，在这个区域可以定义全局变量，还可以定义方法";
	}
	%>
	<%show(); 
	out.print("</br>"+a);
	%>

</body>
</html>