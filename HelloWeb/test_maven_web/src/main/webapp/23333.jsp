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
	<%="这是一句直接输出的语句。尽量不要用out.print这种方法输出，用表达式输出会更好" %>
	<%!
	public String a;
	public void show(){
		//但是尽量不要在jsp之中定义方法或者类。当jsp需要类或者方法的时候，往往会通过JavaBean的形式调用
		a = "这个标志符表示，在这个区域可以定义全局变量，还可以定义方法，甚至可以定义类";
	}
	%>
	<%show(); 
	out.print("</br>"+a);
	%>

</body>
</html>