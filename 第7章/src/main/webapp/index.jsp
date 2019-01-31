<%--
  Created by IntelliJ IDEA.
  User: appti
  Date: 2019-01-29
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册表单页</title>
</head>
<jsp:useBean id="reg" scope="request" class="cn.mldn.lxh.demo.Register"/>
<body>
    <form action="chesk.jsp" method="post">
        用户名:<input type="text" name="name" value="<jsp:getProperty name="reg" property="name"/>">
            <%=reg.getErrorMsg("errname")%> <br>
        年%nbsp%nbsp龄:<input type="text" name="email" value="<jsp:getProperty name="reg" property="email">">
    </form>
</body>
</html>