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
        String name = null;
    %>
    <%
        try{
            //加载驱动程序
            Class.forName(driver);
            conn.DriverManager.getConnection(url, username, password);
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
</body>


</html>