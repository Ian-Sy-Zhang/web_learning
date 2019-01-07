<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>check页</title>
</head>

<body>
    <%!
        public static String driver = "com.mysql.cj.jdbc.Driver";
        public static String url = "jdbc:mysql://localhost:3306/bunoob"+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        public static String username = "root";
        public static String password = "zsy999666.";
    %>
    <%
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;
        String times = null;
    %>
    <%
        try{
            //加载驱动程序
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT times FROM students WHERE id = ? and name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,request.getParameter("id"));
            pstmt.setString(2,request.getParameter("name"));
            rs = pstmt.executeQuery();
            if (rs.next()){
                times = rs.getString(1);
                flag = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    %>
    <%
        if (flag){
    %>
        <jsp:forward page="login_successful.jsp">
            <jsp:param name="utimes" value="<%=times%>"/>
        </jsp:forward>
    <%
        }else {
    %>
        <jsp:forward page="login_failure.html"/>
    <%
        }
    %>

</body>


</html>