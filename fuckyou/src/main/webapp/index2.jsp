<%--
  Created by IntelliJ IDEA.
  User: appti
  Date: 2018-12-26
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>233333</title>
</head>
<body>
    <%="</br>一般而言，如果修改web.xml,配置文件，Java，需要重新启动服务器"%>
    <%
        out.println("</br>这里如果用println是不会有换行的，因为最终jsp会转化成html");
        out.println("如果你需要换行，那么久直接br标签"+"</br>");
    %>
    但是如果修改jsp,html,css,js，一般不需要重新启动服务器

</body>
</html>
