<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //局部变量、Java语句
    out.println("ahjfshjasfkja");
%>
<%!
    //全局变量、定义方法
    public String a = "定义全局变量、定义方法";
    public void k(String m){
        a = m;
    }
%>
<%="这种表示应该输出表达式"+a%>
</body>
</html>
