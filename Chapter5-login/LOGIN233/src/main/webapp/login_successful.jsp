<%@page contentType="text/html; charset=GBK" %>
<html>
<head>
    <title>登陆成功页面</title>
</head>

<body>
    <center>
        <h1>
            登陆操作
        </h1>
        <hr>
        <h2>
            登陆成功
        </h2>
        <h2>
            训练次数是<font color="red"><%= request.getParameter("utimes")%></font>
        </h2>
    </center>

</body>

</html>